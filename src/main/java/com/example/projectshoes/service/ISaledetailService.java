package com.example.projectshoes.service;

import com.example.projectshoes.model.SaledetailModel;

import java.util.List;

public interface ISaledetailService {
    List<SaledetailModel> findAll();
    Long save(SaledetailModel saledetailModel);
    void delete(long[] ids);
    SaledetailModel findOne(Long id);
    void update(SaledetailModel saledetailModel);
    List<SaledetailModel> pageProduct(int page);
    int getTotalItem();
}
