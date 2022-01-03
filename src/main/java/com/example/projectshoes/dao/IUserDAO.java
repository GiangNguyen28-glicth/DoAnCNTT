package com.example.projectshoes.dao;

import com.example.projectshoes.model.UserModel;
import java.util.List;

public interface IUserDAO extends GenericDAO<UserModel> {


  UserModel findByUsernameAndPassword(String username, String password);

  UserModel findByUserName(String username);

  UserModel findByEmail(String email);

  UserModel findUserById(Long id);

  Long insert(UserModel userModel);

  void update(UserModel userModel);

  List<UserModel> findAll();

}