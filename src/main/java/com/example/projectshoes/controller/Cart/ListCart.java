package com.example.projectshoes.controller.Cart;

import com.example.projectshoes.constant.SystemConstant;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.IDeliveryService;
import com.example.projectshoes.service.IProductService;
import com.example.projectshoes.service.ISaledetailService;
import com.example.projectshoes.service.IUserService;
import com.example.projectshoes.utils.JavaMailUtil;
import com.example.projectshoes.utils.PathUtil;
import com.example.projectshoes.utils.SessionUtil;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/cart")
public class ListCart extends HttpServlet {
    @Inject
    IProductService productService;
    @Inject
    IUserService userService;
    @Inject
    ISaledetailService saledetailService;
    @Inject
    IDeliveryService deliveryService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        String url="";
        if(userModel==null){
            url="/views/web/login.jsp";
        }
        else {
            Long id=Long.parseLong(req.getParameter("productId"));
            String action=req.getParameter("action");
            if(id==null){
                RequestDispatcher rd=req.getRequestDispatcher("/views/web/Cart.jsp");
                rd.forward(req,resp);
            }
            else {
                ProductModel productModel=new ProductModel();
                productModel=productService.findOne(id);
                String quantityString = req.getParameter("quantity");
                double total;
                CartModel cart = (CartModel) SessionUtil.getInstance().getValue(req,"cart");
                LineItem lineItem = new LineItem();
                int quantity;
                try {
                    quantity = Integer.parseInt(quantityString);
                    if (quantity < 0) {
                        quantity = 1;
                    }
                } catch (NumberFormatException nfe) {
                    quantity = 1;
                }
                if (cart == null) {
                    cart = new CartModel();
                    lineItem.setProduct(productModel);
                    lineItem.setQuantity(quantity);
                    cart.addItem(lineItem);
                }
                else {
                    List<LineItem> lineItemList=cart.getItems();
                    boolean check=false;
                    for(LineItem item:lineItemList){
                        if(item.getProduct().getId().equals(productModel.getId())&&quantity!=0&&action!=null){
                            if(productModel.getQuantity()<item.getQuantity()+quantity){
                                item.setQuantity(productModel.getQuantity());
                            }
                            else {
                                item.setQuantity(item.getQuantity()+quantity);
                            }
                            check=true;
                            break;
                        }
                    }
                    if(check==false){
                        lineItem.setQuantity(quantity);
                        lineItem.setProduct(productModel);
                        if (quantity > 0) {
                            cart.addItem(lineItem);
                        } else if (quantity == 0) {
                            cart.removeItem(lineItem);
                        }
                    }
                }
                total=cart.totalPrice(lineItem);
                SessionUtil.getInstance().putValue(req,"cart",cart);
                SessionUtil.getInstance().putValue(req,"total",total);
                url="/views/web/Cart.jsp";
            }
        }
        RequestDispatcher rd=req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        String url="/views/web/Cart.jsp";
        if(action!=null){
            UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
            if(userModel==null){
                url="/views/web/login.jsp";
            }
            else {
                CartModel cart = (CartModel) SessionUtil.getInstance().getValue(req,"cart");
                if(cart!=null){
                    //                try {
//                    JavaMailUtil.sendMail(userModel.getEmail(), SystemConstant.TEAMPLATE_MAIL);
//                } catch (MessagingException e) {
//                    e.printStackTrace();
//                }
                    productService.UpdateAfertCheckout(req,userModel);
                    userService.removeCart(req);
                    //saledetailService.saveSaledetail()
                    req.setAttribute("userModel",userModel);
                    url="/views/web/Checkout.jsp";
                }
                else {
                    url="/views/web/Cart.jsp";
                }

            }
        }
        RequestDispatcher rd=req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
