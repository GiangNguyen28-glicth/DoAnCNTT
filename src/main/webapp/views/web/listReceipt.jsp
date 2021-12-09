<%@include file="/common/taglib.jsp" %>
<html>
<header>

</header>
<body>
<form id="formSubmit">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">code</th>
            <th scope="col">name</th>
            <th scope="col">size</th>
            <th scope="col">price</th>
            <th scope="col">quantity</th>
            <th scope="col">total</th>
        </tr>
        </thead>
        <tbody id="myTable">
        <c:forEach var="item" items="${receipts}">
            <tr>
                <td>${item.code}</td>
                <td>${item.product.name}</td>
                <td>${item.product.size}</td>
                <td>${item.product.price}$</td>
                <td>${item.product.quantity}</td>
                <td>${item.total}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation">
        <input type="hidden" value="" id="page" name="page"/>
        <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
    </nav>
</form>
<div style="margin-left: 415px">
    <ul class="pagination" id="pagination"></ul>
</div>

<script>
  var totalPages = ${model.totalPage};
  var currentPage = ${model.page};
  var limit = 5; // tổng số item hiển thị trên 1 page
  $(function () {
    window.pagObj = $('#pagination').twbsPagination({
      totalPages: totalPages,
      visiblePages: 5,
      startPage: currentPage,
      onPageClick: function (event, page) {
        // kiểm tra điều kiện load lại trang
        if (currentPage !== page) {
          $('#maxPageItem').val(limit);
          $('#page').val(page);
          $('#formSubmit').submit();  //Dùng jquery để gọi tới đối tượng form
        }
      }
    }).on('page', function (event, page) {
      console.info(page + ' (from event listening)');
    });
  });
</script>

<script>
  $(document).ready(function () {
    $("#myInput").on("keyup", function () {
      var value = $(this).val().toLowerCase();
      $("#myTable tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });
</script>

<script>
  var th = jQuery('th'),
      li = jQuery('li'),
      inverse = false;

  th.click(function () {

    var header = $(this),
        index = header.index();

    header
    .closest('table')
    .find('td')
    .filter(function () {
      return $(this).index() === index;
    })
    .sortElements(function (a, b) {

      a = $(a).text();
      b = $(b).text();

      return (
          isNaN(a) || isNaN(b) ?
              a > b : +a > +b
      ) ?
          inverse ? -1 : 1 :
          inverse ? 1 : -1;

    }, function () {
      return this.parentNode;
    });

    inverse = !inverse;

  });

  $('button').click(function () {
    li.sortElements(function (a, b) {
      return $(a).text() > $(b).text() ? 1 : -1;
    });
  });
</script>
</body>
</html>
