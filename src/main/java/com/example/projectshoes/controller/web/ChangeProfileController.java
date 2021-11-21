package com.example.projectshoes.controller.web;

import com.example.projectshoes.model.CustomerModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.ICustomerService;
import com.example.projectshoes.utils.SessionUtil;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/change-profile"})
public class ChangeProfileController extends HttpServlet {

  @Inject
  ICustomerService customerService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String action = req.getParameter("action");
    UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
    CustomerModel customerModel = customerService.findCustomerByUser(userModel);
    if (customerModel != null) {
      req.setAttribute("customer", customerModel);
    }
    if(action != null){
      req.setAttribute("message", "update profile successs!");
    }
    RequestDispatcher rq = req.getRequestDispatcher("/views/web/updateprofile.jsp");
    rq.forward(req, resp);
  }
}
