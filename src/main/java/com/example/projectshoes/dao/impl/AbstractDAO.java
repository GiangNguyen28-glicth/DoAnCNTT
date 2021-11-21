package com.example.projectshoes.dao.impl;


import com.example.projectshoes.dao.GenericDAO;
import com.example.projectshoes.mapper.RowMapper;
import com.example.projectshoes.utils.HibernateUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AbstractDAO<T> implements GenericDAO<T> {

  ResourceBundle myBundle = ResourceBundle.getBundle("db");

  private Class<T> type = (Class<T>) this.getClass();


  public Connection getConnection() {
    try {
      Class.forName(myBundle.getString("driverName"));
      String url = myBundle.getString("url");
      String user = myBundle.getString("user");
      String password = myBundle.getString("password");
      return DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException | SQLException e) {
      return null;
    }
  }

  private void setParameter(PreparedStatement statement, Object... parameters) {
    int index;
    try {
      for (int i = 0; i < parameters.length; i++) {
        Object obj = parameters[i];
        index = i + 1;
        if (obj instanceof Long) {
          statement.setLong(index, (Long) obj);
        } else if (obj instanceof String) {
          statement.setString(index, (String) obj);
        } else if (obj instanceof Integer) {
          statement.setInt(index, (Integer) obj);
        } else if (obj instanceof Timestamp) {
          statement.setTimestamp(index, (Timestamp) obj);
        } else if (obj instanceof Float) {
          statement.setFloat(index, (Float) obj);
        } else if (obj instanceof Date) {
          statement.setDate(index, (Date) obj);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  @Override
  public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
    List<T> results = new ArrayList<>();
    //open connection
    Connection connection = getConnection();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    if (connection != null) {
      try {
        statement = connection.prepareStatement(sql);
        setParameter(statement, parameters);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
          results.add(rowMapper.mapRow(resultSet));
        }
        return results;
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          connection.close();
          if (statement != null) {
            statement.close();
          }
        } catch (Exception ex) {
          System.out.println(ex.getMessage());
        }
      }
      return results;
    }
    return results;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<T> queryHibernate(String sql, T object) {
    List<T> listOfTests = null;
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      if (object != null) {
        listOfTests = session.createQuery(sql)
                .setProperties(object)
                .getResultList();
      } else {
        // SELECT * FROM USER/PRODUCT
        listOfTests = session.createQuery(sql)
                .list();
      }
      transaction.commit();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return listOfTests;
  }

  @Override
  public T findById(Long id) {
    Query query = null;
    Transaction transaction = null;
    T obj = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
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
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.delete(object);
      transaction.commit();
      return 1L;
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }
  }

  @Override
  public int count(String sql, Object... parameters) {
    Connection connection = getConnection();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    if (connection != null) {
      try {
        int count = 0;
        statement = connection.prepareStatement(sql);
        setParameter(statement, parameters);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
          count = resultSet.getInt(1);
        }
        return count;
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          connection.close();
          if (statement != null) {
            statement.close();
          }
          if (resultSet != null) {
            statement.close();
          }
        } catch (SQLException e) {
          return 0;
        }
      }
    }
    return 0;
  }


  public Class<T> getType() {
    return type;
  }

  public void setType(Class<T> type) {
    this.type = type;
  }
}
