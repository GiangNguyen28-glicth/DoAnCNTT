package com.example.projectshoes.controller.admin;

import com.example.projectshoes.model.DeliveryModel;
import com.example.projectshoes.paging.PageRequest;
import com.example.projectshoes.paging.Pageble;
import com.example.projectshoes.service.IDeliveryService;
import com.example.projectshoes.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin-delivery")
public class DeliveryController extends HttpServlet {
//    @Inject
//    IDeliveryService deliveryService;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        DeliveryModel deliveryModel= FormUtil.toModel(DeliveryModel.class,req);
//        RequestDispatcher rd=req.getRequestDispatcher("/views/admin/LIST/ListDelivery.jsp");
//        deliveryModel.setListResult(deliveryService.findAll());
//        req.setAttribute("deliveryModel",deliveryModel);
//        rd.forward(req,resp);
//    }

    @Inject
    IDeliveryService deliveryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeliveryModel deliveryModel = FormUtil.toModel(DeliveryModel.class,req);
        String url="";
        String action=req.getParameter("action");
        if(action==null){
            Pageble pageble = new PageRequest(deliveryModel.getPage(), deliveryModel.getMaxPageItem());
            url="/views/admin/LIST/ListDelivery.jsp";
            deliveryModel.setListResult(deliveryService.findAll());
            req.setAttribute("deliveryModel",deliveryModel);
        }
        else if(action.equals("insert")){
            url="/views/admin/Insert/InsertDelivery.jsp";
        }
        else if(action.equals("edit")){
            url="/views/admin/Insert/InsertDelivery.jsp";
            Long id=Long.parseLong(req.getParameter("deliveryid"));
            deliveryModel=deliveryService.findOne(id);
            req.setAttribute("deliveryModel",deliveryModel);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
