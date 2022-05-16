package com.nuriza.fqw.fqw.services;

import java.util.List;

public interface BaseService<T>{
    List<T> getAll();
    void create(T t);
    T getById(Integer id);
    void delete(T t);
    T update(T t);
}
