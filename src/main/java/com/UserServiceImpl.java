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
        return userDAO.save(user);
    }

    @Override
    public String registerUser(Users user) {
        Users users = userDAO.getByEmailOrUserName(user.getEmail(), user.getUserName());

        if (users != null)
            return "User with this email or name is registered";

        userDAO.save(user);
        return "registered";
    }

    @Override
    public List<Users> getUsers() {
        return userDAO.getAll();
    }

    //
//    @Override
//    public UserAll get(String name, String psw) {
//        return userDAO.get(name, psw);
//    }
//
//    @Override
//    public void setLogin(UserAll user) {
//        userDAO.setLogin(user);
//    }
//
//    @Override
//    public List<UserAll> getAll() {
//        return userDAO.getAll();
//    }
//
    @Override
    public void clean() {
        userDAO.clean();
    }
//
//    @Override
//    public void addToFriend(UserAll fromUser, UserAll toUser) throws Exception {
//
//        if (!fromUser.isLogged()) throw new Exception("you are is not logged in");
//
//        fromUser.getFriends().add(toUser);
//        toUser.getFriends().add(fromUser);
//    }
//
//
//    @Override
//    public UserAll login(String userName, String password) {
//        UserAll curUser = userDAO.get(userName, password);
//        if (curUser != null) {
//            curUser.setLogged(true);
//            userDAO.update(curUser);
//        }
//        return curUser;
//
//    }
//
//    @Override
//    public UserAll logout(UserAll user) {
//        user.setLogged(false);
//        userDAO.update(user);
//        return user;
//    }
}
