package com.example.projectshoes.service.impl;

import com.example.projectshoes.dao.IDeliveryDAO;
import com.example.projectshoes.model.DeliveryModel;
import com.example.projectshoes.service.IDeliveryService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class DeliveryService implements IDeliveryService {

    @Inject
    IDeliveryDAO deliveryDAO;

    @Override
    public List<DeliveryModel> findAll() {
        return deliveryDAO.findAll();
    }

    @Override
    public Long save(DeliveryModel deliveryModel) {
        deliveryModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        deliveryModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        return deliveryDAO.save(deliveryModel);
    }

    @Override
    public DeliveryModel findByDeliveryName(String name) {
        return deliveryDAO.findByDeliveryName(name);
    }

    @Override
    public DeliveryModel findByDeliveryID(Long id) {
        return deliveryDAO.findByDeliveryID(id);
    }

    @Override
    public void delete(long[] ids) {
        for(long id:ids){
            deliveryDAO.delete(id);
        }
    }

    @Override
    public DeliveryModel findOne(Long id) {
        return deliveryDAO.findOne(id);
    }

    @Override
    public void update(DeliveryModel deliveryModel) {
        deliveryModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        deliveryDAO.update(deliveryModel);
    }

    @Override
    public List<DeliveryModel> pageDelivery(int page) {
        return deliveryDAO.PageDelivery(page);
    }

    @Override
    public int getTotalItem() {
        return deliveryDAO.getTotalItem();
    }
}
