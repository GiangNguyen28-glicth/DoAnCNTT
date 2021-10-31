package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.IProductDAO;
import com.example.projectshoes.mapper.ProductMapper;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.paging.Pageble;

import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {


    @Override
    public ProductModel findOne(Long id) {
        StringBuilder sql=new StringBuilder("SELECT * FROM product Where id=?");
        List<ProductModel> productModels= query(sql.toString(),new ProductMapper(),id);
        return productModels.isEmpty() ?null :productModels.get(0);
    }

    @Override
    public Long save(ProductModel productModel) {
        StringBuilder sql=new StringBuilder("INSERT INTO product (name,price,category_id,size,quantity,");
        sql.append("createddate,modifieddate, createdby,modifiedby)");
        sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
        return insert(sql.toString(),productModel.getName(),productModel.getPrice(),productModel.getCategoryId(),
                productModel.getSize(),productModel.getQuantity(),productModel.getCreatedDate(),productModel.getModifiedDate(),productModel.getCreatedBy(),productModel.getModifiedBy());
    }

    @Override
    public List<ProductModel> findAll(Pageble pageble) {
        StringBuilder sql=new StringBuilder("SELECT * FROM product");
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
        }
        return query(sql.toString(),new ProductMapper());
    }
    @Override
    public List<ProductModel> findbyCategoryID(Long id) {
        return null;
    }
    @Override
    public void delete(long id) {
        StringBuilder sql=new StringBuilder("DELETE FROM product WHERE id = ?");
        delete(sql.toString(),id);
    }

    @Override
    public void update(ProductModel productModel) {
        StringBuilder sql=new StringBuilder("UPDATE product set name=?,price=?,category_id=?,size=?,quantity=?,");
        sql.append("modifieddate=?,modifiedby=? WHERE id=?");
        update(sql.toString(),productModel.getName(),productModel.getPrice(),productModel.getCategoryId(),
                productModel.getSize(),productModel.getQuantity(),productModel.getModifiedDate(),productModel.getModifiedBy(),productModel.getId());
    }
    @Override
    public List<ProductModel> PageProduct(int page) {
        if(page<1){
            page=1;
        }
        int offset=(page-1)*5;
        StringBuilder sql=new StringBuilder("select * from product LIMIT 5 OFFSET ?");
        return query(sql.toString(),new ProductMapper(),offset);
    }
    @Override
    public int getTotalItem() {
        String sql="SELECT count(*) FROM product";
        return count(sql);
    }
}
