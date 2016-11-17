package com;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Edvard Piri on 22.10.2016.
 */

@Repository
public interface UserService {
    Users save(Users user) throws Exception;
//
//    UserAll get(String name, String psw);
//
//    void setLogin(UserAll user);
//
//    List<UserAll> getAll();
//
//    void clean();
//
//    void addToFriend(UserAll fromUser, UserAll toUser) throws Exception;
//
//    UserAll login(String userName, String password);
//
//    UserAll logout(UserAll user);

}
