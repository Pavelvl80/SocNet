package com.dao;

import com.model.Users;

import java.util.List;

public interface UserDAO {
    Users saveUser(Users user);

    Users get(String email, String psw);

    Users getByEmailOrUserName(String email, String userName);

    void setLoginStatus(Users user, int i);

    List<Users> getAll();

//    Users delete(UserOld user);

//    void logout(Users user);

    void clean();

    //    Users update(UserOld user);
    Users getByUser();

    Integer isLogin();

    Long getCount();


}