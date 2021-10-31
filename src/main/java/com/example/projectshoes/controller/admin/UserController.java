package com.example.projectshoes.controller.admin;

import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.IUserService;
import com.example.projectshoes.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin-user")
public class UserController extends HttpServlet {
    @Inject
    IUserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel= FormUtil.toModel(UserModel.class,req);
        RequestDispatcher rd=req.getRequestDispatcher("/views/admin/LIST/ListUser.jsp");
        userModel.setListResult(userService.findAll());
        req.setAttribute("userModel",userModel);
        rd.forward(req,resp);
    }
}
