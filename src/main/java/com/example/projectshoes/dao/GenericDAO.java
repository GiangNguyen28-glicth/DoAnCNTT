package com.example.projectshoes.dao;

import java.util.List;

public interface GenericDAO<T> {

  T findById(Long id);

  Long save(T object);

  Long delete(T object);

  List<T> queryHibernate(String sql, T object);

}
