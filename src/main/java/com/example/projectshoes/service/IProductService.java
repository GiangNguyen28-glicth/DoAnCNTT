package com.example.projectshoes.service;

import com.example.projectshoes.model.DeliveryModel;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.paging.Pageble;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IProductService {
    List<ProductModel> findAll(Pageble pageble,String key);
    Long saveProduct(ProductModel productModel);
    void deleteProduct(long[] ids);
    ProductModel findOne(Long id);
    void update(ProductModel productModel);
    int getTotalItem();
    List<ProductModel> findbyCategory(Pageble pageble,String code);
    List<ProductModel> Sort(String sql,String categorycode);
    int getTotalItemByCategory(String code);
    void UpdateAfertCheckout(HttpServletRequest req, UserModel userModel, DeliveryModel deliveryModel);
}
