package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.ISaledetailDAO;
import com.example.projectshoes.mapper.SaledetailMapper;
import com.example.projectshoes.model.SaledetailModel;

import java.util.List;

public class SaledetailDAO extends AbstractDAO<SaledetailModel> implements ISaledetailDAO {
    @Override
    public SaledetailModel findOne(Long id) {
        StringBuilder sql=new StringBuilder("SELECT * FROM Saledetail Where id=?");
        List<SaledetailModel> saledetailModels= query(sql.toString(),new SaledetailMapper(),id);
        return saledetailModels.isEmpty() ?null :saledetailModels.get(0);
    }

    @Override
    public Long save(SaledetailModel saledetailModel) {
        StringBuilder sql=new StringBuilder("INSERT INTO Saledetail (user_id, product_id, delivery_id, quantity, total, status_delivery,");
        sql.append("createddate,modifieddate, createdby,modifiedby)");
        sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?)");
        return insert(sql.toString(),saledetailModel.getUserId(),saledetailModel.getProductId(),saledetailModel.getDeliveryId(),
                saledetailModel.getQuantity(), saledetailModel.getTotal(),saledetailModel.getStatus_delivery(),
                saledetailModel.getCreatedDate(),saledetailModel.getModifiedDate(),saledetailModel.getCreatedBy(),saledetailModel.getModifiedBy());
    }

    @Override
    public List<SaledetailModel> findAll() {
        StringBuilder sql=new StringBuilder("SELECT * FROM Saledetail");
        return query(sql.toString(),new SaledetailMapper());
    }

    @Override
    public List<SaledetailModel> findbyUserID(Long id) {
        return null;
    }

    @Override
    public List<SaledetailModel> findbyProductID(Long id) {
        return null;
    }

    @Override
    public List<SaledetailModel> findbyDeliveryID(Long id) {
        return null;
    }


    @Override
    public void delete(long id) {
        StringBuilder sql=new StringBuilder("DELETE FROM Saledetail WHERE id = ?");
        update(sql.toString(),id);
    }

    @Override
    public void update(SaledetailModel saledetailModel) {
        StringBuilder sql=new StringBuilder("UPDATE Saledetail set user_id=?, product_id=?, delivery_id=?,total=?, quantity=?, status_delivery=?,");
        sql.append("modifieddate=?,modifiedby=? WHERE id=?");
        update(sql.toString(),saledetailModel.getUserId(),saledetailModel.getProductId(),saledetailModel.getDeliveryId(),
                saledetailModel.getTotal(),saledetailModel.getQuantity(),saledetailModel.getStatus_delivery(),
                saledetailModel.getModifiedDate(),saledetailModel.getModifiedBy(),saledetailModel.getId());
    }

    @Override
    public List<SaledetailModel> PageSaledetail(int page) {
        if(page<1){
            page=1;
        }
        int offset=(page-1)*5;
        StringBuilder sql=new StringBuilder("select * from Saledetail LIMIT 5 OFFSET ?");
        return query(sql.toString(),new SaledetailMapper(),offset);
    }

    @Override
    public int getTotalItem() {
        String sql="SELECT count(*) FROM Saledetail";
        return count(sql);
    }
}
