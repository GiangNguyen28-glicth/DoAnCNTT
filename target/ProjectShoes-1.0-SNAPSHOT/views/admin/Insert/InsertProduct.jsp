<%@ include file="/common/taglib.jsp"%>
<c:url var="APIProduct" value="/api-product"/>
<html>
<body>

<form id="formproduct">
    <div class="page-header">
        <h1 class="page-heading">Product Name</h1>
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
                                <label class="form-label fw-bold">Product Name</label>
                                <div class="input-group">
                                    <div class="input-group-text">$</div>
                                    <input name="name" class="form-control" value="${productModel.name}">
                                </div>
                            </div>
                            <div class="col-12 col-lg-6 text-sm">
                                <label class="form-label text-muted">Size</label>
                                <div class="input-group">
                                    <div class="input-group-text">$ </div>
                                    <input name="size" class="form-control" value="${productModel.size}">
                                </div>
                            </div>
                            <div class="col-12 col-lg-6 text-sm">
                                <label class="form-label text-muted">Quantity</label>
                                <div class="input-group">
                                    <div class="input-group-text">$ </div>
                                    <input name="quantity" class="form-control" value="${productModel.quantity}">
                                </div>
                            </div>
                            <div class="col-12 col-lg-6 text-sm">
                                <label class="form-label text-muted">Price</label>
                                <div class="input-group">
                                    <div class="input-group-text">$ </div>
                                    <input name="price" class="form-control" value="${productModel.price}">
                                </div>
                            </div>
                            <div class="col-12 col-lg-6 text-sm">
                                <label class="form-label text-muted">Image</label>
                                <input type="file" id="avatar" name="avatar" class="form-control"
                                       placeholder="Avatar"
                                       required>
                            </div>
                        </div>
                        <div style="margin-top: 10px" class="form-text" id="notification"></div>
                        <input type="hidden" value="${productModel.id}" id="id" name="id"/>
                        <c:if test="${empty productModel}">
                            <button id="btnAddOrUpdate" style="margin-top: 10px" class="btn btn-outline-primary mb-4">Add Product</button>
                        </c:if>
                        <c:if test="${not empty productModel}">
                            <button id="btnAddOrUpdate" style="margin-top: 10px" class="btn btn-outline-primary mb-4">Update</button>
                        </c:if>

                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-xxl-3">
                <div class="card shadow-sm mb-4">
                    <div class="card-header py-4">
                        <h4 class="card-heading">Categorization</h4>
                    </div>
                    <div class="card-body">
                        <label class="form-label">Category</label>
                        <select class="form-select" name="categoryId">
                            <c:if test="${empty productModel.categoryId}">
                                <c:forEach var="item" items="${categoryModel.listResult}">
                                    <option value="${item.id}"> ${item.code}</option>
                                </c:forEach>
                            </c:if>
                            <c:if test="${not empty productModel.categoryId}">
                                <c:forEach var="item" items="${categoryModel.listResult}">
                                    <option value="${item.id}"
                                            <c:if test="${item.id == productModel.categoryId}">selected="selected"
                                            </c:if>>
                                            ${item.code}
                                    </option>
                                </c:forEach>
                            </c:if>
                        </select>
                        <hr class="bg-gray-500 my-4">
                        <label class="form-label">Stock</label>
                        <select class="form-select">
                            <option value="brand0"> Memora</option>
                        </select>
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
        var formData = $('#formproduct').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        const ref = firebase.storage().ref();
        const file = document.querySelector('#avatar').files[0];
        const metadata = {
            contentType: file.type
        };
        const name = file.name;
        const uploadIMG = ref.child(name).put(file, metadata);
        uploadIMG.then(snapshort => snapshort.ref.getDownloadURL())
            .then(url => {
                console.log(url);
                data["avatar"] = url;
                var id = $('#id').val();
                if (id == "") {
                    addProduct(data);
                    $('#formproduct')[0].reset();
                } else {
                    updateProduct(data);
                }
            })
            .catch(console.error)
    });
    function addProduct(data) {
        $.ajax({
            url: '${APIProduct}',
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
                console.log("Error")
            }
        });
    }
    function updateProduct(data) {
        $.ajax({
            url: '${APIProduct}',
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
                window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>

