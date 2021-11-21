package com.example.projectshoes.controller.admin;

import com.example.projectshoes.model.CategoryModel;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.paging.PageRequest;
import com.example.projectshoes.paging.Pageble;
import com.example.projectshoes.service.ICategoryService;
import com.example.projectshoes.service.IProductService;
import com.example.projectshoes.utils.FormUtil;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin-product")
public class ProductController extends HttpServlet {
    @Inject
    ICategoryService categoryService;
    @Inject
    IProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = FormUtil.toModel(ProductModel.class,req);
        String url="";
        String action=req.getParameter("action");
        String key=req.getParameter("key");
        if(productModel.getPage()==null||productModel.getPage()<1){
            productModel.setPage(1);
        }
        if(action==null){
            Pageble pageble = new PageRequest(productModel.getPage(), productModel.getMaxPageItem());
            productModel.setTotalItem(productService.getTotalItem());
            productModel.setTotalPage((int) Math.ceil((double) productModel.getTotalItem() / productModel.getMaxPageItem()));
            url="/views/admin/LIST/ListProduct.jsp";
            productModel.setListResult(productService.findAll(pageble,key));
            req.setAttribute("productModel",productModel);
        }
        else if(action.equals("insert")){
            url="/views/admin/Insert/InsertProduct.jsp";
        }
        else if(action.equals("edit")){
            url="/views/admin/Insert/InsertProduct.jsp";
            Long id=Long.parseLong(req.getParameter("productid"));
            productModel=productService.findOne(id);
            req.setAttribute("productModel",productModel);
            req.setAttribute("categories",categoryService.findAll());
        }
        CategoryModel categoryModel=new CategoryModel();
        categoryModel.setListResult(categoryService.findAll());
        req.setAttribute("categoryModel",categoryModel);
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
