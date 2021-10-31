<%@include file="/common/taglib.jsp"%>
<c:url var="APISaledetail" value="/api-saledetail"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<div class="page-breadcrumb">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="/admin-home">Home</a></li>
        <li class="breadcrumb-item active">Saledetail </li>
    </ul>
</div>
<div class="page-header d-flex justify-content-between align-items-center">
    <div>
        <h1 class="page-heading">Saledetails</h1>
        <ul class="list-inline text-sm">
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-upload me-2"> </i>Import</a></li>
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-download me-2"> </i>Export</a></li>
        </ul>
    </div>
</div>
<section class="mb-5">
    <form id="formsubmit" action="<c:url value="/admin-saledetail"/>" method="get">
        <div class="card card-table">
            <div class="preload-wrapper">

                <table class="table table-hover table-borderless align-middle mb-0" id="saledetailsDatatable">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>User_ID</th>
                        <th>Product_ID</th>
                        <th>Delivery_ID</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Status_delivery</th>
                        <th>Createddate</th>
                        <th>CreatedBy</th>
                        <th>ModifiedBy</th>
                        <th>ModifiedDate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${saledetailModel.listResult}">
                        <tr class="align-middle">
                            <td>
                                <input class="form-check-input" type="checkbox" id="checkbox_${item.id}" value="${item.id}">
                                <label class="form-check-label" for="check${item.id}">${item.id}</label>
                            </td>
                            <td>${item.userId}</td>
                            <td>${item.productId}</td>
                            <td>${item.deliveryId}</td>
                            <td>${item.quantity}</td>
                            <td>${item.total}</td>
                            <td>
                                <c:forEach var="rs" items="${deliveryModel.listResult}">
                                <c:if test="${rs.id==item.deliveryId}">
                                ${rs.status}
                                </c:if>
                            </c:forEach>
                            </td>
                            <td class="text-muted">${item.createdDate}</td>
                            <td class="text-muted">${item.createdBy}</td>
                            <td class="text-muted">${item.modifiedBy}</td>
                            <td class="text-muted">${item.modifiedDate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <span class="me-2" id="categoryBulkAction">
                <label>Sort</label>
                <select id="sort" onchange="Sort(this)" class="form-select form-select-sm d-inline w-auto" name="categoryBulkAction">
                    <option value="" disabled selected>Choose your option</option>
                    <option>A-Z</option>
                    <option>Total</option>
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
        deleteSaledetail(data);
    });
    function deleteSaledetail(data) {
        $.ajax({
            url: '${APISaledetail}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                $('#notification').html(`
                    <div class="alert alert-success">
                            Congratulations,Delete Product success
                    </div>`)
                // console.log(result)
                window.location.href = "/admin-saledetail";
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
            table = document.getElementById("saledetailsDatatable");
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
