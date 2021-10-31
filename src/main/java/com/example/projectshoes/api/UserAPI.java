package com.example.projectshoes.api;

import com.example.projectshoes.message.ResponseMessage;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.IUserService;
import com.example.projectshoes.utils.HttpUtil;
import com.example.projectshoes.validate.MyValidator;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

@WebServlet(urlPatterns = {"/api-user"})
public class UserAPI extends HttpServlet {

  @Inject
  IUserService userService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    ObjectMapper mapper = new ObjectMapper();
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("application/json");
    UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
    UserModel findUser = userService.findByUsernameAndPassword(userModel.getUsername(),
        userModel.getPassword());
    mapper.writeValue(resp.getOutputStream(), findUser);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    MyValidator myValidator = new MyValidator(userService);
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("application/json");
    UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
    ResponseMessage.setMessage(myValidator.validateForm(userModel));
    if (ResponseMessage.getInstance().getMessage() == null) {
      userService.save(userModel);
    } else {
      userModel.setMessage(ResponseMessage.getResponseMessage().getMessage());
    }
    mapper.writeValue(resp.getOutputStream(), userModel);
  }
}
