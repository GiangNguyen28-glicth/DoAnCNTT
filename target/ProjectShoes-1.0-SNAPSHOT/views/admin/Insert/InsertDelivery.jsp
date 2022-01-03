<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="APIDelivery" value="/api-delivery"/>
<html>
<body>
<form id="formdelivery">
    <div class="page-header">
        <h1 class="page-heading">Create - Edit Delivery</h1>
        <ul class="list-inline text-sm">
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-copy me-2"> </i>Duplicate</a></li>
            <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-download me-2"> </i>Export</a></li>
        </ul>
    </div>
    <section>
        <div class="row mb-5">
            <div class="col-lg-8 col-xxl-9 mb-4 mb-lg-0">
                <div class="card mb-4">
                    <div class="card-header">
                        <div class="card-heading">Main Info </div>
                    </div>
                    <div class="card-body">
                        <div class="row gy-3">
                            <div class="col-12">
                                <label class="form-label fw-bold">Delivery Name</label>
                                <div class="input-group">
                                    <div class="input-group-text"><i class="fas fa-truck"></i></div>
                                    <input name="name" class="form-control" value="${deliveryModel.name}">
                                </div>
                            </div>
                            <div class="col-12 col-lg-6 text-sm">
                                <label class="form-label text-muted">Shipper</label>
                                <div class="input-group">
                                    <div class="input-group-text"><i class="fas fa-walking"></i></div>
                                    <input name="shipper" class="form-control" value="${deliveryModel.shipper}">
                                </div>
                            </div>
                            <div class="col-12 col-lg-6 text-sm">
                                <label class="form-label text-muted">Delivery Date (*)</label>
                                <div class="input-group">
                                    <div class="input-group-text"><i class="fas fa-clock"></i> </div>
                                    <input name="deliveryDate" class="form-control" value="${deliveryModel.deliveryDate}">
                                </div>
                            </div>
                            <div class="col-12 col-lg-6 text-sm">
                                <label class="form-label text-muted">Status</label>
                                <div class="input-group">
                                    <div class="input-group-text"><i class="fas fa-toggle-on"></i> </div>
                                    <input name="status" class="form-control" value="${deliveryModel.status}">
                                </div>
                            </div>

                        </div>
                        <div style="margin-top: 10px" class="form-text" id="notification"></div>
                        <input type="hidden" value="${deliveryModel.id}" id="id" name="id"/>
                        <c:if test="${empty deliveryModel}">
                            <button id="btnAddOrUpdate" style="margin-top: 10px" class="btn btn-outline-primary mb-4">Add Delivery</button>
                        </c:if>
                        <c:if test="${not empty deliveryModel}">
                            <button id="btnAddOrUpdate" style="margin-top: 10px" class="btn btn-outline-primary mb-4">Update</button>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>
    </section>
</form>
<script>
    $('#btnAddOrUpdate').click(function (e) {
        e.preventDefault(); // submit về 1 API
        var data = {};
        var formData = $('#formdelivery').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        var id = $('#id').val();
        if (id == "") {
            addDelivery(data);
        } else {
            updateDelivery(data);
        }
    });
    function addDelivery(data) {
        $.ajax({
            url: '${APIDelivery}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                $('#notification').html(`
                    <div class="alert alert-success">
                            Congratulations, Add Product profile success
                    </div>`)
            },
            error: function (error) {
                $('#notification').html(`
                    <div class="alert alert-danger">
                            Failed!
                    </div>`)
            }
        });
    }
    function updateDelivery(data) {
        $.ajax({
            url: '${APIDelivery}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                $('#notification').html(`
                    <div class="alert alert-success">
                            Congratulations, Update profile success
                    </div>`)
            },
            error: function (error) {
                $('#notification').html(`
                    <div class="alert alert-danger">
                            Failed!
                    </div>`)
            }
        });
    }
</script>
</body>
</html>

