package com.example.projectshoes.dao;


import com.example.projectshoes.model.CustomerModel;
import com.example.projectshoes.model.UserModel;
import java.util.List;

public interface ICustomerDAO extends GenericDAO<CustomerModel> {

  List<CustomerModel> findAllCustomer();

  CustomerModel findCustomerById(Long id);

  CustomerModel findCustomerByUser(UserModel userModel);

  Long insert(CustomerModel customerModel);

  void update(CustomerModel customerModel);

  void remove(CustomerModel customerModel);


}
