package com.example.projectshoes.controller.web;

import com.example.projectshoes.constant.SystemConstant;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.model.RoleModel;
import com.example.projectshoes.model.SaledetailModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.paging.PageRequest;
import com.example.projectshoes.paging.Pageble;
import com.example.projectshoes.service.IProductService;
import com.example.projectshoes.service.IRoleService;
import com.example.projectshoes.service.ISaledetailService;
import com.example.projectshoes.service.IUserService;
import com.example.projectshoes.utils.FormUtil;
import com.example.projectshoes.utils.SessionUtil;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet {

  @Inject
  IRoleService roleService;
  @Inject
  IUserService userService;
  @Inject
  IProductService productService;
  @Inject
  ISaledetailService saledetailService;
  private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    String action = req.getParameter("action");
    String key=req.getParameter("key");
    if (action != null && action.equals("login")) {
      if (SystemConstant.checkRemember) {
        req.setAttribute("checked", true);
        req.setAttribute("rememberUsername", SystemConstant.rememberUsername);
        req.setAttribute("rememberPassword", SystemConstant.rememberPassword);
      }
      String message = req.getParameter("message");
      String alert = req.getParameter("alert");
      if (message != null && alert != null) {
        req.setAttribute("message", resourceBundle.getString(message));
        req.setAttribute("alert", alert);
      }
      RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
      rd.forward(req, resp);
    } else if (action != null && action.equals("logout")) {
      SessionUtil.getInstance().removeValue(req, "USERMODEL");
      resp.sendRedirect(req.getContextPath() + "/trang-chu");
    } else {
      ProductModel productModel = new ProductModel();
      SaledetailModel saledetailModel=new SaledetailModel();
      saledetailModel.setListResult(saledetailService.gettop3());
      Pageble pageble = new PageRequest(1, 10);
      productModel.setListResult(productService.findAll(pageble,key));
      req.setAttribute("productModel", productModel);
      req.setAttribute("saledetailModel", saledetailModel);
      String userSuccess = req.getParameter("user");
      req.setAttribute("user", userSuccess);
      RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
      rd.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    String action = req.getParameter("action");
    if (action != null && action.equals("login")) {
      UserModel userModel = FormUtil.toModel(UserModel.class, req);
      if (userModel.getChecked() != null) {
        SystemConstant.checkRemember = true;
        SystemConstant.rememberUsername = userModel.getUsername();
        SystemConstant.rememberPassword = userModel.getPassword();
      } else {
        SystemConstant.checkRemember = false;
      }
      userModel = userService.findByUsernameAndPassword(
              userModel.getUsername(), userModel.getPassword()
      );
      if (userModel != null) {
        RoleModel roleModel = roleService.findRoleById(userModel.getRoleId());
        userModel.setRole(roleModel);
        SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
        if (userModel.getRole().getCode().equals(SystemConstant.USER)) {
          resp.sendRedirect(req.getContextPath() + "/trang-chu");
        } else if (userModel.getRole().getCode().equals(SystemConstant.ADMIN)) {
          resp.sendRedirect(req.getContextPath() + "/admin-home");
        }
      } else {
        resp.sendRedirect(req.getContextPath()
                + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
      }
    }
  }
}

