package com.dao;

import com.model.Users;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl extends AbstractDAOImplDB<Users> implements UserDAO {
    //emulates db


    //    @Override
//    public UserOld saveMessage(UserOld user) {
//        users.add(user);
//        return user;
//    }


    @Override
    public Integer isLogin(Long id) {
        String selectByEmailAndPass = "from Users t where t.id = :idParam";
        Query query = getSession().createQuery(selectByEmailAndPass);
        query.setParameter("idParam", id);
        Users user = (Users) query.uniqueResult();
        if (user.getIsLogin() == null) user.setIsLogin(0);
        return user.getIsLogin();
    }

    //rewrite these two methods in one
    @Override
    public void setLoginStatus(Users user, int i) {
        user.setIsLogin(i);
        entityManager.merge(user);
    }

//    @Override
//    public void logout(Users user) {
//        user.setIsLogin(0);
//        entityManager.merge(user);
//    }

    @Override
    public Users get(String email, String psw) {
        String selectByEmailAndPass = "from Users t where t.email = :emailParam and t.password = :passwordParam";
        Query query = getSession().createQuery(selectByEmailAndPass);
        query.setParameter("emailParam", email);
        query.setParameter("passwordParam", psw);
        return (Users) query.uniqueResult();
    }
//
//    @Override
//    public Users makeInactive(UserOld user) {
//        int i = getAll().indexOf(user);
//        user.setActive(false);
//        getAll().set(i, user);
//
//        return users;
//    }

//    @Override
//    public List<UserOld> getAll() {
//        return users;
//    }
//
//    @Override
//    public UserOld saveMessage(UserOld user) {
//        users.add(user);
//        return user;
//    }

    @Override
    public void clean() {
        delete();
    }

//    @Override
//    public UserOld delete(UserOld user) {
//        return null;
//    }


    @Override
    public Users saveUser(Users user) {
        return save(user);
    }

    @Override
    public List<Users> getAll() {
        String hql = "from Users t";
        Query query = getSession().createQuery(hql);
        return query.list();

//        return getAllUsers();
//        List<User> result = (List<User>) session.createQuery("from User").list();
//        List<User> result = (List<User>) session.createQuery("from users").list();
    }


    @Override
    public Long getCount() {
        String hql = "select count(*) from Users t";
        Query query = getSession().createQuery(hql);
        return (Long) query.uniqueResult();
    }

    @Override
    public Users getByUser() {
        String hql = "from Users t where t.id = 1026";
        Query query = getSession().createQuery(hql);
        return (Users) query.uniqueResult();
    }

    @Override
    public Users getByEmailOrUserName(String email, String userName) {
        String requestToDb = "from Users t where t.email = :emailParam or t.userName = :userNameParam";
        Query query = getSession().createQuery(requestToDb);
        query.setParameter("emailParam", email);
        query.setParameter("userNameParam", userName);

        return (Users) query.uniqueResult();
    }

    @Override
    public List<Users> getNumbUsers(Integer numb) {
        String hql = "from Users t";
        Query query = getSession().createQuery(hql);
        query.setMaxResults(numb);
        return query.list();
    }

    @Override
    public Users getByUserName(String userName) {
        String requestToDb = "from Users t where t.userName = :userName";
        Query query = getSession().createQuery(requestToDb);
        query.setParameter("userName", userName);

        return (Users) query.uniqueResult();
    }
}