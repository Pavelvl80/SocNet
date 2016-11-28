package com.service;

import com.model.Messages;
import com.model.Users;

import java.util.List;

/**
 * Created by Edvard Piri on 23.11.2016.
 */
public interface MessagesService {
    Messages sendMessage(Messages message);

    int msgCount(long userId);

    Integer isLogged();

    Messages saveMessageService(Messages messages);

    List<Messages> getMessagesByUser(Users users);



}
