package com.example.projectshoes.api.admin;

import com.example.projectshoes.model.SaledetailModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.IDeliveryService;
import com.example.projectshoes.service.ISaledetailService;
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

@WebServlet(urlPatterns ="/api-saledetail")
public class SaledetailAPI extends HttpServlet {
    @Inject
    ISaledetailService saledetailService;

    @Inject
    IDeliveryService deliveryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        SaledetailModel saledetailModel= HttpUtil.of(req.getReader()).toModel(SaledetailModel.class);
        Long id=saledetailModel.getId();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        SaledetailModel saledetailModel= HttpUtil.of(req.getReader()).toModel(SaledetailModel.class);
        UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        saledetailModel.setCreatedBy(userModel.getUsername());
        saledetailModel.setModifiedBy(userModel.getUsername());
        saledetailService.save(saledetailModel);
        mapper.writeValue(resp.getOutputStream(),saledetailModel);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        SaledetailModel saledetailModel =  HttpUtil.of(req.getReader()).toModel(SaledetailModel.class);
        saledetailService.delete(saledetailModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        SaledetailModel saledetailModel= HttpUtil.of(req.getReader()).toModel(SaledetailModel.class);
        UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        saledetailModel.setModifiedBy(userModel.getUsername());
        saledetailService.update(saledetailModel);
        mapper.writeValue(resp.getOutputStream(),saledetailModel);
    }
}
