package com;

import java.util.List;

public interface UserDAO  {
    Users save(User user);

//    Users get(String name, String psw);

//    void setLogin(User user);

    List<Users> getAll();

//    Users delete(User user);

//    Users makeInactive(User user);

//    void clean();

//    Users update(User user);
}