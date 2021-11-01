package com.example.projectshoes.service;


import com.example.projectshoes.model.CustomerModel;

public interface ICustomerService {

  CustomerModel findByUserId(Long userId);

  Long save(CustomerModel customerModel);

  void update(CustomerModel customerModel, Long userId);
}
