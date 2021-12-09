package com.example.projectshoes.controller.web;

import com.example.projectshoes.model.InformationModel;
import com.example.projectshoes.service.impl.PaymentServices;
import com.example.projectshoes.utils.SessionUtil;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review_payment")
public class ReviewPaymentController extends HttpServlet {

  @Inject
  PaymentServices paymentServices;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    InformationModel ifm=(InformationModel) SessionUtil.getInstance().getValue(req,"information");
    String paymentId = req.getParameter("paymentId");
    String payerId = req.getParameter("PayerID");
    String url = "/views/web/paymentError.jsp";
    RequestDispatcher rd;
    try {
      Payment payment = paymentServices.getPaymentDetails(paymentId);
      PayerInfo payerInfo = payment.getPayer().getPayerInfo();
      Transaction transaction = payment.getTransactions().get(0);
      ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
      req.setAttribute("payer", payerInfo);
      req.setAttribute("transaction", transaction);
      req.setAttribute("shippingAddress", shippingAddress);
      req.setAttribute("ifm",ifm);
      url = "/views/web/review.jsp?paymentId="+ paymentId+"&PayerID="+payerId;
    } catch (Exception ex) {
      ex.printStackTrace();
      req.setAttribute("errorMessage", "Could not get payments details");
    }
    rd = req.getRequestDispatcher(url);
    rd.forward(req, resp);
  }
}
