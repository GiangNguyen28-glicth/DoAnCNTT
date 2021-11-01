package com.example.projectshoes.service;

import com.example.projectshoes.model.DeliveryModel;

import java.util.List;

public interface IDeliveryService {
    List<DeliveryModel> findAll();
    Long save(DeliveryModel deliveryModel);
    DeliveryModel findByDeliveryName(String name);
    DeliveryModel findByDeliveryID(Long id);
    void delete(long[] ids);
    DeliveryModel findOne(Long id);
    void update(DeliveryModel deliveryModel);
    List<DeliveryModel> pageDelivery(int page);
    int getTotalItem();
}
