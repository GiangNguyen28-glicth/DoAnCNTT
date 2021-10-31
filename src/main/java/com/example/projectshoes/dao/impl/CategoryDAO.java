package com.example.projectshoes.dao.impl;


import com.example.projectshoes.dao.ICategoryDAO;
import com.example.projectshoes.mapper.CategoryMapper;
import com.example.projectshoes.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> findAll() {
        StringBuilder sql= new StringBuilder("SELECT * FROM category");
        return query(sql.toString(),new CategoryMapper());
    }

    @Override
    public Long save(CategoryModel categoryModel) {
        StringBuilder sql=new StringBuilder("INSERT INTO category (code,createddate,modifieddate,createdby,modifiedby)");
        sql.append(" VALUES(?,?,?,?,?)");
        return insert(sql.toString(),categoryModel.getCode(),categoryModel.getCreatedDate(),categoryModel.getModifiedDate(),
                categoryModel.getCreatedBy(),categoryModel.getModifiedBy());
    }

    @Override
    public CategoryModel findByCategoryName(String code) {
        StringBuilder sql=new StringBuilder("SELECT * FROM category Where code=?");
        sql.append(" VALUES(?)");
        List<CategoryModel> category= query(sql.toString(),new CategoryMapper(),code);
        return  category.isEmpty() ? null :category.get(0);
    }

    @Override
    public CategoryModel findByCategoryID(Long id) {
        StringBuilder sql=new StringBuilder("SELECT * FROM category Where id=?");
        sql.append(" VALUES(?)");
        List<CategoryModel> category= query(sql.toString(),new CategoryMapper(),id);
        return  category.isEmpty() ? null :category.get(0);
    }
}
