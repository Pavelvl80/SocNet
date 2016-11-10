package com;

import java.util.List;

/**
 * Created by Edvard Piri on 13.10.2016.
 */
public class AbstractDAOImpl<T extends BaseEntity> implements AbstractDAO<T> {

    @Override
    public T save(T t) {
        return t;
    }

//    @Override
//    public T update(T t) {
//        return null;
//    }

//    @Override
//    public List<T> getAll() {
//        return null;
//    }
}
