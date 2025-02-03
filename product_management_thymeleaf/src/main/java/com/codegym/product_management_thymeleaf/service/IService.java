package com.codegym.product_management_thymeleaf.service;

import java.util.List;

public interface IService<T>{

    List<T> getAll();

    void save(T s);

    void update(int id, T s);

    void remove(Integer id);

    T findById(int id);

    List<T> findByName(String name);

}
