package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.ICustomerDAO;
import com.example.projectshoes.mapper.CustomerMapper;
import com.example.projectshoes.model.CustomerModel;
import java.util.List;

public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDAO {

  @Override
  public CustomerModel findByUserId(Long userId) {
    StringBuilder sql = new StringBuilder("SELECT * FROM customer WHERE user_id=?");
    List<CustomerModel> customers = query(sql.toString(), new CustomerMapper(), userId);
    return customers.isEmpty() ? null : customers.get(0);
  }

  @Override
  public Long save(CustomerModel customerModel) {
    StringBuilder sql = new StringBuilder("INSERT INTO customer(user_id,firstname,lastname");
    sql.append(",gender,phone,address,content) VALUES(?,?,?,?,?,?,?)");
    return insert(sql.toString(), customerModel.getUserId(), customerModel.getFirstName(),
        customerModel.getLastName(), customerModel.getGender(), customerModel.getPhone(),
        customerModel.getAddress(), customerModel.getContent());
  }

  @Override
  public void update(CustomerModel customerModel) {
    StringBuilder sql = new StringBuilder(
        "UPDATE customer SET firstname=?, lastname=?, gender=?, ");
    sql.append("phone=?, address=?, content=? WHERE user_id =?");
    update(sql.toString(), customerModel.getFirstName(), customerModel.getLastName()
        , customerModel.getGender(), customerModel.getPhone(), customerModel.getAddress(),
        customerModel.getContent(), customerModel.getUserId());
  }
}
