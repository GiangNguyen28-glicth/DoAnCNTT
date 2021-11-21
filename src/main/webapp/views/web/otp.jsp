<%@include file="/common/taglib.jsp" %>
<c:url var="otpUrl" value="/otp"/>

<section class="page-banner">
    <div class="container">
        <div class="page-banner-in">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-12">
                    <h1 class="page-banner-title text-uppercase">OTP Verify</h1>
                </div>
                <div class="col-xl-6 col-lg-6 col-12">
                    <ul class="right-side">
                        <li><a href="<c:url value="/trang-chu"/>">Home</a></li>
                        <li>Otp verify</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="login pt-100">
    <div class="container">
        <div class="billing-details">
            <h2 class="checkout-title text-uppercase text-center mb-30">OTP Verification</h2>
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                        ${message}
                </div>
            </c:if>
            <form class="checkout-form" id="formSubmit" action="<c:url value="/otp"/>"
                  method="post">
                <div class="form-group">
                    <label class="form-label">Otp</label>
                    <input type="text" id="otp" name="otp" class="form-control"
                           placeholder="OTP" required>
                    <span id="user_otp" style="color: red"></span><br>
                </div>
                <div class="login-btn-g">
                    <div class="row">
                        <div class="col-8">
                            <button id="btnOtpverify" name="btnOtpverify" type="submit"
                                    class="btn btn-color right-side">
                                Submit
                            </button>
                        </div>
                    </div>
                </div>
            </form>
            <div class="new-account text-center mt-20">
                <span>Already have an account with us</span>
                <a class="link" title="Create New Account"
                   href="<c:url value="/dang-nhap?action=login"/>">Login Here</a>
            </div>
        </div>
    </div>
</section>
