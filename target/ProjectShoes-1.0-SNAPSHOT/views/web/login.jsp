<%@include file="/common/taglib.jsp" %>
<c:url var="APILogin" value="/api-login"/>
<c:url var="APIHome" value="/trang-chu-api"/>
<script>
  <c:if test="${not empty type}">
  localStorage.setItem("jsessionid", ${cookie.jsessionid})
  console.log("successfull")
  </c:if>
</script>
<section class="page-banner">
    <div class="container">
        <div class="page-banner-in">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-12">
                    <h1 class="page-banner-title text-uppercase">Login</h1>
                </div>
                <div class="col-xl-6 col-lg-6 col-12">
                    <ul class="right-side">
                        <li><a href="<c:url value="/trang-chu"/>">Home</a></li>
                        <li>Login</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="login pt-100">
    <div class="container">
        <div class="billing-details">
            <h2 class="checkout-title text-uppercase text-center mb-30">CUSTOMER LOGIN</h2>
            <div class="text-center mb-5 mx-1 mx-md-4 mt-4">
                <c:if test="${not empty message}">
                    <div class="alert alert-${alert}">
                            ${message}
                    </div>
                </c:if>
            </div>
            <form class="checkout-form" action="<c:url value='/dang-nhap'/>" id="formLogin"
                  method="post">
                <div class="form-group">
                    <label class="form-label">Username</label>
                    <input type="text" id="username" name="username" class="form-control"
                           placeholder="Username" required>
                </div>
                <div class="form-group">
                    <label class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control"
                           placeholder="Enter your Password"
                           required>
                </div>
                <div class="login-btn-g">
                    <div class="row">
                        <div class="col-6">
                            <div class="check-box">
                                        <span>
								                <input type="checkbox" class="checkbox" id="account"
                                                       name="Create an Account?">
								                <label for="account">Remember Me</label>
								            </span>
                            </div>
                        </div>
                        <div class="col-6">
                            <input type="hidden" value="login" name="action">
                            <button name="submit" type="submit" class="btn btn-color right-side">Log
                                In
                            </button>
                        </div>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <div class="fb-login-button" data-width="" data-size="large"
                     data-button-type="login_with" data-layout="default"
                     data-auto-logout-link="false" data-use-continue-as="false"
                     data-scope="public_profile,email" data-onlogin="checkLoginState"></div>
            </div>
            <br>
            <div class="text-center">
                <div class="g-signin2" data-onsuccess="onSignIn" id="myP"
                     onclick="checkLoginGmail()"
                     style="display: inline-block; height: 40px; width: calc(231.200px); border-radius: 100%; padding-top: calc(0.6px)">
                </div>
                <div id="statusG">
                </div>
            </div>
            <br>
            <div class="text-center">
                <a title="Forgot Password" class="link forgot-password mtb-20"
                   href="<c:url value='/forgot-password'/>">Forgot
                    your password?</a>
            </div>
            <div class="new-account text-center mt-20">
                <span>Don't have an account?</span>
                <a class="link" title="Create New Account" href="<c:url value='/dang-ky'/>">Create
                    New Account</a>
            </div>
        </div>
    </div>
</section>

<script>
  function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
    console.log('statusChangeCallback');
    console.log(response);                   // The current login status of the person.
    if (response.status === 'connected') {   // Logged into your webpage and Facebook.
      testAPI();
    } else {                                 // Not logged into your webpage or we are unable to tell.
      document.getElementById('statusF').innerHTML = 'Please log ' +
          'into this webpage.';
    }
  }

  function checkLoginState() {               // Called when a person is finished with the Login Button.
    FB.getLoginStatus(function (response) {   // See the onlogin handler
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function () {
    FB.init({
      appId: '585165199352568',
      cookie: true,                     // Enable cookies to allow the server to access the session.
      xfbml: true,                     // Parse social plugins on this webpage.
      version: 'v12.0'           // Use this Graph API version for this call.
    });

    FB.getLoginStatus(function (response) {   // Called after the JS SDK has been initialized.
      statusChangeCallback(response);        // Returns the login status.
    });
  };

  function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me?fields=id,email,picture', function (response) {
      var data = {}
      data["username"] = response.id;
      data["email"] = response.email
      data["avatar"] = "https://graph.facebook.com/" + response.id + "/picture"
      addUser(data)
    });
  }
</script>

<script type="text/javascript">
  function onSignIn(googleUser) {
    $('#myP').click(function (e) {
      // window.location.href='success.jsp';
      var profile = googleUser.getBasicProfile();
      var imagurl = profile.getImageUrl();
      var name = profile.getName();
      var email = profile.getEmail();
      var data = {}
      data["username"] = email;
      data["email"] = email
      data["avatar"] = imagurl
      addUser(data)
    })
  }

</script>

<script>
  function myFunction() {
    gapi.auth2.getAuthInstance().disconnect();
    location.reload();
  }
</script>

<script>
  function addUser(data) {
    $.ajax({
      url: '${APILogin}',
      type: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(data),
      dataType: 'json',
      success: function (result) {
        console.log(result)
        window.location.href = "${APIHome}?id=" + result["username"]
      },
      error: function (result) {
        console.log(result)
      }
    });
  }

</script>



