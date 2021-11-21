package com.example.projectshoes.controller.web;

import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.IUserService;
import com.example.projectshoes.utils.SessionUtil;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/trang-chu-api"})
public class LoginAPIController extends HttpServlet {

  @Inject
  private IUserService userService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    String username = req.getParameter("id");
    if (username != null) {
      UserModel userModel = userService.findByUserName(username);
      SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
      resp.sendRedirect(req.getContextPath() + "/trang-chu");
    }
  }
}
