package com.example.projectshoes.controller.web;

import com.example.projectshoes.constant.SystemConstant;
import com.example.projectshoes.service.IUserService;
import com.example.projectshoes.utils.JavaMailUtil;
import com.example.projectshoes.utils.MailTemplateUtil;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/otp"})
public class OtpController extends HttpServlet {

  private String alert;
  private String url = "/views/web/404.jsp";
  @Inject
  IUserService userService;
  private final ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
  private String message;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.message = req.getParameter("message");
    this.alert = req.getParameter("alert");
    req.setAttribute("message",
        resourceBundle.getString(this.message) + SystemConstant.userVerify.getEmail());
    req.setAttribute("alert", this.alert);
    if (SystemConstant.Otp != null) {
      this.url = "/views/web/otp.jsp";
    } else {
      this.url = "/views/web/404.jsp";
    }
    RequestDispatcher rq = req.getRequestDispatcher(this.url);
    rq.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String otp = req.getParameter("otp");
    if (otp != null) {
      if (otp.equals(SystemConstant.Otp)) {
        try {
          userService.save(SystemConstant.userVerify);
          JavaMailUtil.sendMail(SystemConstant.userVerify.getEmail(),
              MailTemplateUtil.templateMailCongratulation(), "Conratulation!");
          SystemConstant.Otp = null;
          this.message = resourceBundle.getString("register_success");
          this.alert = "success";
          this.url = "/views/web/login.jsp";
        } catch (MessagingException e) {
          e.printStackTrace();
        }
      } else {
        this.message = resourceBundle.getString("otpUncorrect");
        this.alert = "danger";
        this.url = "/views/web/otp.jsp";
      }
    }
    req.setAttribute("message", this.message);
    req.setAttribute("alert", this.alert);
    RequestDispatcher rq = req.getRequestDispatcher(this.url);
    rq.forward(req, resp);
  }
}
