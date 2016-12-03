package com.dao;


import com.model.BaseEntity;

public interface AbstractDAO<T extends BaseEntity> {
    T save(T t);

//    List<T> getAllUsers();

    void delete();

//    T update(T t);

//    List<T> getAll();

//    T getById(Long id);
}