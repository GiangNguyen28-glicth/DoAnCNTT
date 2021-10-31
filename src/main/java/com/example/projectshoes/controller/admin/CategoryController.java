package com.example.projectshoes.controller.admin;

import com.example.projectshoes.model.CategoryModel;
import com.example.projectshoes.service.ICategoryService;
import com.example.projectshoes.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin-category")
public class CategoryController extends HttpServlet {
    @Inject
    ICategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryModel categoryModel= FormUtil.toModel(CategoryModel.class,req);
        RequestDispatcher rd=req.getRequestDispatcher("/views/admin/Insert/InsertCategory.jsp");
        categoryModel.setListResult(categoryService.findAll());
        req.setAttribute("categoryModel",categoryModel);
        rd.forward(req,resp);
    }
}
