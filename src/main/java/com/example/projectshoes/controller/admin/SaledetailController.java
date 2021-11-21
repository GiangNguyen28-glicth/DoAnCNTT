package com.example.projectshoes.controller.admin;

import com.example.projectshoes.model.DeliveryModel;
import com.example.projectshoes.model.SaledetailModel;
import com.example.projectshoes.service.IDeliveryService;
import com.example.projectshoes.service.IProductService;
import com.example.projectshoes.service.ISaledetailService;
import com.example.projectshoes.service.IUserService;
import com.example.projectshoes.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin-saledetail")
public class SaledetailController extends HttpServlet {
    @Inject
    IUserService userService;
    @Inject
    IProductService productService;
    @Inject
    IDeliveryService deliveryService;
    @Inject
    ISaledetailService saledetailService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SaledetailModel saledetailModel = FormUtil.toModel(SaledetailModel.class,req);
        String url="";
        String action=req.getParameter("action");
        if(action==null){
            url="/views/admin/LIST/ListSaledetail.jsp";
            saledetailModel.setListResult(saledetailService.findAll());
            req.setAttribute("saledetailModel",saledetailModel);
            req.setAttribute("deliveries",deliveryService.findAll());
        }
        DeliveryModel deliveryModel=new DeliveryModel();
        deliveryModel.setListResult(deliveryService.findAll());
        req.setAttribute("deliveryModel",deliveryModel);
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
