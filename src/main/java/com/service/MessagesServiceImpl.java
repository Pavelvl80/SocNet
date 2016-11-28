package com.service;

import com.model.Messages;
import com.dao.MessageDAO;
import com.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}