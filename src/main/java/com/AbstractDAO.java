package com;

import java.util.List;


public interface AbstractDAO<T extends AbstractParams> {
    T save(T t);

    T update(T t);

    T delete(T t);

    T findById(T t);

    List<T> getAll();

}