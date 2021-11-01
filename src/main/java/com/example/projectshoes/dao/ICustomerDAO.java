package com.example.projectshoes.dao;


import com.example.projectshoes.model.CustomerModel;

public interface ICustomerDAO extends GenericDAO<CustomerModel> {

  CustomerModel findByUserId(Long userId);

  Long save(CustomerModel customerModel);

  void update(CustomerModel customerModel);

}
