package com.example.projectshoes.dao;


import com.example.projectshoes.mapper.RowMapper;
import java.util.List;

public interface GenericDAO<T> {


  <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

  T findById(Long id);

  Long save(T object);

  Long delete(T object);

  int count(String sql, Object... parameters);

  List<T> queryHibernate(String sql, T object);

}
