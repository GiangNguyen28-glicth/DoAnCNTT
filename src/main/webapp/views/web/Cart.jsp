<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<section class="page-banner">
    <div class="container">
        <div class="page-banner-in">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-12">
                    <h1 class="page-banner-title text-uppercase">Cart</h1>
                </div>
                <div class="col-xl-6 col-lg-6 col-12">
                    <ul class="right-side">
                        <li><a href="index.html">Home</a></li>
                        <li>Cart</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="pt-100">
    <div class="container">
        <div class="wishlist-table">
            <div class="responsive-table">
                <table class="table border text-center">
                    <thead>
                    <tr>
                        <th>Product</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Sub Total</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${cart.items}">
                        <tr>
                            <td class="text-left">
                                <div class="seller-box align-flax w-100">
                                    <div class="seller-img">
                                        <a href="product-detail.html" class="display-b">
                                            <img src="<c:url value="/template/web/images/product-1.jpg"/>" alt="shoes" class="transition">
                                        </a>
                                    </div>
                                    <div class="seller-contain pl-15">
                                        <a href="product-detail.html" class="product-name text-uppercase">${item.product.name}</a>
                                    </div>
                                </div>
                            </td>
                            <td><span class="price">$${item.product.price}</span></td>
                            <td>
                                <input type="number" id="ipqtt${item.product.id}" class="input-text" value="${item.quantity}" min="1" max="10"/>
                            </td>
                            <td><span class="price">${item.totalCurrencyFormat}</span></td>
                            <td>
                                <ul>
                                    <form action="/cart" method="post">
                                        <input type="hidden" name="productId" value="${item.product.id}">
                                        <input type="hidden" name="quantity" value="0">
                                        <input type="submit" class="btn btn-primary" value="Remove" style="color: white">
                                    </form>
                                    <form action="/cart" method="post">
                                        <input type="hidden" name="productId" value="${item.product.id}">
                                        <input id="qtt${item.product.id}" type="hidden" name="quantity" value="">
                                        <input type="submit" class="btn btn-primary" value="Update" style="color: white" onclick="getValUpdate(${item.product.id})">
                                    </form>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="share-wishlist shoping-con">
                        <a href="/trang-chu" class="btn"><i class="fa fa-angle-left"></i> Continue Shopping</a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="share-wishlist">
                        <a href="#" class="btn">Update Cart</a>
                    </div>
                </div>
            </div>
            <div class="estimate">
                <div class="row">
                    <div class="col-md-6">
                        <h2 class="reviews-head pb-20">Estimate shipping and tax</h2>
                        <form class="main-form">
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <select class="form-control">
                                            <option selected="" value="">Select Country</option>
                                            <option value="1">India</option>
                                            <option value="2">China</option>
                                            <option value="3">Pakistan</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <select class="form-control">
                                            <option selected="" value="">Select State/Province</option>
                                            <option value="1">---</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <select class="form-control">
                                            <option selected="" value="">Select City</option>
                                            <option value="1">---</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-6">
                        <div class="cart-total-table">
                            <div class="responsive-table">
                                <table class="table border">
                                    <thead>
                                    <tr>
                                        <th colspan="2">Cart Total</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>Item(s) Subtotal</td>
                                        <td>
                                            <div class="price-box">
                                                <span class="price">$${total}</span>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Shipping</td>
                                        <td>
                                            <div class="price-box">
                                                <span class="price">$0.00</span>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="payable"><b>Amount Payable</b></td>
                                        <td>
                                            <div class="price-box">
                                                <span class="price">$${total}</span>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="share-wishlist">
                                <a href="checkout.html" class="btn btn-color">Proceed to checkout <i class="fa fa-angle-right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    function getValUpdate(param) {
        var input=document.getElementById("ipqtt"+param).value;
        document.getElementById("qtt"+param).value=input;
    }
</script>
</body>
</html>
