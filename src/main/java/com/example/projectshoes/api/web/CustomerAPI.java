//package com.example.projectshoes.api.web;
//
//import com.example.projectshoes.model.CustomerModel;
//import com.example.projectshoes.service.ICustomerService;
//import com.example.projectshoes.utils.HttpUtil;
//import com.example.projectshoes.utils.PathUtil;
//import java.io.IOException;
//import java.util.ResourceBundle;
//import javax.inject.Inject;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.codehaus.jackson.map.ObjectMapper;
//
//@WebServlet(urlPatterns = {"/api-customer/*"})
//public class CustomerAPI extends HttpServlet {
//
//  private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
//
//  @Inject
//  private ICustomerService customerService;
//
//  @Override
//  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//      throws ServletException, IOException {
//    Long userId = Long.parseLong(PathUtil.pathInf(req)[1]);
//    ObjectMapper mapper = new ObjectMapper();
//    req.setCharacterEncoding("UTF-8");
//    resp.setContentType("application/json");
//    CustomerModel findCustomer = customerService.findByUserId(userId);
//    mapper.writeValue(resp.getOutputStream(), findCustomer);
//  }
//
//  @Override
//  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//      throws ServletException, IOException {
//    ObjectMapper mapper = new ObjectMapper();
//    req.setCharacterEncoding("UTF-8");
//    resp.setContentType("application/json");
//    CustomerModel customerModel = HttpUtil.of(req.getReader()).toModel(CustomerModel.class);
//    mapper.writeValue(resp.getOutputStream(), customerService.save(customerModel));
//  }
//
//  @Override
//  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
//      throws ServletException, IOException {
//    Long userId = Long.parseLong(PathUtil.pathInf(req)[1]);
//    ObjectMapper mapper = new ObjectMapper();
//    req.setCharacterEncoding("UTF-8");
//    resp.setContentType("application/json");
//    CustomerModel customerModel = HttpUtil.of(req.getReader()).toModel(CustomerModel.class);
//    customerService.update(customerModel, userId);
//    mapper.writeValue(resp.getOutputStream(), customerModel);
//  }
//}
