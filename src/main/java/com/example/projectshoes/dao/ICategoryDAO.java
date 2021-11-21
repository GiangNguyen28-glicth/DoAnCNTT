package com.example.projectshoes.dao;


import com.example.projectshoes.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
    List<CategoryModel> findAll();
    Long saveCategory(CategoryModel categoryModel);
    CategoryModel findByCategoryName(String code);
    CategoryModel findByCategoryID(Long id);
}
