package com.codegym.blog_management_spring_boot.service;

import java.util.List;

public interface IService<T> {

    List<T> getAll();

    void save(T s);

    void update(Long id, T s);

    void remove(Long id);

    T findById(Long id);

    List<T> findByName(String name);

}
