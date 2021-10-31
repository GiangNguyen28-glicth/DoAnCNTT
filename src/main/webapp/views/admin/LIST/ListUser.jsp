<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<div class="page-breadcrumb">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="/admin-home">Home</a></li>
        <li class="breadcrumb-item active">Users </li>
    </ul>
</div>
<div class="page-header d-flex justify-content-between align-items-center">
    <div>
        <h1 class="page-heading">Users</h1>
        <ul class="list-inline text-sm">
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-upload me-2"> </i>Import</a></li>
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-download me-2"> </i>Export</a></li>
        </ul>
    </div>
</div>
<section class="mb-5">
    <form id="formsubmit" action="<c:url value="/admin-user"/>" method="get">
        <div class="card card-table">
            <div class="preload-wrapper">
                <table class="table table-hover table-borderless align-middle mb-0" id="userDatatable">
                    <thead>
                    <tr>
                        <th style="padding-left: 10px"> </th>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Createddate</th>
                        <th>CreatedBy</th>
                        <th>ModifiedBy</th>
                        <th>ModifiedDate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${userModel.listResult}">
                        <c:if test="${item.roleId !=1}">
                            <tr>
                                <td style="padding-left: 10px"></td>
                                <td ><a href="javascript:void(-1)" class="text-decoration-none text-reset fw-bolder">${item.id}</a></td>
                                <td >${item.username}</td>
                                <td>${item.email}</td>
                                <td>${item.createdDate}</td>
                                <td>${item.createdBy}</td>
                                <td>${item.modifiedBy}</td>
                                <td>${item.modifiedDate}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
                <span class="me-2" id="categoryBulkAction">
                <label>Sort</label>
                <select id="sort" onchange="Sort(this)" class="form-select form-select-sm d-inline w-auto" name="categoryBulkAction">
                    <option value="" disabled selected>Choose your option</option>
                    <option>A-Z</option>
                    <option></option>
                </select>
            </span>
            </div>
        </div>
    </form>
</section>
<script>
    function Sort(param) {
        var message = document.getElementById('sort');
        var value = param.value;
        if (value === 'A-Z'){
            var table, rows, switching, i, x, y, shouldSwitch;
            table = document.getElementById("userDatatable");
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
