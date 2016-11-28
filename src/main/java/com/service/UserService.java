package com.service;

import com.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Edvard Piri on 22.10.2016.
 */

@Repository
public interface UserService {
    Users save(Users user) throws Exception;

    String registerUser(Users user);

    String logout(Users user);
//
//    UserOld get(String name, String psw);
//
//    void setLogin(Users user);
//
//    List<UserOld> getAll();
//
    void cleanUsers();
//
//    void addToFriend(UserOld fromUser, UserOld toUser) throws Exception;
//
    String login(String userName, String password);
//
//    UserOld logout(UserOld user);
    List<Users> getUsers();

    String checkIsLogin();

    Long getUsersCount();

}
