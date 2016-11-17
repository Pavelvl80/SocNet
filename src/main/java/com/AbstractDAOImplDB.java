package com;

import com.AbstractDAO;
import com.BaseEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * Created by Edvard Piri on 09.11.2016.
 */
@Repository
@Transactional
public class AbstractDAOImplDB<T extends BaseEntity> implements AbstractDAO<T> {

    @PersistenceContext
    EntityManager entityManager;

    public AbstractDAOImplDB() {

    }

    @Override
    public T saveUser(T t) {
        entityManager.persist(t);
        return t;
    }

//    @Override
//    public List<T> getAllUsers() {
//        String sql = "SELECT t FROM USERS";
//        Query query = getSession().createQuery(sql);
//        return query.list();
//    }

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
