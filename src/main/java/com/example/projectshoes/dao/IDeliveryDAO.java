package com.example.projectshoes.dao;

import com.example.projectshoes.model.DeliveryModel;

import java.sql.Timestamp;
import java.util.List;

public interface IDeliveryDAO extends GenericDAO<DeliveryModel>{
    List<DeliveryModel> findAll();
    DeliveryModel findOne(Long id);
    Long saveDelivery(DeliveryModel deliveryModel);
    DeliveryModel findByDeliveryName(String name);
    DeliveryModel findByDeliveryID(Long id);
    void deleteDelivery(long id);
    void update(DeliveryModel deliveryModel);
    List<DeliveryModel> PageDelivery(int page);
    int getTotalItem();
    DeliveryModel getbyTime(Timestamp date, String phonenumber, String fullname, String address);
}
