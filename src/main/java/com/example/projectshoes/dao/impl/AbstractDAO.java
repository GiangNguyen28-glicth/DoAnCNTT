package com.example.projectshoes.dao.impl;


import com.example.projectshoes.dao.GenericDAO;
import com.example.projectshoes.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDAO<T> implements GenericDAO<T> {

  ResourceBundle myBundle = ResourceBundle.getBundle("db");

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
        }
        else if (obj instanceof Float){
          statement.setFloat(index, (Float) obj);
        }
        else if (obj instanceof Date){
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
          if (resultSet != null) {
            statement.close();
          }
        } catch (SQLException e) {
          return null;
        }
      }
    }
    return null;
  }

  @Override
  public void update(String sql, Object... parameters) {
    PreparedStatement statement = null;
    Connection connection = getConnection();
    try {
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(sql);
      setParameter(statement, parameters);
      statement.executeUpdate();
      connection.commit();
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (statement != null) {
          statement.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public Long insert(String sql, Object... parameters) {
    Long id = null;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      setParameter(statement, parameters);
      statement.executeUpdate();
      resultSet = statement.getGeneratedKeys();
      if (resultSet.next()) {
        id = resultSet.getLong(1);
      }
      connection.commit();
      return id;
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (statement != null) {
          statement.close();
        }
        if (resultSet != null) {
          statement.close();
        }
      } catch (SQLException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Long delete(String sql, Long id) {
    PreparedStatement statement = null;
    Connection connection = getConnection();
    try {
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(sql);
      statement.setLong(1, id);
      statement.executeUpdate();
      connection.commit();
      return id;
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (statement != null) {
          statement.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return null;
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


}
