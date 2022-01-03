package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.ICategoryDAO;
import com.example.projectshoes.dao.IProductDAO;
import com.example.projectshoes.dao.ISaledetailDAO;
import com.example.projectshoes.model.CategoryModel;
import com.example.projectshoes.model.ProductModel;
import com.example.projectshoes.paging.Pageble;
import com.example.projectshoes.utils.HibernateUtil;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.inject.Inject;
import java.math.BigInteger;
import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();
    @Inject
    ICategoryDAO categoryService;
    public ProductDAO() {
        setType(ProductModel.class);
    }

    @Override
    public ProductModel findOne(Long id) {
        StringBuilder sql = new StringBuilder("FROM Product p Where id=:id");
        ProductModel productModel=new ProductModel();
        productModel.setId(id);
        List<ProductModel> productModels = queryHibernate(sql.toString(),productModel);
        return productModels.isEmpty() ? null : productModels.get(0);
    }

    @Override
    public Long saveProduct(ProductModel productModel) {
        if(productModel.getCategoryId()!=null){
            CategoryModel categoryModel=categoryService.findByCategoryID(productModel.getCategoryId());
            productModel.setCategory(categoryModel);
        }
        return save(productModel);
    }

    @Override
    public List<ProductModel> findAll(Pageble pageble,String key) {
        ProductModel productModel=new ProductModel();
        String query="";
        if(key==null){
            query="FROM Product p where p.quantity>0";
        }
        else {
            query="FROM Product as p where p.name like '%"+key+"%'";
        }
        Query q = session.createQuery(query);
        q.setFirstResult(pageble.getOffset());
        q.setMaxResults(pageble.getLimit());
        productModel.setListResult(q.getResultList());
        return productModel.getListResult();
    }

    @Override
    public List<ProductModel> findbyCategory(Pageble pageble,String code) {
        ProductModel productModel=new ProductModel();
        StringBuilder query= new StringBuilder("select u From Product u inner join u.category t");
        query.append(" where t.code='"+code+"'");
        Query q = session.createQuery(query.toString());
        q.setFirstResult(pageble.getOffset());
        q.setMaxResults(pageble.getLimit());
        productModel.setListResult(q.getResultList());
        return productModel.getListResult();
    }

    @Override
    public List<ProductModel> Sort(String sql,String categorycode) {
        ProductModel productModel=new ProductModel();
        return queryHibernate(sql,productModel);
    }

    @Override
    public void deleteProduct(long id) {
        ProductModel productModel = findById(id);
        delete(productModel);
    }

    @Override
    public void update(ProductModel productModel) {
        saveProduct(productModel);
    }

    @Override
    public int getTotalItem() {
        Query query = session.createSQLQuery("select count(*) from Product p");
        List<BigInteger> count1 =query.list();
        int count=count1.get(0).intValue();
        return count;
    }
    @Override
    public int getTotalItemByCategory(String code) {
        Query q = session.createQuery("select count(*) From Product u inner join u.category t where t.code='"+code+"'");
        List<Long> count1 =q.list();
        int count=count1.get(0).intValue();
        return count;
    }

}
