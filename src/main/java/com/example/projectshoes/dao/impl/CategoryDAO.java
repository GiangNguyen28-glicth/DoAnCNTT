package com.example.projectshoes.dao.impl;


import com.example.projectshoes.dao.ICategoryDAO;
import com.example.projectshoes.mapper.CategoryMapper;
import com.example.projectshoes.model.CategoryModel;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    public CategoryDAO() {
        setType(CategoryModel.class);
    }
    @Override
    public List<CategoryModel> findAll() {
        StringBuilder sql = new StringBuilder("from Category c");
        CategoryModel categoryModel=new CategoryModel();
        return queryHibernate(sql.toString(),categoryModel);
    }

    @Override
    public Long saveCategory(CategoryModel categoryModel) {
        return save(categoryModel);
    }

    @Override
    public CategoryModel findByCategoryName(String code) {
        StringBuilder sql = new StringBuilder("FROM category Where code=:code");
        CategoryModel categoryModel=new CategoryModel();
        categoryModel.setCode(code);
        List<CategoryModel> category = queryHibernate(sql.toString(),categoryModel);
        return category.isEmpty() ? null : category.get(0);
    }

    @Override
    public CategoryModel findByCategoryID(Long id) {
        return findById(id);
    }
}
