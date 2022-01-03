package com.example.projectshoes.dao.impl;
import com.example.projectshoes.dao.GenericDAO;
import com.example.projectshoes.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AbstractDAO<T> implements GenericDAO<T> {

  private Class<T> type = (Class<T>) this.getClass();

  @Override
  @SuppressWarnings("unchecked")
  public List<T> queryHibernate(String sql, T object) {
    List<T> listOfTests = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      if (object != null) {
        listOfTests = session.createQuery(sql)
                .setProperties(object)
                .getResultList();
      } else {
        // SELECT * FROM USER/PRODUCT
        listOfTests = session.createQuery(sql)
                .list();
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return listOfTests;
  }

  @Override
  public T findById(Long id) {
    T obj = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      Transaction transaction = session.beginTransaction();
      obj = session.get(type, id);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return obj;
  }


  // thêm và update
  @Override
  public Long save(T object) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.saveOrUpdate(object);
      transaction.commit();
      return 1L;
    } catch (Exception ex) {
      if (transaction != null) {
        transaction.rollback();
      }
      ex.printStackTrace();
    }
    return 0L;
  }

  // delete
  @Override
  public Long delete(T object) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      Transaction transaction = session.beginTransaction();
      session.delete(object);
      transaction.commit();
      return 1L;
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }

  }


  public Class<T> getType() {
    return type;
  }

  public void setType(Class<T> type) {
    this.type = type;
  }
}