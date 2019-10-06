package com.chauchau.service;

public interface GeneralService<E> {

  Iterable<E> findAll();

  E findById(int id);

  void save(E e);

  void remove(int id);
}
