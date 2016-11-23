package com;


import java.util.List;

public interface AbstractDAO<T extends BaseEntity> {
    T save(T t);

//    List<T> getAllUsers();

    void delete();

//    T update(T t);

//    List<T> getAll();

//    Long getById(Long id);
}