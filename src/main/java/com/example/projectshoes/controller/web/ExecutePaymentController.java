package com.example.projectshoes.controller.web;

import com.example.projectshoes.model.DeliveryModel;
import com.example.projectshoes.model.InformationModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.IDeliveryService;
import com.example.projectshoes.service.IProductService;
import com.example.projectshoes.service.IUserService;
import com.example.projectshoes.service.impl.PaymentServices;
import com.example.projectshoes.utils.CartModel;
import com.example.projectshoes.utils.SessionUtil;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/excute_payment")
public class ExecutePaymentController extends HttpServlet {

  @Inject
  PaymentServices paymentServices;
  @Inject
  IUserService userService;
  @Inject
  IProductService productService;
  @Inject
  IDeliveryService deliveryService;
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    InformationModel ifm=(InformationModel) SessionUtil.getInstance().getValue(request,"information");
    String paymentId = request.getParameter("paymentId");
    String payerId = request.getParameter("PayerID");
    String url = "/views/web/paymentError.jsp";
    try {
      Payment payment = paymentServices.executePayment(paymentId, payerId);
      UserModel userModel=(UserModel)SessionUtil.getInstance().getValue(request,"USERMODEL");
      DeliveryModel deliveryModel=new DeliveryModel();
      deliveryModel.setStatus("Pending");
      deliveryModel.setAddress(ifm.getAddress());
      deliveryModel.setPhonenumber(ifm.getPhonenumber());
      deliveryModel.setFullname(ifm.getFullname());
      String s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Timestamp(System.currentTimeMillis()));
      Timestamp ts1 = Timestamp.valueOf(s);
      deliveryModel.setCreatedDate(ts1);
      deliveryService.saveDelivery(deliveryModel);
      productService.UpdateAfertCheckout(request, userModel,deliveryModel);
      userService.removeCart(request);
      PayerInfo payerInfo = payment.getPayer().getPayerInfo();
      Transaction transaction = payment.getTransactions().get(0);
      request.setAttribute("payer", payerInfo);
      request.setAttribute("transaction", transaction);
      url = "/views/web/receipt.jsp";
    } catch (PayPalRESTException ex) {
      request.setAttribute("errorMessage", ex.getMessage());
      ex.printStackTrace();
    }
    RequestDispatcher rq = request.getRequestDispatcher(url);
    rq.forward(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doPost(req, resp);
  }
}
