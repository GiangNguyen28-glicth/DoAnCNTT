<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="APIProduct" value="/api-product"/>
<html>
<body>
<section class="page-banner">
    <div class="container">
        <div class="page-banner-in">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-12">
                    <h1 class="page-banner-title text-uppercase">Shop</h1>
                </div>
                <div class="col-xl-6 col-lg-6 col-12">
                    <ul class="right-side">
                        <li><a href="/trang-chu">Home</a></li>
                        <li>Shop</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<form id="formshop">
    <section class="product-list">
        <div class="container">
            <div class="row pt-100">
                <div class="col-xl-3 col-lg-4 col-12">
                    <div class="sidebar">
                        <div class="sidebar-default mb-30">
                            <div class="category-content">
                                <h2 class="cat-title text-uppercase">women</h2>
                                <ul class="category category-drop-down">
                                    <li>
                                        <span class="opener plus"></span>
                                        <a href="javascript:void(0)">Top</a>
                                        <ul class="category-sub">
                                            <li><a href="#">Mid Waterproof</a></li>
                                            <li><a href="#">Brogue shoe</a></li>
                                            <li><a href="#">Firecamp</a></li>
                                            <li><a href="#">Forclaz</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <span class="opener plus"></span>
                                        <a href="javascript:void(0)">Dresses</a>
                                        <ul class="category-sub">
                                            <li><a href="#">Mid Waterproof</a></li>
                                            <li><a href="#">Brogue shoe</a></li>
                                            <li><a href="#">Firecamp</a></li>
                                            <li><a href="#">Forclaz</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <span class="opener plus"></span>
                                        <a href="javascript:void(0)">Celebrities dress</a>
                                        <ul class="category-sub">
                                            <li><a href="#">Mid Waterproof</a></li>
                                            <li><a href="#">Brogue shoe</a></li>
                                            <li><a href="#">Firecamp</a></li>
                                            <li><a href="#">Forclaz</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="sidebar-default mb-30">
                            <div class="category-content">
                                <h2 class="cat-title text-uppercase">Filter By</h2>
                                <a class="btn small btn-filter" href="#">
                                    <i class="fa fa-close"></i><span>Clear all</span>
                                </a>
                            </div>
                            <div class="category-content filter-by">
                                <h2 class="cat-title text-uppercase">Categories</h2>
                                <ul class="category">
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="Tops" name="Tops">
                                            <label for="Tops">Tops (08)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="Dresses" name="Dresses">
                                            <label for="Dresses">Dresses (10)</label>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="category-content filter-by">
                                <h2 class="cat-title text-uppercase">Size</h2>
                                <ul class="category">
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="s1" name="s">
                                            <label for="s1">S</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="m" name="m">
                                            <label for="m">M</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="l" name="l">
                                            <label for="l">L</label>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="category-content filter-by">
                                <h2 class="cat-title text-uppercase">Color</h2>
                                <ul class="category">
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="Beige" name="Beige">
                                            <label for="Beige" class="beige">Beige (1)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="White" name="White">
                                            <label for="White" class="white">White (2)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="Black" name="Black">
                                            <label for="Black" class="black">Black (2)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="Orange" name="Orange">
                                            <label for="Orange" class="orange">Orange (3)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="Blue" name="Blue">
                                            <label for="Blue" class="blue">Blue (2)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="Green" name="Green">
                                            <label for="Green" class="green">Green (1)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="Yellow" name="Yellow">
                                            <label for="Yellow" class="yellow">Yellow (3)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="Pink" name="Pink">
                                            <label for="Pink" class="pink">Pink (1)</label>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="category-content filter-by">
                                <h2 class="cat-title text-uppercase">Price</h2>
                                <ul class="category">
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="price_1" name="Cotton">
                                            <label for="price_1">$68.00 - $72.00 (2)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="price_2" name="Cotton">
                                            <label for="price_2">$86.00 - $89.00 (1)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="price_3" name="Cotton">
                                            <label for="price_3">$99.00 - $103.00 (3)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="price_4" name="Cotton">
                                            <label for="price_4">$104.00 - $108.00 (2)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="price_5" name="Cotton">
                                            <label for="price_5">$109.00 - $113.00 (1)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="price_6" name="Cotton">
                                            <label for="price_6">$126.00 - $135.00 (2)</label>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="check-box">
                                            <input type="checkbox" class="checkbox" id="price_7" name="Cotton">
                                            <label for="price_7">$209.00 - $217.00 (3)</label>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-8 col-12">
                    <div class="shorting mb-30">
                        <div class="row align-flax">
                            <div class="col-xl-6 col-lg-5 col-md-6 mb-r-15">
                                <div class="view">
                                    <div class="list-types grid active">
                                        <a href="/shop">
                                            <div class="grid-icon list-types-icon">
                                                <i class="fa fa-th-large transition" aria-hidden="true"></i>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="list-types list">
                                        <a href="shop-list.html">
                                            <div class="list-icon list-types-icon">
                                                <i class="fa fa-bars transition" aria-hidden="true"></i>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="short-by"> <span>Product Compare (0)</span>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-7 col-md-6 text-right text-left-md">
                                <div class="show-item">
                                    <span class="ml-0">Sort By:</span>
                                    <div class="select-item">
                                        <select id="select" onchange="Sort(this)" class="m-w-130">
                                            <option value="" selected="selected">Default sorting</option>
                                            <option>A-Z</option>
                                            <option>Z-A</option>
                                            <option>Price</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="show-item float-right-md">
                                    <span>Show</span>
                                    <div class="select-item">
                                        <select>
                                            <option value="" selected="selected">15</option>
                                            <option value="">12</option>
                                            <option value="">6</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="featured">
                        <div data-price="" class="row">
                            <c:forEach var="item" items="${productModel.listResult}">
                                <div class="featured-product mb-25">
                                    <div class="product-img transition mb-15">
                                        <a href="/product?productid=${item.id}">
                                            <img src="${item.avatar}" alt="product" class="transition">
                                        </a>
                                        <div class="new-label">
                                            <span class="text-uppercase">New</span>
                                        </div>
                                        <div class="product-details-btn text-uppercase text-center transition">
                                            <a href="/product?productid=${item.id}" class="quick-popup">Quick View</a>
                                        </div>
                                    </div>
                                    <div class="product-desc">
                                        <a href="/product?productid=${item.id}" class="product-name text-uppercase">${item.name}</a>
                                        <span class="product-pricce">$${item.price}</span>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div style="margin-left: 250px"><ul class="pagination" id="pagination"></ul></div>
                </div>
            </div>
        </div>
    </section>
    <c:if test="${not empty categorycode}">
        <input type="hidden" value="" id="categorycode" name="categorycode"/>
    </c:if>
    <input type="hidden" value="" id="page" name="page"/>
    <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
</form>
<script>
    var totalPages = ${productModel.totalPage};
    var currentPage = ${productModel.page};
    var category="${categorycode}";
    function Sort(param) {
        var value = param.value;
        var value2="";
        if(category!="")
        {
            value2=category;
        }
        $.ajax({
            url: '${APIProduct}',
            type: 'GET',
            contentType: 'application/json',
            data: {
                keyvalue:value,
                categorycode:value2
            },
            dataType: 'json',
            success: function (result) {
                if(category==""){
                    window.location.href="/shop?page=1&&maxPageItem=16";
                }
                else {
                    window.location.href="/shop/collections?categorycode="+category;
                }
            },
            error:function (err) {
                console.log(err);
            }
        });
    }
    var limit = 16;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 3,
            startPage: currentPage,
            onPageClick: function (event, page) {
                event.preventDefault();
                if (currentPage != page) {
                    if(category!="") {
                        $('#categorycode').val(category);
                    }
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#formshop').submit();
                }
            }
        });
    });
</script>
</body>
</html>
