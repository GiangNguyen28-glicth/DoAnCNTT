package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.IUserDAO;
import com.example.projectshoes.model.UserModel;
import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

  public UserDAO() {
    setType(UserModel.class);
  }

  @Override
  public UserModel findByUsernameAndPassword(String username, String password) {
    StringBuilder sql = new StringBuilder("from User u");
    sql.append(" where username = :username AND password = :password");
    UserModel userModel = new UserModel();
    userModel.setUsername(username);
    userModel.setPassword(password);
    List<UserModel> results = queryHibernate(sql.toString(), userModel);
    return results.isEmpty() ? null : results.get(0);
  }

  @Override
  public UserModel findByUserName(String username) {
    UserModel userModel = new UserModel();
    userModel.setUsername(username);
    List<UserModel> userModels = queryHibernate("from User u where u.username = :username",
            userModel);
    return userModels.size() > 0 ? userModels.get(0) : null;
  }

  @Override
  public UserModel findByEmail(String email) {
    UserModel userModel = new UserModel();
    userModel.setEmail(email);
    List<UserModel> userModels = queryHibernate("from User u where u.email = :email",
            userModel);
    return userModels.size() > 0 ? userModels.get(0) : null;
  }

  @Override
  public UserModel findUserById(Long id) {
    return findById(id);
  }

  @Override
  public Long insert(UserModel userModel) {
    System.out.println("Inserting " + save(userModel));
    return userModel.getId();
  }

  @Override
  public void update(UserModel userModel) {
    System.out.println("Update " + save(userModel));
  }

  @Override
  public List<UserModel> findAll() {
    return queryHibernate("from User", null);
  }

}