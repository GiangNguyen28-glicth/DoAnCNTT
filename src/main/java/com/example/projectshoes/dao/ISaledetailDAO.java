package com.example.projectshoes.dao;

import com.example.projectshoes.model.SaledetailModel;

import java.lang.reflect.Array;
import java.util.List;

public interface ISaledetailDAO extends GenericDAO<SaledetailModel>{
    SaledetailModel findOne(Long id);
    Long saveSaledetail(SaledetailModel saledetailModel);
    List<SaledetailModel> findAll();
    void deleteSaledetail(long id);
    void update(SaledetailModel saledetailModel);
    int getTotalItem();
    SaledetailModel findbyCode(Long code);
    List<SaledetailModel> gettop3();
    List<SaledetailModel> findbyProductId(Long id);
}
