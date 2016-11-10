package com;


import java.util.List;

public interface AbstractDAO<T extends BaseEntity> {
    T save(T t);

//    T update(T t);

//    List<T> getAll();
}