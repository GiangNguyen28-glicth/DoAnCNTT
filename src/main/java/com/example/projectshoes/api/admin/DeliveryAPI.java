package com.example.projectshoes.api.admin;

import com.example.projectshoes.model.DeliveryModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.IDeliveryService;
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

@WebServlet(urlPatterns = "/api-delivery")
public class DeliveryAPI extends HttpServlet {
    @Inject
    IDeliveryService deliveryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        DeliveryModel deliveryModel= HttpUtil.of(req.getReader()).toModel(DeliveryModel.class);
        Long id=deliveryModel.getId();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        DeliveryModel deliveryModel= HttpUtil.of(req.getReader()).toModel(DeliveryModel.class);
        UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        deliveryModel.setCreatedBy(userModel.getUsername());
        deliveryModel.setModifiedBy(userModel.getUsername());
        deliveryService.save(deliveryModel);
        mapper.writeValue(resp.getOutputStream(),deliveryModel);
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        DeliveryModel deliveryModel =  HttpUtil.of(req.getReader()).toModel(DeliveryModel.class);
        deliveryService.delete(deliveryModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        DeliveryModel deliveryModel= HttpUtil.of(req.getReader()).toModel(DeliveryModel.class);
        UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        deliveryModel.setModifiedBy(userModel.getUsername());
        deliveryService.update(deliveryModel);
        mapper.writeValue(resp.getOutputStream(),deliveryModel);
    }
}
