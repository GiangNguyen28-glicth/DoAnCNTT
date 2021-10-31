package com.example.projectshoes.validate;


import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.IUserService;
import javax.inject.Inject;

public class MyValidator {
  IUserService userService;

  public MyValidator(IUserService userService) {
    this.userService = userService;
  }

  public String validateForm(UserModel userModel) {
    if (!userModel.getPassword().equals(userModel.getRepassword())) {
      return "Re-entered password is not the same";
    } else if (userService.findByUserName(userModel.getUsername()) != null) {
      return "Account already exists";
    } else if (userService.findByEmail(userModel.getEmail()) != null) {
      return "Email already exists";
    }
    return null;
  }
}
