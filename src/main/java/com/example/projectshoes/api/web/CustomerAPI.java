package com.example.projectshoes.api.web;

import com.example.projectshoes.model.CustomerModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.ICustomerService;
import com.example.projectshoes.utils.HttpUtil;
import com.example.projectshoes.utils.PathUtil;
import com.example.projectshoes.utils.SessionUtil;
import java.io.IOException;
import java.sql.Timestamp;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

@WebServlet(urlPatterns = {"/api-customer"})
public class CustomerAPI extends HttpServlet {

  @Inject
  private ICustomerService customerService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    Long userId = Long.parseLong(PathUtil.pathInf(req)[1]);
    ObjectMapper mapper = new ObjectMapper();
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("application/json");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("application/json");
    CustomerModel customerModel = HttpUtil.of(req.getReader()).toModel(CustomerModel.class);
    mapper.writeValue(resp.getOutputStream(), customerService.insert(customerModel));
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
    ObjectMapper mapper = new ObjectMapper();
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("application/json");
    CustomerModel customerModel = HttpUtil.of(req.getReader()).toModel(CustomerModel.class);
    customerModel.setUser(userModel);
    if (customerModel.getAvatar() != null) {
      customerModel.getUser().setAvatar(customerModel.getAvatar());
    }
    customerService.update(customerModel);
    mapper.writeValue(resp.getOutputStream(), true);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("application/json");
    CustomerModel customerModel = HttpUtil.of(req.getReader()).toModel(CustomerModel.class);
    for (Long id : customerModel.getIds()) {
      CustomerModel customer = customerService.findCustomerById(id);
      customer.getUser().setStatus("Inactive");
      customer.getUser().setBadge("danger");
      customerService.update(customer);
    }
    mapper.writeValue(resp.getOutputStream(), true);
  }
}
