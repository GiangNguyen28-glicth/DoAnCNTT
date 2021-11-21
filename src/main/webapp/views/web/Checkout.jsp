<%@include file="/common/taglib.jsp" %>
<section class="page-banner">
    <div class="container">
        <div class="page-banner-in">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-12">
                    <h1 class="page-banner-title text-uppercase">Thank You ${userModel.username} -Your Order Success</h1>
                </div>
                <div class="col-xl-6 col-lg-6 col-12">
                    <ul class="right-side">
                        <li><a href="<c:url value='/trang-chu'/> ">Home</a></li>
                        <li>200</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="pt-100 text-center">
    <div class="container">
        <div class="error-part">
            <div class="main-text">200</div>
            <h2 class="mb-30">Ooops! Thank you for order</h2>
            <a href="<c:url value='/trang-chu'/>" class="btn btn-color">Back To Home</a>
        </div>
    </div>
</section>