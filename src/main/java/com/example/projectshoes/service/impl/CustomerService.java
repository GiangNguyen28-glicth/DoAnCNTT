package com.example.projectshoes.service.impl;

import com.example.projectshoes.dao.impl.CustomerDAO;
import com.example.projectshoes.model.CustomerModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.ICustomerService;
import java.sql.Timestamp;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

public class CustomerService implements ICustomerService {

  @Inject
  private CustomerDAO customerDAO;

  @Override
  public CustomerModel findCustomerByUser(UserModel user) {
    return customerDAO.findCustomerByUser(user);
  }

  @Override
  public CustomerModel findCustomerById(Long id) {
    return customerDAO.findCustomerById(id);
  }

  @Override
  public List<CustomerModel> findAllCustomer() {
    return customerDAO.findAllCustomer();
  }

  @Override
  public Long insert(CustomerModel customerModel) {
    return customerDAO.insert(customerModel);
  }

  @Override
  public void update(CustomerModel customerModel) {
    CustomerModel newCustomer = customerDAO.findCustomerByUser(customerModel.getUser());
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
      if (StringUtils.isNoneBlank(customerModel.getAvatar())) {
        newCustomer.getUser().setAvatar(customerModel.getAvatar());
      }
      newCustomer.getUser().setModifiedDate(new Timestamp(System.currentTimeMillis()));
      newCustomer.getUser().setModifiedBy(customerModel.getUser().getUsername());
      newCustomer.setModifiedBy(newCustomer.getUser().getUsername());
      newCustomer.setModifiedDate(new Timestamp(System.currentTimeMillis()));
      newCustomer.getUser().setStatus(customerModel.getUser().getStatus());
      newCustomer.setGender(customerModel.getGender());
      if (customerModel.getUser().getStatus().equals("Inactive")) {
        newCustomer.getUser().setPassword("");
      }
      customerDAO.update(newCustomer);
    } else {
      customerModel.setCreatedBy(customerModel.getUser().getUsername());
      customerModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
      customerDAO.insert(customerModel);
    }
  }

  @Override
  public void remove(CustomerModel customerModel) {
    customerDAO.delete(customerModel);
  }
}
