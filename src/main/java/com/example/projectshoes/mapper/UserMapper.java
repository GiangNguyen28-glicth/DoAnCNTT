package com.example.projectshoes.mapper;

import com.example.projectshoes.model.RoleModel;
import com.example.projectshoes.model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {

  @Override
  public UserModel mapRow(ResultSet rs) {
    UserModel user = new UserModel();
    try {
      user.setId(rs.getLong("id"));
      user.setUsername(rs.getString("username"));
      user.setPassword(rs.getString("password"));
      user.setEmail(rs.getString("email"));
      user.setRoleId(rs.getLong("role_id"));
      user.setAvatar(rs.getString("avatar"));
      try {
        RoleModel role = new RoleModel();
        role.setCode(rs.getString("code"));
        role.setName(rs.getString("name"));
        user.setRole(role);
      } catch (Exception e) {
        System.out.print(e.getMessage());
      }
      return user;
    } catch (SQLException e) {
      System.out.println("Failed");
      return null;
    }
  }
}
