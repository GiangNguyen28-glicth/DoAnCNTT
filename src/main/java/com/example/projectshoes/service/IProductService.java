package com.example.projectshoes.service;

import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.paging.Pageble;

import java.util.List;

public interface IProductService {
    List<ProductModel> findAll(Pageble pageble);
    Long save(ProductModel productModel);
    void delete(long[] ids);
    ProductModel findOne(Long id);
    void update(ProductModel productModel);
    List<ProductModel> pageProduct(int page);
    int getTotalItem();
}
