package com.example.projectshoes.service;


import com.example.projectshoes.model.UserModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserService {

  UserModel findByUsernameAndPassword(String username, String password);

  UserModel findByUserName(String username);

  UserModel findByEmail(String email);

  UserModel findByUserID(Long id);

  Long save(UserModel userModel);

  void update(UserModel userModel);

  List<UserModel> findAll();

  void removeCart(HttpServletRequest req);

}
