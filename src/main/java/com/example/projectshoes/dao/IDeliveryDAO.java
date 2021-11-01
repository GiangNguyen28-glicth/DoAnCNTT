package com.example.projectshoes.dao;

import com.example.projectshoes.model.DeliveryModel;

import java.util.List;

public interface IDeliveryDAO extends GenericDAO<DeliveryModel>{
    List<DeliveryModel> findAll();
    DeliveryModel findOne(Long id);
    Long save(DeliveryModel deliveryModel);
    DeliveryModel findByDeliveryName(String name);
    DeliveryModel findByDeliveryID(Long id);
    void delete(long id);
    void update(DeliveryModel deliveryModel);
    List<DeliveryModel> PageDelivery(int page);
    int getTotalItem();
}
