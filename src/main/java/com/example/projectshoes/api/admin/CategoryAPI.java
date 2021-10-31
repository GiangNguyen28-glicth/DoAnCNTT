package com.example.projectshoes.api.admin;

import com.example.projectshoes.model.CategoryModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.ICategoryService;
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

@WebServlet(urlPatterns = "/api-category")
public class CategoryAPI extends HttpServlet {
    @Inject
    ICategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        CategoryModel categoryModel = HttpUtil.of(req.getReader()).toModel((CategoryModel.class));
        UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        categoryModel.setCreatedBy(userModel.getUsername());
        categoryModel.setModifiedBy(userModel.getUsername());
        categoryService.save(categoryModel);
        mapper.writeValue(resp.getOutputStream(),categoryModel);
    }
}
