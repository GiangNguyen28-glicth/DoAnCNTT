<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APICategory" value="/api-category"/>
<!DOCTYPE html>
<html>
<body>
<div class="page-header">
    <h1 class="page-heading">Categories</h1>
</div>
<section>
    <div class="row mb-5">
        <div class="col-lg-4">
            <div class="card mb-4 mb-lg-0">
                <div class="card-body">
                    <form id="formcategory">
                        <div class="mb-4">
                            <label class="form-label" for="categoryName">Name</label>
                            <input name="code" class="form-control" id="categoryName" type="text">
                            <div class="form-text">The name is how it appears on your site.</div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label" for="categorySlug">Slug</label>
                            <input class="form-control" id="categorySlug" type="text">
                            <div class="form-text">The “slug” is the URL-friendly version of the name. It is usually all lowercase and contains only letters, numbers, and hyphens.</div>
                        </div>
                    </form>
                    <div class="form-text" id="notification"></div>
                    <button id="btnaddCategory" class="btn btn-primary mb-4">Add New Category</button>
                </div>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="card card-table">
                <div class="preload-wrapper">
                    <table class="table table-hover mb-0" id="categoryDatatable">
                        <thead>
                        <tr>
                            <th style="width: 20px;"> </th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Createddate</th>
                            <th>CreatedBy</th>
                            <th>ModifiedBy</th>
                            <th>ModifiedDate</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${categoryModel.listResult}">
                            <tr>
                                <td><span class="form-check"><input class="form-check-input" type="checkbox"></span></td>
                                <td><a href="javascript:void(0)" class="text-decoration-none text-reset fw-bolder">${item.id}</a></td>
                                <td>${item.code}</td>
                                <td>${item.createdDate}</td>
                                <td>${item.createdBy}</td>
                                <td>${item.modifiedBy}</td>
                                <td>${item.modifiedDate}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table><span class="me-2" id="categoryBulkAction">
                      <select class="form-select form-select-sm d-inline w-auto mb-1 mb-lg-0" name="categoryBulkAction">
                        <option>Bulk Actions</option>
                        <option>Delete</option>
                      </select>
                      <button class="btn btn-sm btn-outline-primary align-top mb-1 mb-lg-0">Apply</button></span>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    $('#btnaddCategory').click(function (e) {
        e.preventDefault(); // submit về 1 API
        var data = {};
        var formData = $('#formcategory').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        addCategory(data);
    });
    function addCategory(data) {
        $.ajax({
            url: '${APICategory}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                $('#notification').html(`
                    <div class="alert alert-success">
                            Congratulations,Delete Product success
                    </div>`)
            },
            error: function (error) {
                console.log("Error")
            }
        });
    }
</script>
</body>
<html>
