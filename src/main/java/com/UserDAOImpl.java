package com;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UserDAOImpl extends AbstractDAOImplDB<Users> implements UserDAO {
    //emulates db


    //    @Override
//    public UserAll save(UserAll user) {
//        users.add(user);
//        return user;
//    }

//    @Override
//    public void setLogin(UserAll user) {
//        if (user != null) {
//            int i = getAll().indexOf(user);
//
//            if (user.isLogged()) user.setLogged(false);
//            else user.setLogged(true);
//
//            getAll().set(i, user);
//        }
//    }

//    @Override
//    public Users get(String name, String psw) {
//        for (UserAll user : getAll()) {
//            if (user.getName().equals(name) && user.getPassword().equals(psw))
//                return user;
//        }
//        return null;
//    }
//
//    @Override
//    public Users makeInactive(UserAll user) {
//        int i = getAll().indexOf(user);
//        user.setActive(false);
//        getAll().set(i, user);
//
//        return users;
//    }

//    @Override
//    public List<UserAll> getAll() {
//        return users;
//    }
//
//    @Override
//    public UserAll save(UserAll user) {
//        users.add(user);
//        return user;
//    }

    @Override
    public void clean() {
        delete();
    }

//    @Override
//    public UserAll delete(UserAll user) {
//        return null;
//    }


    @Override
    public Users save(Users user) {
        return saveUser(user);
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
    public Users getByUser() {
        String hql = "from Users t where t.id = 1003";
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
}