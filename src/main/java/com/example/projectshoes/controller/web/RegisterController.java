package com.example.projectshoes.controller.web;

import com.example.projectshoes.message.ResponseMessage;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dang-ky")
public class RegisterController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    if (ResponseMessage.getInstance().getMessage() != null) {
      req.setAttribute("message", ResponseMessage.getInstance().getMessage());
    }
    RequestDispatcher rq = req.getRequestDispatcher("/views/web/register.jsp");
    rq.forward(req, resp);
  }
}
