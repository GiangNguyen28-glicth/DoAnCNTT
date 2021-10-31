package com.example.projectshoes.dao;


import com.example.projectshoes.mapper.RowMapper;
import java.util.List;

public interface GenericDAO<T> {

  <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

  void update(String sql, Object... parameters);

  Long insert(String sql, Object... parameters);

  Long delete(String sql, Long id);

  int count(String sql, Object... parameters);


}
