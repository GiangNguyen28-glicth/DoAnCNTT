package com.example.projectshoes.service;

import com.example.projectshoes.utils.CartModel;

public interface IPaymentServices {

  String authorizePayment(CartModel cartModel);
}
