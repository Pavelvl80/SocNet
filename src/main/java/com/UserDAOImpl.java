package com;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl extends AbstactDAOimplDB<Users> implements UserDAO {
    //emulates db


    //    @Override
//    public User save(User user) {
//        users.add(user);
//        return user;
//    }

//    @Override
//    public void setLogin(User user) {
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
//        for (User user : getAll()) {
//            if (user.getName().equals(name) && user.getPassword().equals(psw))
//                return user;
//        }
//        return null;
//    }
//
//    @Override
//    public Users makeInactive(User user) {
//        int i = getAll().indexOf(user);
//        user.setActive(false);
//        getAll().set(i, user);
//
//        return users;
//    }

//    @Override
//    public List<User> getAll() {
//        return users;
//    }
//
//    @Override
//    public User save(User user) {
//        users.add(user);
//        return user;
//    }

//    @Override
//    public void clean() {
//        getAll().removeAll(getAll());
//    }

//    @Override
//    public User delete(User user) {
//        return null;
//    }
//
//    @Override
//    public User update(User user) {
//        return null;
//    }


    @Override
    public Users save(User user) {
        return null;
    }

    @Override
    public List<Users> getAll() {
        String sql = "SELECT * FROM USERS";
        Query query = getSession().createQuery(sql);
        return query.list();
    }
}