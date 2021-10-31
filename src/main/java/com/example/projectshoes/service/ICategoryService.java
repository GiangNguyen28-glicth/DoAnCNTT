package com.example.projectshoes.service;

import com.example.projectshoes.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    Long save(CategoryModel categoryModel);
    CategoryModel findByCategoryName(String code);
    CategoryModel findByCategoryID(Long id);
}
