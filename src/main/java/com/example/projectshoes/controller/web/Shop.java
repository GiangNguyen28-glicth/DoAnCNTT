package com.example.projectshoes.controller.web;

import com.example.projectshoes.constant.SystemConstant;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.paging.PageRequest;
import com.example.projectshoes.paging.Pageble;
import com.example.projectshoes.service.IProductService;
import com.example.projectshoes.utils.FormUtil;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/shop","/shop/collections"})
public class Shop extends HttpServlet {
    @Inject
    IProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = FormUtil.toModel(ProductModel.class,req);
        String key=req.getParameter("key");
        String category=req.getParameter("categorycode");
        if(productModel.getPage()==null||productModel.getPage()<1){
            productModel.setPage(1);
            productModel.setMaxPageItem(16);
        }
        if(SystemConstant.FLAGSORT){
            SystemConstant.FLAGSORT=false;
            productModel.setListResult(SystemConstant.productModel.getListResult());
        }
        else {
            Pageble pageble = new PageRequest(productModel.getPage(), productModel.getMaxPageItem());
            if(category!=null){
                productModel.setTotalItem(productService.getTotalItemByCategory(category));
                productModel.setListResult(productService.findbyCategory(pageble,category));
            }
            else {
                productModel.setTotalItem(productService.getTotalItem());
                productModel.setListResult(productService.findAll(pageble,key));
            }
        }
        productModel.setTotalPage((int) Math.ceil((double) productModel.getListResult().size() / productModel.getMaxPageItem()));
        req.setAttribute("categorycode",category);
        req.setAttribute("productModel",productModel);
        RequestDispatcher rd=req.getRequestDispatcher("/views/web/product.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
