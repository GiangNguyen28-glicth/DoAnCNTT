package com.example.projectshoes.service.impl;

import com.example.projectshoes.dao.ICategoryDAO;
import com.example.projectshoes.model.CategoryModel;
import com.example.projectshoes.service.ICategoryService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    ICategoryDAO categoryDAO;
    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
    @Override
    public Long save(CategoryModel categoryModel) {
        categoryModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        categoryModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        return categoryDAO.save(categoryModel);
    }

    @Override
    public CategoryModel findByCategoryName(String code) {
        return categoryDAO.findByCategoryName(code);
    }

    @Override
    public CategoryModel findByCategoryID(Long id) {
        return categoryDAO.findByCategoryID(id);
    }
}
