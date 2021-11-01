package com.example.projectshoes.service.impl;

import com.example.projectshoes.dao.impl.CustomerDAO;
import com.example.projectshoes.model.CustomerModel;
import com.example.projectshoes.service.ICustomerService;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

public class CustomerService implements ICustomerService {

  @Inject
  private CustomerDAO customerDAO;

  @Override
  public CustomerModel findByUserId(Long userId) {

    return customerDAO.findByUserId(userId);
  }

  @Override
  public Long save(CustomerModel customerModel) {
    return customerDAO.save(customerModel);
  }

  @Override
  public void update(CustomerModel customerModel, Long userId) {
    CustomerModel newCustomer = customerDAO.findByUserId(userId);
    if (newCustomer != null) {
      if (StringUtils.isNoneBlank(customerModel.getFirstName())) {
        newCustomer.setFirstName(customerModel.getFirstName());
      }
      if (StringUtils.isNoneBlank(customerModel.getLastName())) {
        newCustomer.setLastName(customerModel.getLastName());
      }
      if (StringUtils.isNoneBlank(customerModel.getPhone())) {
        newCustomer.setPhone(customerModel.getPhone());
      }
      if (StringUtils.isNoneBlank(customerModel.getAddress())) {
        newCustomer.setAddress(customerModel.getAddress());
      }
      if (StringUtils.isNoneBlank(customerModel.getContent())) {
        newCustomer.setContent(customerModel.getContent());
      }
      customerDAO.update(newCustomer);
    } else {
      customerDAO.save(customerModel);
    }
  }
}
