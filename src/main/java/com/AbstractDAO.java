package com;


import java.util.List;

public interface AbstractDAO<T extends BaseEntity> {
    T saveUser(T t);

//    List<T> getAllUsers();

    void delete();

//    T update(T t);

//    List<T> getAll();

//    List<T> getByUser(T t);
}