package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.ISaledetailDAO;
import com.example.projectshoes.model.SaledetailModel;
import com.example.projectshoes.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.math.BigInteger;
import java.util.List;

public class SaledetailDAO extends AbstractDAO<SaledetailModel> implements ISaledetailDAO {
    public SaledetailDAO() {
        setType(SaledetailModel.class);
    }

    @Override
    public SaledetailModel findOne(Long id) {
        StringBuilder sql = new StringBuilder("FROM Saledetail s Where s.id=:id");
        SaledetailModel saledetailModel=new SaledetailModel();
        saledetailModel.setId(id);
        List<SaledetailModel> saledetailModels = queryHibernate(sql.toString(),saledetailModel);
        return saledetailModels.isEmpty() ? null : saledetailModels.get(0);
    }

    @Override
    public Long saveSaledetail(SaledetailModel saledetailModel) {
        return save(saledetailModel);
    }


    @Override
    public List<SaledetailModel> findAll() {
        StringBuilder sql = new StringBuilder("FROM Saledetail s");
        SaledetailModel saledetailModel=new SaledetailModel();
        return queryHibernate(sql.toString(), saledetailModel);

    }

    @Override
    public void deleteSaledetail(long id) {
        SaledetailModel saledetailModel = findById(id);
        delete(saledetailModel);
    }

    @Override
    public void update(SaledetailModel saledetailModel) {
        update(saledetailModel);
    }

    @Override
    public int getTotalItem() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select count(*) from Saledetail s");
        List<BigInteger> count1 =query.list();
        int count=count1.get(0).intValue();
        return count;
    }

    @Override
    public SaledetailModel findbyCode(Long code) {
        StringBuilder sql = new StringBuilder("FROM Saledetail s Where s.code=:code");
        SaledetailModel saledetailModel=new SaledetailModel();
        saledetailModel.setCode(code);
        List<SaledetailModel> saledetailModels = queryHibernate(sql.toString(),saledetailModel);
        return saledetailModels.isEmpty() ? null : saledetailModels.get(0);
    }

    @Override
    public List<SaledetailModel> gettop3() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        SaledetailModel saledetailModel=new SaledetailModel();
        StringBuilder sql=new StringBuilder("select u.product From Saledetail u group by u.product order by sum(u.quantity) desc");
        Query q = session.createQuery(sql.toString());
        q.setFirstResult(0);
        q.setMaxResults(3);
        saledetailModel.setListResult(q.getResultList());
        return saledetailModel.getListResult();
    }

    @Override
    public List<SaledetailModel> findbyProductId(Long id) {
        StringBuilder sql=new StringBuilder("select u from Saledetail u where u.product.id="+id);
        List<SaledetailModel> saledetailModels=queryHibernate(sql.toString(),null);
        return saledetailModels;
    }
}
