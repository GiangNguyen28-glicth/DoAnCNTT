<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link tont-awesome.minype="image/x-icon"
          href="<c:url value='/template/web/images/fav-icon.png'/> " rel="icon">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/template/web/css/font-awesome.min.css'/> ">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/template/web/css/owl.carousel.css'/> ">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/template/web/css/glass-case.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/template/web/css/bootstrap.min.css'/> ">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/template/web/css/magnific-popup.css'/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/web/css/animate.css'/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/web/css/shoes.css'/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/web/css/shoes.css'/> ">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/template/web/css/responsive.css'/> ">
    <script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <div id="fb-root"></div>
    <script async defer crossorigin="anonymous"
            src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v12.0&appId=585165199352568&autoLogAppEvents=1"
            nonce="ZdUbvRBT"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-client_id"
          content="945852596576-qdpeq7msdshcetuudjfqfe3svda8rljk.apps.googleusercontent.com">
    <script id="mcjs">!function(c,h,i,m,p){m=c.createElement(h),p=c.getElementsByTagName(h)[0],m.async=1,m.src=i,p.parentNode.insertBefore(m,p)}(document,"script","https://chimpstatic.com/mcjs-connected/js/users/ca76a5435dd6fb7a8efb0d6d4/bf1216b35b28bc09bd94a89de.js");</script>
</head>
<body>

<%--<div id="preloader"></div>--%>
<div class="sidebar-search-wrap">
    <div class="sidebar-table-container">
        <div class="sidebar-align-container">
            <div class="search-closer right-side"></div>
            <div class="search-container">
                <form method="get" id="search-form">
                    <input type="text" id="s" class="search-input" name="s"
                           placeholder="Search text">
                </form>
                <span>Search and Press Enter</span>
            </div>
        </div>
    </div>
</div>
<!-- Search Screen end -->

<%@ include file="/common/web/header.jsp" %>
<dec:body/>
<%@ include file="/common/web/footer.jsp" %>


<script data-cfasync="false" src="<c:url value='/template/web/js/email-decode.min.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery-3.4.1.min.js'/>"></script>
<script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.magnific-popup.min.js'/>"></script>
<script src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>
<script src="<c:url value='/template/web/js/custom.js'/>"></script>
<script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.8/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.8/firebase-storage.js"></script>

<script type="module">
  const firebaseConfig = {
    apiKey: "AIzaSyCM8GPMn5mU7_B0Eg-kGiWZZ0DpVKDUZp0",
    authDomain: "hoaiphong-4cfd9.firebaseapp.com",
    projectId: "hoaiphong-4cfd9",
    storageBucket: "hoaiphong-4cfd9.appspot.com",
    messagingSenderId: "413471605092",
    appId: "1:413471605092:web:1aa136cb962420c557ba71",
    measurementId: "G-80ETZH4J6E"
  };
  firebase.initializeApp(firebaseConfig);
</script>
<script>

  /* ------------ Newslater-popup JS Start ------------- */
  $(window).on('load', function () {
    setTimeout(function () {
      mfp = $.magnificPopup.instance;
      if (!mfp.isOpen) {
        jQuery.magnificPopup.open({
          items: {
            // src: '#newslater-popup'
          },
          type: 'inline'
        }, 0);
      }
    }, 10000)
  });
  /* ------------ Newslater-popup JS End ------------- */
</script>


</body>

</html>
