package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by Edvard Piri on 13.10.2016.
 */
public class AbstractDAOImpl<T extends ID> implements AbstractDAO<T> {
    List<T> db;

    @Override
    public T save(T t) {
        db.add(t);
        return t;
    }

    @Override
    public T update(T t) {
        UnaryOperator<T> unaryOperator = new UnaryOperator<T>() {
            @Override
            public T apply(T k) {
                if(t.getId() == k.getId())
                    return t;
                else return k;
            }
        };
        db.replaceAll(unaryOperator);
        return t;
    }

    @Override
    public T delete(T t) {
        db.remove(t);
        return t;
    }

    @Override
    public T findById(T t) {
        T result = null;
        for (T elem : db) {
            if (elem.getId() == t.getId()) result = t;
        }
        return result;
    }

    @Override
    public List<T> getAll() {
        return db;
    }
}
