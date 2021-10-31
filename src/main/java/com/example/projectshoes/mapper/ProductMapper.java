package com.example.projectshoes.mapper;

import com.example.projectshoes.model.ProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductModel> {

    @Override
    public ProductModel mapRow(ResultSet rs) {
        ProductModel productModel=new ProductModel();
        try {
            productModel.setId(rs.getLong("id"));
            productModel.setName(rs.getString("name"));
            productModel.setPrice(rs.getFloat("price"));
            productModel.setCategoryId(rs.getLong("category_id"));
            productModel.setCreatedDate(rs.getTimestamp("createddate"));
            productModel.setCreatedBy(rs.getString("createdby"));
            productModel.setModifiedBy(rs.getString("modifiedby"));
            productModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            productModel.setQuantity(rs.getInt("quantity"));
            productModel.setSize(rs.getInt("size"));
            return productModel;
        }
        catch(SQLException e) {
            return null;
        }
    }
}
