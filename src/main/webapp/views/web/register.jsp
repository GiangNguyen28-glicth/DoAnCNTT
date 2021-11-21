<%@include file="/common/taglib.jsp" %>
<c:url var="APIuser" value="/api-user"/>
<c:url var="LoginUrl" value="/dang-nhap"/>
<c:url var="otpUrl" value="/otp"/>
<c:url var="RegisterUrl" value="/dang-ky"/>
<head>
    <title>Forgot password</title>
    <meta charset="utf-8">
</head>
<body>
<section class="page-banner">
    <div class="container">
        <div class="page-banner-in">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-12">
                    <h1 class="page-banner-title text-uppercase">REGISTER</h1>
                </div>
                <div class="col-xl-6 col-lg-6 col-12">
                    <ul class="right-side">
                        <li><a href="<c:url value="/trang-chu"/>">Home</a></li>
                        <li>Register</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="login pt-100">
    <div class="container">
        <div class="billing-details">
            <h2 class="checkout-title text-uppercase text-center mb-30">CREATE ACCOUNT</h2>
            <div id="notification" class="checkout-title  text-uppercase text-center mb-30">
            </div>
            <form class="checkout-form" id="formSubmit">
                <div class="form-group">
                    <label class="form-label">Username</label>
                    <input type="text" id="username" name="username" class="form-control"
                           placeholder="Username" required>
                    <span id="user_username" style="color: red"></span>
                </div>
                <div class="form-group">
                    <label class="form-label">Email address</label>
                    <input type="text" id="email" name="email" class="form-control"
                           placeholder="Email Address" required>
                    <span id="user_email" style="color: red"></span>

                </div>
                <div class="form-group">
                    <label class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control"
                           placeholder="Enter your Password"
                           required>
                    <span id="user_password" style="color: red"></span>


                </div>
                <div class="form-group">
                    <label class="form-label">Re-enter Password</label>
                    <input type="password" id="repassword" name="repassword" class="form-control"
                           placeholder="Re-enter Password"
                           required>
                    <span id="user_repassword" style="color: red"></span>

                </div>
                <div class="login-btn-g">
                    <div class="row">
                        <div class="col-12">
                            <button id="btnAddUser" type="button" class="btn btn-color right-side">
                                Sign up
                            </button>
                        </div>
                    </div>
                </div>
                <div class="new-account text-center mt-20">
                    <span>Already have an account with us</span>
                    <a class="link" title="Create New Account"
                       href="<c:url value="/dang-nhap?action=login"/>">Login Here</a>
                </div>
            </form>
        </div>
    </div>
</section>
<script>
  $('#btnAddUser').click(function (e) {
    if ($('#username').val() === '' || $('#username').val().length < 5) {
      document.getElementById(
          'user_username').innerHTML = 'username length is greater than or equal to 6 characters'
      return;
    } else if ($('#password').val() === '' || $('#password').val().length < 5) {
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
    } else if ($('#email').val().length < 5) {
      document.getElementById(
          'user_email').innerHTML = 'Email length is greater than or equal to 6 characters'
      return;
    } else if (!isValidEmailAddress($('#email').val())) {
      document.getElementById(
          'user_email').innerHTML = 'Email is not correct! example pattern: nguyenvana@gmail.com'
      return;
    } else {
      clearError();
      e.preventDefault(); // submit về 1 API
      var data = {};
      var formData = $('#formSubmit').serializeArray();
      $.each(formData, function (i, v) {
        data["" + v.name + ""] = v.value;
      });
      addUser(data);
    }
  });

  function clearError() {
    document.getElementById(
        'user_username').innerHTML = ''
    document.getElementById(
        'user_email').innerHTML = ''
    document.getElementById(
        'user_password').innerHTML = ''
    document.getElementById(
        'user_repassword').innerHTML = ''
  }

  function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
    // alert( pattern.test(emailAddress) );
    return pattern.test(emailAddress);
  };

  function addUser(data) {
    $.ajax({
      url: '${APIuser}',
      type: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(data),
      dataType: 'json',
      success: function (result) {
        if (result['message'] == null) {
          window.location.href = "${otpUrl}?message=registerSuccess&alert=info"
        } else {
          $('#notification').html(`
               <div class="alert alert-danger">` + result['message'] + `</div>`)
        }
      },
    });
  }
</script>
</body>
