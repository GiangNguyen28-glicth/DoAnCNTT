package com.example.projectshoes.service.impl;

import com.example.projectshoes.dao.IProductDAO;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.paging.Pageble;
import com.example.projectshoes.service.ICategoryService;
import com.example.projectshoes.service.IProductService;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class ProductService implements IProductService {

    @Inject
    IProductDAO productDAO;
    @Inject
    ICategoryService categoryService;
    @Override
    public List<ProductModel> findAll(Pageble pageble) {
        return productDAO.findAll(pageble);
    }

    @Override
    public Long save(ProductModel productModel) {
        productModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        productModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        return productDAO.save(productModel);
    }

    @Override
    public void delete(long[] ids) {
        for(long id:ids){
            productDAO.delete(id);
        }
    }
    @Override
    public ProductModel findOne(Long id) {
        return productDAO.findOne(id);
    }
    @Override
    public void update(ProductModel productModel) {
        productModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        productDAO.update(productModel);
    }

    @Override
    public List<ProductModel> pageProduct(int page) {
        return productDAO.PageProduct(page);
    }

    @Override
    public int getTotalItem() {
        return productDAO.getTotalItem();
    }
}