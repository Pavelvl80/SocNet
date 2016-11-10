package com;

import com.AbstractDAO;
import com.BaseEntity;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * Created by Edvard Piri on 09.11.2016.
 */
public class AbstactDAOimplDB<T extends BaseEntity> implements AbstractDAO<T> {

    @PersistenceContext
    EntityManager entityManager;

    public AbstactDAOimplDB() {

    }

    @Override
    public T save(T t) {
        entityManager.persist(t);
        return t;
    }

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

//    @Override
//    public List<T> getAll() {
//        String sql = "SELECT * FROM USER";
//
//        Query query = getSession().createQuery(sql);
//
//        return query.list();
//    }

}
