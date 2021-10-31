package com.example.projectshoes.mapper;

import com.example.projectshoes.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet rs) {
        CategoryModel categoryModel=new CategoryModel();
        try{
            categoryModel.setId(rs.getLong("id"));
            categoryModel.setCode(rs.getString("code"));
            categoryModel.setCreatedDate(rs.getTimestamp("createddate"));
            categoryModel.setCreatedBy(rs.getString("createdby"));
            categoryModel.setModifiedBy(rs.getString("modifiedby"));
            categoryModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            return categoryModel;
        }catch (SQLException e){
            System.out.println("Failed");
            return null;
        }
    }
}
