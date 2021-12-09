package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.IDeliveryDAO;
import com.example.projectshoes.mapper.DeliveryMapper;
import com.example.projectshoes.model.DeliveryModel;
import com.example.projectshoes.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class DeliveryDAO extends AbstractDAO<DeliveryModel> implements IDeliveryDAO {
    public DeliveryDAO() {
        setType(DeliveryModel.class);
    }

    @Override
    public List<DeliveryModel> findAll() {
        StringBuilder sql = new StringBuilder("from Delivery d");
        DeliveryModel deliveryModel=new DeliveryModel();
        return queryHibernate(sql.toString(),deliveryModel);
    }
    @Override
    public DeliveryModel findOne(Long id) {
        StringBuilder sql = new StringBuilder("FROM Delivery d Where id=:id");
        DeliveryModel deliveryModel=new DeliveryModel();
        deliveryModel.setId(id);
        List<DeliveryModel> deliveryModels = queryHibernate(sql.toString(),deliveryModel);
        return deliveryModels.isEmpty() ? null : deliveryModels.get(0);
    }

    @Override
    public Long saveDelivery(DeliveryModel deliveryModel) {
        deliveryModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        return save(deliveryModel);
    }

    @Override
    public DeliveryModel findByDeliveryName(String name) {
        StringBuilder sql = new StringBuilder("FROM Delivery Where name=:name");
        DeliveryModel deliveryModel=new DeliveryModel();
        deliveryModel.setName(name);
        List<DeliveryModel> delivery = queryHibernate(sql.toString(),deliveryModel);
        return delivery.isEmpty() ? null : delivery.get(0);
    }

    @Override
    public DeliveryModel findByDeliveryID(Long id) {
        return findById(id);
    }

    @Override
    public void deleteDelivery(long id) {
        DeliveryModel deliveryModel = findById(id);
        delete(deliveryModel);
    }

    @Override
    public void update(DeliveryModel deliveryModel) {
        saveDelivery(deliveryModel);
    }

    @Override
    public List<DeliveryModel> PageDelivery(int page) {
        if (page < 1) {
            page = 1;
        }
        int offset = (page - 1) * 5;
        StringBuilder sql = new StringBuilder("select * from Delivery LIMIT 5 OFFSET ?");
        return query(sql.toString(), new DeliveryMapper(), offset);
    }

    @Override
    public int getTotalItem() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select count(*) from Delivery d");
        List<BigInteger> count1 =query.list();
        int count=count1.get(0).intValue();
        return count;
    }

    @Override
    public DeliveryModel getbyTime(Timestamp date, String phonenumber, String fullname, String address) {
        StringBuilder sql=new StringBuilder("FROM Delivery where createdDate=:createdDate and phonenumber=:phonenumber");
        sql.append(" and fullname=:fullname");
        DeliveryModel deliveryModel=new DeliveryModel();
        deliveryModel.setCreatedDate(date);
        deliveryModel.setFullname(fullname);
        deliveryModel.setPhonenumber(phonenumber);
        deliveryModel.setAddress(address);
        List<DeliveryModel> delivery = queryHibernate(sql.toString(),deliveryModel);
        return delivery.isEmpty() ? null : delivery.get(0);
    }
}
