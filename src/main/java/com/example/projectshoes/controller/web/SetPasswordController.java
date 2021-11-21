package com.example.projectshoes.controller.web;

import com.example.projectshoes.constant.SystemConstant;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/set-password"})
public class SetPasswordController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    String url = "/views/web/404.jsp";
    if (SystemConstant.ID != null) {
      if (SystemConstant.FLAG) {
        Cookie cookie = new Cookie("email", SystemConstant.ID.toString());
        cookie.setMaxAge(60 * 5);
        SystemConstant.FLAG = false;
        resp.addCookie(cookie);
        url = "/views/web/newpassword.jsp";
      } else {
        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        for (Cookie cookie : cookies) {
          if (cookie.getName().equals("email")) {
            flag = true;
          }
        }
        if (flag) {
          url = "/views/web/newpassword.jsp";
        }
      }
    }
    RequestDispatcher rq = req.getRequestDispatcher(url);
    rq.forward(req, resp);
  }
}
