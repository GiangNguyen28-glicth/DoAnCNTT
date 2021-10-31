<%@include file="/common/taglib.jsp" %>
<c:url var="APIForgot" value="/api-user-forgot/"/>


<section class="page-banner">
    <div class="container">
        <div class="page-banner-in">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-12">
                    <h1 class="page-banner-title text-uppercase">Forgot password</h1>
                </div>
                <div class="col-xl-6 col-lg-6 col-12">
                    <ul class="right-side">
                        <li><a href="<c:url value="/trang-chu"/>">Home</a></li>
                        <li>Forgot password</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="login pt-100">
    <div class="container">
        <div class="billing-details">
            <h2 class="checkout-title text-uppercase text-center mb-30">FORGOT PASSWORD</h2>
            <div id="notification"></div>
            <form class="checkout-form" id="formLoginForgot"
                  method="post">
                <div class="form-group">
                    <label class="form-label">Email</label>
                    <input type="text" id="email" name="email" class="form-control"
                           placeholder="Email" required>
                    <span id="validate_email" style="color: red"></span>
                </div>
                <div class="login-btn-g">
                    <div class="row">
                        <div class="col-8">
                            <button id="btnForgotPassword" name="btnForgotPassword"
                                    type="button"
                                    class="btn btn-color right-side">
                                Send email
                            </button>
                        </div>
                    </div>
                </div>
            </form>
            <input id="emailHidden" class="emailHidden" type="hidden">
            <div class="new-account text-center mt-20">
                <span>Don't have an account?</span>
                <a class="link" title="Create New Account" href="<c:url value='/dang-ky'/>">Create
                    New Account</a>
            </div>
        </div>
    </div>
</section>

<script>

  $('#btnForgotPassword').click(function (e) {
    console.log($('#email').val())
    if ($('#email').val() === '' || $('#email').val().length < 5) {
      document.getElementById(
          'validate_email').innerHTML = 'Email not blank and length is grater than or equal to 6 characters'
      return;
    } else if (!isValidEmailAddress($('#email').val())) {
      document.getElementById(
          'validate_email').innerHTML = 'Email is not correct! example pattern: nguyenvana@gmail.com'
      return;
    } else {
      clearErrorEmail();
      e.preventDefault();
      var email = $('#email').val();
      getEmail(email);
    }
  })

  function clearErrorEmail() {
    document.getElementById(
        'validate_email').innerHTML = '';
  }

  function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
    return pattern.test(emailAddress);
  };

  function getEmail(email) {
    $.ajax({
      url: '${APIForgot}' + email,
      type: 'Get',
      contentType: 'application/json',
      dataType: 'json',
      success: function (result) {
        console.log(result)
        if (!result) {
          $('#notification').html(`
                    <div class="alert alert-danger">
                            Email not exists!
                    </div>`)
        } else {
          $('#notification').html(`
                    <div class="alert alert-success">
                            Please check verify email!</div>`)
        }
      },
      error: function (result) {
        console.log('Failed!')
      }
    });
  }
</script>

