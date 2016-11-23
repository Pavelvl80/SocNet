package com;

import java.util.List;

public interface UserDAO {
    Users saveUser(Users user);

    Users get(String email, String psw);

    Users getByEmailOrUserName(String email, String userName);

    void setLogin(Users user);

    List<Users> getAll();

//    Users delete(UserOld user);

    void logout(Users user);

    void clean();

    //    Users update(UserOld user);
    Users getByUser();

    Integer isLogin();


}