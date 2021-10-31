package com.example.projectshoes.api;

import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.IUserService;
import com.example.projectshoes.utils.HttpUtil;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

@WebServlet(urlPatterns = {"/api-login"})
public class LoginAPI extends HttpServlet {

  @Inject
  private IUserService userService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("application/json");
    UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
    UserModel checkUser = userService.findByUserName(userModel.getUsername());
    if (checkUser == null) {
      userModel.setPassword("");
      userModel.setEmail("");
      userService.save(userModel);
    }
    mapper.writeValue(resp.getOutputStream(), userModel);
  }
}
