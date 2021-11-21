<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="noindex">
    <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css' />" />
    <!-- Google fonts - Popppins for copy-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700&amp;display=swap"
          rel="stylesheet">
    <!-- Prism Syntax Highlighting-->
    <link rel="stylesheet"
          href="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/vendor/prismjs/plugins/toolbar/prism-toolbar.css">
    <link rel="stylesheet"
          href="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/vendor/prismjs/themes/prism-okaidia.css">
    <!-- The Main Theme stylesheet (Contains also Bootstrap CSS)-->
    <link rel="stylesheet"
          href="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/css/style.default.c1992928.css"
          id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet"
          href="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/css/custom.0a822280.css">
    <!-- Favicon-->
    <link rel="shortcut icon"
          href="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/favicon.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/admin/js/jquery.2.1.1.min.js' />"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.2.8/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.2.8/firebase-storage.js"></script>
</head>
<body>
<%@include file="/common/admin/header.jsp" %>
<!-- header -->
<div class="d-flex align-items-stretch">
    <%@include file="/common/admin/menu.jsp" %>
    <div class="page-holder bg-gray-100">
        <div class="container-fluid px-lg-4 px-xl-5">
            <dec:body></dec:body>
        </div>
    </div>
</div>
<script src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
<script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
<!-- Data Tables-->
<script src="<c:url value="/template/admin/js/datatable.js"/>"></script>
<!-- CMS Category JS-->
<script src="<c:url value="/template/admin/js/e-commerce-products.ab70c491.js"/>">
</script>
<!-- User JS-->
<script src="<c:url value="/template/admin/js/user.js"/>">
</script>
<!-- Delivery JS-->
<script src="<c:url value="/template/admin/js/delivery.js"/>">
</script>

<!-- Saledetails JS-->
<script src="<c:url value="/template/admin/js/e-commerce-saledetails.ab70c491.js"/>">
</script>


<!-- Main Theme JS File-->
<script src="<c:url value="/template/admin/js/e-commerce-customers.9c7efe69.js"/>"></script>

<script src="<c:url value="/template/admin/js/cms-category.97f55715.js"/>"></script>
<!-- Main Theme JS File-->
<script src="<c:url value="/template/admin/js/theme.413b8ff4.js"/>"></script>
<script src="<c:url value="/template/admin/js/e-commerce-product-new.edd4e2e3.js"/>"></script>
<script src="<c:url value="/template/admin/js/e-commerce-orders.f8b9685e.js"/>"></script>
<!-- Prism for syntax highlighting-->
<script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

<script src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/vendor/prismjs/prism.js"></script>
<script src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/vendor/prismjs/plugins/normalize-whitespace/prism-normalize-whitespace.min.js"></script>
<script src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/vendor/prismjs/plugins/toolbar/prism-toolbar.min.js"></script>
<script src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/vendor/prismjs/plugins/copy-to-clipboard/prism-copy-to-clipboard.min.js"></script>
<script type="text/javascript">
  // Optional
  Prism.plugins.NormalizeWhitespace.setDefaults({
    'remove-trailing': true,
    'remove-indent': true,
    'left-trim': true,
    'right-trim': true,
  });
</script>
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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
      integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
      crossorigin="anonymous">
<!-- FontAwesome CSS - loading as last, so it doesn't block rendering-->
</body>
</html>