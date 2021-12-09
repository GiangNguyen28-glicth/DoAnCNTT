package com.example.projectshoes.controller.Cart;

import com.example.projectshoes.model.InformationModel;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.model.SaledetailModel;
import com.example.projectshoes.service.IPaymentServices;
import com.example.projectshoes.utils.CartModel;
import com.example.projectshoes.utils.HttpUtil;
import com.example.projectshoes.utils.SessionUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {

  @Inject
  IPaymentServices paymentServices;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("application/json");
    InformationModel informationModel= HttpUtil.of(req.getReader()).toModel(InformationModel.class);
    CartModel cartModel=(CartModel)SessionUtil.getInstance().getValue(req,"cart");
    try {
      String approvalLink = paymentServices.authorizePayment(cartModel);
      InformationModel ifm=(InformationModel) SessionUtil.getInstance().getValue(req,"information");
      SessionUtil.getInstance().putValue(req, "information",informationModel);
      resp.sendRedirect(approvalLink);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
