package com.example.projectshoes.dao;

import com.example.projectshoes.model.SaledetailModel;

import java.util.List;

public interface ISaledetailDAO extends GenericDAO<SaledetailModel>{
    SaledetailModel findOne(Long id);
    Long save(SaledetailModel saledetail);
    List<SaledetailModel> findAll();
    List<SaledetailModel> findbyUserID(Long id);
    List<SaledetailModel> findbyProductID(Long id);
    List<SaledetailModel> findbyDeliveryID(Long id);
    void delete(long id);
    void update(SaledetailModel saledetailModel);
    List<SaledetailModel> PageSaledetail(int page);
    int getTotalItem();
}
