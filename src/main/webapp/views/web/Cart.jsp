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
                        <li><a href="/trang-chu">Home</a></li>
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
                                        <a href="/product?productid=${item.product.id}" class="display-b">
                                            <img src="${item.product.avatar}" alt="shoes" class="transition">
                                        </a>
                                    </div>
                                    <div class="seller-contain pl-15">
                                        <a href="/product?productid=${item.product.id}" class="product-name text-uppercase">${item.product.name}</a>
                                    </div>
                                </div>
                            </td>
                            <td><span class="price">$${item.product.price}</span></td>
                            <td>
                                <input type="number" id="ipqtt${item.product.id}" class="input-text" value="${item.quantity}" min="1" max="${item.product.quantity}"/>
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
                <form id="checkoutcart" class="main-form" action="/authorize_payment" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <h2 class="reviews-head pb-20">Your Information</h2>
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <select id="city" name="city" class="form-control" required>
                                            <option selected="" value="">Select Country</option>
                                            <option value="Binh Duong">Binh Duong</option>
                                            <option value="Thu Duc">Thu Duc</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <select id="sex" class="form-control" required>
                                            <option selected="" value="">Choose Your Gender</option>
                                            <option value="1">Male</option>
                                            <option value="1">FeMale</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input id="fname" name="fname" class="form-control" placeholder="First Name" required>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input id="lname" name="lname" class="form-control" placeholder="Last Name" required>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input id="phonenumber" name="phonenumber" class="form-control" placeholder="Phone Number" required>
                                    </div>
                                </div>
                            </div>
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
                                    <button type="submit" class="btn btn-color" onclick="getValueForm()"/>Proceed to checkout <i class="fa fa-angle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</section>
<script>
    function getValUpdate(param) {
        var input=document.getElementById("ipqtt"+param).value;
        document.getElementById("qtt"+param).value=input;
    }
    function getValueForm() {
        var fname=document.getElementById("fname").value;
        var lname=document.getElementById("lname").value;
        var phonenumber=document.getElementById("phonenumber").value;
        var address=document.getElementById("city").value;
        var fullname=lname+fname;
        if(fname!=""&&lname!=""&&phonenumber!=""&&address!=""){
            var data = {};
            data['fullname']=fullname;
            data['address']=address;
            data['phonenumber']=phonenumber;
            checkOut(data);
        }
    }
    function checkOut(data) {
        $.ajax({
            url:"/authorize_payment",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
        });
    }
</script>
</body>
</html>
