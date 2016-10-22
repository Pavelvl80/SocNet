package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edvard Piri on 22.10.2016.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public User save(User user) throws Exception {
        User savedUser = userDAO.save(user);
        if (savedUser == null) throw new Exception("user is not saved");

        user.setLogged(true);

        return savedUser;
    }

    @Override
    public User get(String name, String psw) {
        return userDAO.get(name, psw);
    }

    @Override
    public void setLogin(User user) {
        userDAO.setLogin(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void clean() {
        userDAO.clean();
    }

    @Override
    public void addToFriend(User fromUser, User toUser) throws Exception {

        if (!fromUser.isLogged()) throw new Exception("you are is not logged in");

        fromUser.getFriends().add(toUser);
        toUser.getFriends().add(fromUser);
    }


    @Override
    public User login(String userName, String password) {
        User curUser = userDAO.get(userName, password);
        if (curUser != null) {
            curUser.setLogged(true);
            userDAO.update(curUser);
        }
        return curUser;

    }

    @Override
    public User logout(User user) {
        user.setLogged(false);
        userDAO.update(user);
        return user;
    }
}
