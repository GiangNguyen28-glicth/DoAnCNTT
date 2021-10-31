<%@include file="/common/taglib.jsp"%>
<c:url var="APIDeliveries" value="/api-delivery"/>
<html>
<body>
<div class="page-breadcrumb">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="/admin-home">Home</a></li>
        <li class="breadcrumb-item active">Deliveries</li>
    </ul>
</div>
<div class="page-header d-flex justify-content-between align-items-center">
    <div>
        <h1 class="page-heading">Deliveries</h1>
        <ul class="list-inline text-sm">
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-upload me-2"> </i>Import</a></li>
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-download me-2"> </i>Export</a></li>
        </ul>
    </div>
    <div><a class="btn btn-primary text-uppercase" href="/admin-delivery?action=insert"> <i class="fa fa-plus me-2"> </i>Add new</a></div>
</div>
<section class="mb-5">
    <ul class="nav nav-tabs mb-5" role="tablist">
        <li class="nav-item"><a class="nav-link active" href="#">All deliveries</a></li>
        <li class="nav-item"><a class="nav-link text-reset" href="#!">Archived</a></li>
        <li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Drafts</a></li>
        <li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Out of stock</a></li>
    </ul>
    <form id="formsubmit" action="<c:url value="/admin-delivery"/>" method="get">
        <div class="card card-table">
            <div class="preload-wrapper">
                <table class="table table-hover table-borderless align-middle mb-0" id="deliveryDatatable">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Shipper</th>
                        <th style="min-width: 200px;">Delivery Date</th>
                        <th>Status</th>
                        <th>Createddate</th>
                        <th>CreatedBy</th>
                        <th>ModifiedBy</th>
                        <th>ModifiedDate</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${deliveryModel.listResult}">
                        <tr class="align-middle">
                            <td>
                                    <input class="form-check-input" type="checkbox" id="check${item.id}" value="${item.id}">
                                    <label class="form-check-label" for="check${item.id}">${item.id}</label>
                            </td>
                            <td>${item.name}</td>
                            <td>${item.shipper}</td>
                            <td>${item.deliveryDate}</td>
                            <td>${item.status}</td>
                            <td>${item.createdDate}</td>
                            <td>${item.createdBy}</td>
                            <td>${item.modifiedBy}</td>
                            <td>${item.modifiedDate}</td>
                            <td><a class="me-3 text-lg text-success"
                                   href="/admin-delivery?action=edit&&deliveryid=${item.id}"><i class="far fa-edit"></i></a></td>
                        </tr>
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
                <button id="btnDelete" type="button"
                        class="btn btn-sm btn-outline-primary align-top" data-toggle="tooltip" title='Xoa bai viet'>
                    <span>
                        <i class="fa fa-trash-o bigger-110 pink"></i>
                    </span>
                    Delete
                </button>
                </span>
            </div>
        </div>
 </form>
</section>

<script>
    $("#btnDelete").click(function() {
        var data = {};
        var ids = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['ids'] = ids;
        deleteDelivery(data);
    });
    function deleteDelivery(data) {
        $.ajax({
            url: '${APIDeliveries}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                $('#notification').html(`
                    <div class="alert alert-success">
                            Congratulations,Delete Product success
                    </div>`)
                window.location.href = "/admin-delivery";
            },
            error: function (error) {
                $('#notification').html(`
                    <div class="alert alert-danger">
                            Failed!
                    </div>`)
            }
        });
    }
    function Sort(param) {
        var message = document.getElementById('sort');
        var value = param.value;
        if (value === 'A-Z'){
            var table, rows, switching, i, x, y, shouldSwitch;
            table = document.getElementById("deliveryDatatable");
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

</script>
</body>
</html>
