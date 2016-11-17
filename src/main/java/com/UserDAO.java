package com;

import java.util.List;

public interface UserDAO  {
    Users save(Users user);

//    Users get(String name, String psw);

//    void setLogin(UserAll user);

    List<Users> getAll();

//    Users delete(UserAll user);

//    Users makeInactive(UserAll user);

//    void clean();

//    Users update(UserAll user);
    List<Users> getByUser();
}