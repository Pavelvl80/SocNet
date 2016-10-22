package com;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Edvard Piri on 22.10.2016.
 */

@Repository
public interface UserService {
    User save(User user) throws Exception;

    User get(String name, String psw);

    void setLogin(User user);

    List<User> getAll();

    void clean();

    void addToFriend(User fromUser, User toUser) throws Exception;

    User login(String userName, String password);

    User logout(User user);

}
