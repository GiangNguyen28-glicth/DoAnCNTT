<%@include file="/common/taglib.jsp"%>
<c:url var="APIProduct" value="/api-product"/>
<html>
<body>
<div class="page-breadcrumb">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="/admin-home">Home</a></li>
        <li class="breadcrumb-item active">Products </li>
    </ul>
</div>
<div class="page-header d-flex justify-content-between align-items-center">
    <div>
        <h1 class="page-heading">Products</h1>
        <ul class="list-inline text-sm">
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-upload me-2"> </i>Import</a></li>
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-download me-2"> </i>Export</a></li>
        </ul>
    </div>
    <div><a class="btn btn-primary text-uppercase" href="/admin-product?action=insert"> <i class="fa fa-plus me-2"> </i>Add new</a></div>
</div>
<section class="mb-5">
    <ul class="nav nav-tabs mb-5" role="tablist">
        <li class="nav-item"><a class="nav-link active" href="#">All products</a></li>
        <li class="nav-item"><a class="nav-link text-reset" href="#!">Archived</a></li>
        <li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Drafts</a></li>
        <li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Out of stock</a></li>
    </ul>
    <form id="formsubmit" action="<c:url value="/admin-product"/>" method="get">
        <div class="card card-table">
            <div class="preload-wrapper">
                <table class="table table-hover table-borderless align-middle mb-0" id="productsDatatable">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th style="min-width: 200px;">Product Name</th>
                        <th>Price</th>
                        <th>Size</th>
                        <th>Quantity</th>
                        <th>Category_ID</th>
                        <th>Createddate</th>
                        <th>CreatedBy</th>
                        <th>ModifiedBy</th>
                        <th>ModifiedDate</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${productModel.listResult}">
                        <tr class="align-middle">
                            <td>
                                <span class="form-check">
                                    <input class="form-check-input" type="checkbox" id="check${item.id}" value="${item.id}">
                                    <label class="form-check-label" for="check${item.id}">${item.id}</label>
                                </span>
                            </td>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td>${item.size}</td>
                            <td>${item.quantity}</td>
                            <td>${item.categoryId}</td>
                            <td class="text-muted">${item.createdDate}</td>
                            <td class="text-muted">${item.createdBy}</td>
                            <td class="text-muted">${item.modifiedBy}</td>
                            <td class="text-muted">${item.modifiedDate}</td>
                            <td><a class="me-3 text-lg text-success"
                                   href="/admin-product?action=edit&&productid=${item.id}"><i class="far fa-edit"></i></a><a class="text-lg text-danger" onclick="deleteProduct(${item.id})" href="">
                                <i class="far fa-trash-alt"></i></a></td>
                        </tr>
                        <input type="hidden" value="${productModel.id}" id="id${productModel.id}" name="id${productModel.id}"/>
                    </c:forEach>
                    </tbody>
                </table>
                <span class="me-2" id="categoryBulkAction">
                <label>Sort</label>
                <select id="sort" onchange="Sort(this)" class="form-select form-select-sm d-inline w-auto" name="categoryBulkAction">
                    <option value="" disabled selected>Choose your option</option>
                    <option>A-Z</option>
                    <option>Price</option>
                </select>
                <button id="btndelete" class="btn btn-sm btn-outline-primary align-top">Delete</button>
            </span>
            </div>
        </div>

        <input type="hidden" value="" id="page" name="page"/>
        <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
    </form>
</section>
<div style="margin-left: 415px"><ul class="pagination" id="pagination"></ul></div>

<script>
    $("#btndelete").click(function() {
        var data = {};
        var ids = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['ids'] = ids;
        deleteProduct(data);
    });
    function deleteProduct(data) {
        if(typeof (data)==="number"){
            var data2={};
            data2['ids']=[data];
            data=data2;
        }
        $.ajax({
            url: '${APIProduct}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                $('#notification').html(`
                    <div class="alert alert-success">
                            Congratulations,Delete Product success
                    </div>`)
                window.location.href = "/admin-product?page=1&maxPageItem=2";
            },
            error: function (error) {
                console.log("Error")
            }
        });
    }
    function Sort(param) {
        var message = document.getElementById('sort');
        var value = param.value;
        if (value === 'A-Z'){
            var table, rows, switching, i, x, y, shouldSwitch;
            table = document.getElementById("productsDatatable");
            switching=true;
            while (switching) {
                switching = false;
                rows = table.rows;
                for (i = 1; i < (rows.length - 1); i++) {
                    // Start by saying there should be no switching:
                    shouldSwitch = false;
                    x = rows[i].getElementsByTagName("TD")[1];
                    y = rows[i + 1].getElementsByTagName("TD")[1];
                    // Check if the two rows should switch place:
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                }
                if (shouldSwitch) {
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                }
            }
        }
    }
    var totalPages = ${productModel.totalPage};
    var currentPage = ${productModel.page};
    var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 3,
            startPage: currentPage,
            onPageClick: function (event, page) {
                event.preventDefault();
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#formsubmit').submit();
                }
            }
        });
    });
</script>
</body>
</html>
