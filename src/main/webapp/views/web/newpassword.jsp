<%@include file="/common/taglib.jsp" %>
<c:url var="APIForgot" value="/api-user-forgot/"/>
<c:url var="LoginUrl" value="/dang-nhap"/>
<section class="page-banner">
    <div class="container">
        <div class="page-banner-in">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-12">
                    <h1 class="page-banner-title text-uppercase">Set Password</h1>
                </div>
                <div class="col-xl-6 col-lg-6 col-12">
                    <ul class="right-side">
                        <li><a href="<c:url value="/trang-chu"/>">Home</a></li>
                        <li>Set password</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="login pt-100">
    <div class="container">
        <div class="billing-details">
            <h2 class="checkout-title text-uppercase text-center mb-30">SET PASSWORD</h2>
            <form class="checkout-form" id="formSubmit"
                  method="post">
                <div class="form-group">
                    <label class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control"
                           placeholder="Password" required>
                    <span id="user_password" style="color: red"></span>
                    <label class="form-label">Repassword</label>
                    <input type="password" id="repassword" name="repassword" class="form-control"
                           placeholder="Repassword" required>
                    <span id="user_repassword" style="color: red"></span>
                </div>
                <div class="login-btn-g">
                    <div class="row">
                        <div class="col-8">
                            <button id="btnNewPassword" name="btnNewPassword" type="button"
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
<script>


  $('#btnNewPassword').click(function (e) {
    if ($('#password').val() === '' || $('#password').val().length < 5) {
      document.getElementById(
          'user_password').innerHTML = 'password length is greater than or equal to 6 characters'
      return;
    } else if ($('#repassword').val() === '' || $('#repassword').val().length < 5) {
      document.getElementById(
          'user_password').innerHTML = 'password length is greater than or equal to 6 characters'
      return;
    } else if ($('#repassword').val().localeCompare($('#password').val()) != 0) {
      document.getElementById(
          'user_repassword').innerHTML = 'password and repassword is not the same'
      return;
    } else {
      e.preventDefault();
      clearErrorPassword();
      var data = {};
      var formData = $('#formSubmit').serializeArray();
      $.each(formData, function (i, v) {
        data["" + v.name + ""] = v.value;
      });
      setPassword(data)
    }
  })

  function clearErrorPassword() {
    document.getElementById(
        'user_password').innerHTML = '';
    document.getElementById(
        'user_repassword').innerHTML = '';
  }

  function setPassword(data) {
    $.ajax({
      url: '${APIForgot}',
      type: 'PUT',
      contentType: 'application/json',
      data: JSON.stringify(data),
      dataType: 'json',
      success: function (result) {
        if (result) {
          window.location.href = "${LoginUrl}?action=login&message=setPassword_success&alert=success"
        } else {
          console.log('Update password failed!')
        }
      }
    })
  }
</script>


