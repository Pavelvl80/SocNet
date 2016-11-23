package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessageDAO messageDAO;


    @Override
    public Messages sendMessage(Messages message) {
        return messageDAO.saveMessage(message);
    }

    @Override
    public int msgCount(long userId) {
        return messageDAO.getByUserId(userId).size();
    }
}