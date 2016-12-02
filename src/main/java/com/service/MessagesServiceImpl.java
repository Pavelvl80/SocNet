package com.service;

import com.model.Messages;
import com.dao.MessageDAO;
import com.dao.UserDAO;
import com.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessageDAO messageDAO;

    @Autowired
    UserDAO userDAO;


    @Override
    public Messages sendMessage(Messages message) {
        return messageDAO.saveMessage(message);
    }

    @Override
    public int msgCount(long userId) {
        return messageDAO.getByUserId(userId).size();
    }

    @Override
    public Integer isLogged() {
        return null;
    }

    //TODO you don't need to use all USERS object, just id is enough
    @Override
    public List<Messages> getMessagesByUser(Users user) {
        return messageDAO.getByUserId(user.getId());
    }

    @Override
    public Messages saveMessageService(Messages messages) {
        return messageDAO.saveMessage(messages);
    }
}