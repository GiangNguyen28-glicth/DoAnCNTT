package com.example.projectshoes.service;

import com.example.projectshoes.model.SaledetailModel;

import java.util.List;

public interface ISaledetailService {
    List<SaledetailModel> findAll();
    Long saveSaledetail(SaledetailModel saledetailModel);
    void deleteSaledetail(long[] ids);
    SaledetailModel findOne(Long id);
    void update(SaledetailModel saledetailModel);
    int getTotalItem();
    List<SaledetailModel> gettop3();
    void deletebyProductId(long[] ids);
}
