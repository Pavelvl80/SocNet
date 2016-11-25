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
        //user isLogged true should be added to DB column
        //isLogged column should be added to db as well
        String result = "wrong pass or email";
        Users curUser = userDAO.get(email, pass);

        if (curUser != null) {
            userDAO.setLogin(curUser);
            result = "welcome";
        }
        return result;

    }

    //
    @Override
    public String logout(Users user) {
        String result = "Error";
        Users finUser = userDAO.getByUser();
        if (finUser != null) {
            userDAO.logout(finUser);
            result = "Successful logout";
        }
        return result;
    }

    @Override
    public String checkIsLogin() {
        String result = "yes";
        if (userDAO.isLogin() == null || userDAO.isLogin() == 0) result = "no";
        return result;
    }


}
