package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.IDeliveryDAO;
import com.example.projectshoes.mapper.DeliveryMapper;
import com.example.projectshoes.model.DeliveryModel;

import java.util.List;

public class DeliveryDAO extends AbstractDAO<DeliveryModel> implements IDeliveryDAO {

    @Override
    public List<DeliveryModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM Delivery");
        return query(sql.toString(),new DeliveryMapper());
    }

    @Override
    public DeliveryModel findOne(Long id) {
        StringBuilder sql=new StringBuilder("SELECT * FROM Delivery Where id=?");
        List<DeliveryModel> deliveryModels= query(sql.toString(),new DeliveryMapper(),id);
        return deliveryModels.isEmpty() ?null :deliveryModels.get(0);
    }


    @Override
    public Long save(DeliveryModel deliveryModel) {
        StringBuilder sql=new StringBuilder("INSERT INTO Delivery (name, shipper, delivery_date, status,createddate, createdby,modifiedby,modifieddate)");
        sql.append(" VALUES(?,?,?,?,?,?,?,?)");
        return insert(sql.toString(),deliveryModel.getName(),deliveryModel.getShipper(),deliveryModel.getDeliveryDate(),
                deliveryModel.getStatus(), deliveryModel.getCreatedDate(), deliveryModel.getCreatedBy(),
                deliveryModel.getModifiedBy(), deliveryModel.getModifiedDate());
    }

    @Override
    public DeliveryModel findByDeliveryName(String name) {
        StringBuilder sql=new StringBuilder("SELECT * FROM Delivery Where name=?");
        sql.append(" VALUES(?)");
        List<DeliveryModel> delivery= query(sql.toString(),new DeliveryMapper(),name);
        return  delivery.isEmpty() ? null :delivery.get(0);
    }

    @Override
    public DeliveryModel findByDeliveryID(Long id) {
        StringBuilder sql=new StringBuilder("SELECT * FROM Delivery Where id=?");
        sql.append(" VALUES(?)");
        List<DeliveryModel> delivery= query(sql.toString(),new DeliveryMapper(),id);
        return  delivery.isEmpty() ? null :delivery.get(0);
    }

    @Override
    public void delete(long id) {
        StringBuilder sql=new StringBuilder("DELETE FROM Delivery WHERE id = ?");
        update(sql.toString(),id);
    }

    @Override
    public void update(DeliveryModel deliveryModel) {
        StringBuilder sql=new StringBuilder("UPDATE Delivery set name=?, shipper=?, delivery_date=?, status=?,");
        sql.append("modifieddate=?,modifiedby=? WHERE id=?");
        update(sql.toString(),deliveryModel.getName(),deliveryModel.getShipper(),deliveryModel.getDeliveryDate(),
                deliveryModel.getStatus(),deliveryModel.getModifiedDate(),deliveryModel.getModifiedBy(),deliveryModel.getId());
    }

    @Override
    public List<DeliveryModel> PageDelivery(int page) {
        if(page<1){
            page=1;
        }
        int offset=(page-1)*5;
        StringBuilder sql=new StringBuilder("select * from Delivery LIMIT 5 OFFSET ?");
        return query(sql.toString(),new DeliveryMapper(),offset);
    }

    @Override
    public int getTotalItem() {
        String sql="SELECT count(*) FROM Delivery";
        return count(sql);
    }
}
