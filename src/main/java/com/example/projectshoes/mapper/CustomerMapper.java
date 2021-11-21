package com.example.projectshoes.mapper;

import com.example.projectshoes.model.CustomerModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<CustomerModel> {

  @Override
  public CustomerModel mapRow(ResultSet rs) {
    CustomerModel customer = new CustomerModel();
    try {
      customer.setId(rs.getLong("id"));
//      customer.setUserId(rs.getLong("user_id"));
      customer.setFirstName(rs.getString("firstname"));
      customer.setLastName(rs.getString("lastname"));
      customer.setAddress(rs.getString("address"));
      customer.setPhone(rs.getString("phone"));
      customer.setContent(rs.getString("content"));
      customer.setGender(rs.getString("gender"));
      return customer;
    } catch (SQLException e) {
      return null;
    }
  }
}
