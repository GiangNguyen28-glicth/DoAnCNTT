package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.ICustomerDAO;
import com.example.projectshoes.model.CustomerModel;
import com.example.projectshoes.model.UserModel;
import java.util.List;

public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDAO {

  public CustomerDAO() {
    setType(CustomerModel.class);
  }

  @Override
  public List<CustomerModel> findAllCustomer() {

    return queryHibernate("from Customer", null);
  }

  @Override
  public CustomerModel findCustomerById(Long id) {
    return findById(id);
  }

  @Override
  public CustomerModel findCustomerByUser(UserModel userModel) {
    CustomerModel customerModel = new CustomerModel();
    customerModel.setUser(userModel);
    StringBuilder hql = new StringBuilder("from Customer c where c.user = :user");
    List<CustomerModel> customers = queryHibernate(hql.toString(), customerModel);
    return customers.isEmpty() ? null : customers.get(0);
  }

  @Override
  public Long insert(CustomerModel customerModel) {
    return save(customerModel);
  }

  @Override
  public void update(CustomerModel customerModel) {
    save(customerModel);
  }

  @Override
  public void remove(CustomerModel customerModel) {
    delete(customerModel);
  }
}
