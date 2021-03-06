package com.service;

import com.dao.UserDAO;
import com.model.Users;
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
    public Users save(Users user) throws Exception {
        return userDAO.saveUser(user);
    }

    @Override
    public String registerUser(Users user) {
        Users users = userDAO.getByEmailOrUserName(user.getEmail(), user.getUserName());

        if (users != null)
            return "User with this email or name is registered";

        userDAO.saveUser(user);
        return "registered";
    }

    @Override
    public List<Users> getUsers() {
        return userDAO.getAll();
    }

    @Override
    public Long getUsersCount() {
        return userDAO.getCount();
    }

    //
//    @Override
//    public UserOld get(String name, String psw) {
//        return userDAO.get(name, psw);
//    }
//
//    @Override
//    public void setLogin(Users user) {
//        userDAO.setLogin(user);
//    }

    //
//    @Override
//    public List<UserOld> getAll() {
//        return userDAO.getAll();
//    }
//
    @Override
    public void cleanUsers() {
        userDAO.clean();
    }

    //
//    @Override
//    public void addToFriend(UserOld fromUser, UserOld toUser) throws Exception {
//
//        if (!fromUser.isLogged()) throw new Exception("you are is not logged in");
//
//        fromUser.getFriends().add(toUser);
//        toUser.getFriends().add(fromUser);
//    }
//
//
    @Override
    public String login(String email, String pass) {
        String result = "wrong pass or email";
        //commit sql scripts for adding column also
        Users curUser = userDAO.get(email, pass);// user or null

        if (curUser != null) {
            userDAO.setLoginStatus(curUser, 1);
            result = "welcome";
        }
        return result;
    }

    //
    @Override
    public String logout(Users user) {
        String result = "Error";

        if (user != null) {
            userDAO.setLoginStatus(user, 0);
            result = "Successful logout";
        }
        return result;
    }

    @Override
    public Users checkIsLogin(Users user) {
        Users result = null;
        Integer a = userDAO.isLogin(user.getId());
        if (a == 1) result = user;
        return result;
    }

    @Override
    public String forProfile(Users user) {
        userDAO.isLogin(user.getId());

        return "localhost:8080/login";
    }

    @Override
    public Users getByUserName(String userName) {
        return userDAO.getByUserName(userName);
    }
}
