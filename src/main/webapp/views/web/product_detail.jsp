<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <li><a href="/shop">Shop</a></li>
                        <li>Shop Detail</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="product-detail-main pt-100">
    <div class="container">
        <div class="row">
            <div class="col-lg-5 col-md-6 col-12">
                <img src="${productModel.avatar}">
            </div>
            <div class="col-lg-7 col-md-6 col-12">
                <div class="product-detail-in">
                    <h2 class="product-item-name text-uppercase">${productModel.name}</h2>
                    <div class="price-box">
                        <span class="price">${productModel.price}</span>
                        <del class="price old-price">$120.00</del>
                        <div class="rating-summary-block">
                            <div class="star-rating">
                                <input id="star-5" type="radio" name="rating" value="star-5" />
                                <label for="star-5" title="5 stars">
                                    <i class="active fa fa-star" aria-hidden="true"></i>
                                </label>
                                <input id="star-4" type="radio" name="rating" value="star-4" />
                                <label for="star-4" title="4 stars">
                                    <i class="active fa fa-star" aria-hidden="true"></i>
                                </label>
                                <input id="star-3" type="radio" name="rating" value="star-3" />
                                <label for="star-3" title="3 stars">
                                    <i class="active fa fa-star" aria-hidden="true"></i>
                                </label>
                                <input id="star-2" type="radio" name="rating" value="star-2" />
                                <label for="star-2" title="2 stars">
                                    <i class="active fa fa-star" aria-hidden="true"></i>
                                </label>
                                <input id="star-1" type="radio" name="rating" value="star-1" />
                                <label for="star-1" title="1 star">
                                    <i class="active fa fa-star" aria-hidden="true"></i>
                                </label>
                            </div>
                            <a href="#product-review" class="scrollTo"><span>1 Review (s)</span></a>
                        </div>
                        <div class="product-des">
                            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco aboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in oluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                        </div>
                        <ul>
                            <li><i class="fa fa-check"></i> Satisfaction 100% Guaranteed</li>
                            <li><i class="fa fa-check"></i> Free shipping on orders over $99</li>
                            <li><i class="fa fa-check"></i> 14 day easy Return</li>
                        </ul>
                        <div class="row mt-20">
                            <div class="col-12">
                                <div class="table-listing qty">
                                    <label>Quantity:</label>
                                    <div class="fill-input">
                                        <button type="button"  class="subqty" onclick="Sub()">
                                            <i class="fa fa-minus" aria-hidden="true"></i>
                                        </button>
                                        <input id="quantity" type="number" value="1" min="1" max="${productModel.quantity}" />
                                        <button type="button" class="addqty" onclick="Add()">
                                            <i class="fa fa-plus" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="table-listing qty">
                                    <label>Size:</label>
                                    <div class="fill-input">
                                        <select class="selectpicker full">
                                            <option selected="selected" value="#">${productModel.size}</option>
                                            <option value="#">${productModel.size}</option>
                                            <option value="#">${productModel.size}</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="table-listing qty">
                                    <label>Color:</label>
                                    <div class="fill-input">
                                        <select class="selectpicker full">
                                            <option selected="selected" value="#">Blue</option>
                                            <option value="#">Green</option>
                                            <option value="#">Orange</option>
                                            <option value="#">White</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="product-action">
                                    <ul>
                                        <li>
                                            <form action="/cart?action=addtocart" method="post">
                                                <a type="submit" class="btn btn-color">
                                                    <img src="<c:url value="/template/web/images/shop-bag.png"/>" alt="bag">
                                                    <input style="color: white;background-color: black" type="submit" value="add to cart" onclick="getValue()"/>
                                                </a>
                                                <input id ="qtt" type="hidden" name="quantity" value="">
                                                <input type="hidden" name="productId" value="${productModel.id}">
                                                <input type="hidden" name="price" value="${productModel.price}">
                                            </form>
                                        </li>
                                        <li><a href="/shop" class="btn"><i class="fa fa-heart" aria-hidden="true"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    var quantity=${productModel.quantity};
    function getValue() {
        var input=document.getElementById("quantity").value;
        document.getElementById("qtt").value=input;
    }
    function Add() {
        var input=Number(document.getElementById("quantity").value);
        if(input<quantity){
            document.getElementById("quantity").value=input+1;
        }
    }
    function Sub() {
        var input=Number(document.getElementById("quantity").value);
        if(input<0){
            document.getElementById("quantity").value=input-1;
        }
    }
</script>
</body>
</html>
