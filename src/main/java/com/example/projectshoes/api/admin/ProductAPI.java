package com.example.projectshoes.api.admin;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.ICategoryService;
import com.example.projectshoes.service.IProductService;
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
@WebServlet(urlPatterns ="/api-product")
public class ProductAPI extends HttpServlet {
    @Inject
    IProductService productService;
    @Inject
    ICategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel productModel= HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        Long id=productModel.getId();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel productModel= HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        productModel.setCreatedBy(userModel.getUsername());
        productModel.setModifiedBy(userModel.getUsername());
        productService.save(productModel);
        mapper.writeValue(resp.getOutputStream(),productModel);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel productModel =  HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        productService.delete(productModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel productModel= HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        productModel.setModifiedBy(userModel.getUsername());
        productService.update(productModel);
        mapper.writeValue(resp.getOutputStream(),productModel);
    }
}
