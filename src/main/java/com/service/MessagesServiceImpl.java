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

    @Override
    public List<Messages> getMessagesByUser(Long id) {
        return messageDAO.getByUserId(id);
    }

    @Override
    public Messages saveMessageService(Messages messages) {
        return messageDAO.saveMessage(messages);
    }

    @Override
    public Messages deleteMessage(Messages message) {
        return messageDAO.changeActiveStatus(message, 0);
    }

    @Override
    public String saveMessageIfLogin(Messages messages) {
        String result = "error";
        if (messages.getFromUser().getIsLogin() == 1) {
            messageDAO.saveMessage(messages);
            result = "sent";
        }
        return result;
    }

    @Override
    public List<Messages> getLastNumbMessagesByUserId(Long id) {
        return messageDAO.getTenLastMessagesByUserId(id);
    }
}