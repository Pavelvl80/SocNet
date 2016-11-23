package com;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

@Repository
@Transactional
public class AbstractDAOImpl<T extends BaseEntity> implements AbstractDAO<T> {
    List<T> list = new ArrayList<>();

    public AbstractDAOImpl() {
    }

//    @Override
//    public List<T> getAllUsers() {
//        return null;
//    }


    @Override
    public void delete() {

    }

    @Override
    public T save(T t) {
        list.add(t);
        return t;
    }

   /* @Override
    public List<T> getAll() {
        return list;
    }
    @Override
    public T findById(long id) {
        for (T t : list) {
            if (t.getId() == id) return t;
        }
        return null;
    }
    @Override
    public T delete(T t) {
        list.remove(t);
        return t;
    }
    @Override
    public T update(T t) {
        UnaryOperator<T> unaryOperator = new UnaryOperator<T>() {
            @Override
            public T apply(T k) {
                if (k.getId() == t.getId())
                    return t;
                else return k;
            }
        };
        list.replaceAll(unaryOperator);
        return t;
    }*/
}