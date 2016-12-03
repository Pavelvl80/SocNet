package com.controller;


import com.model.Messages;
import com.model.Users;
import com.dao.MessageDAO;
import com.dao.UserDAO;
import com.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private UserDAO userDAO;


    @RequestMapping("/sendMessage")
    ModelAndView sendMessage() {
        List<Users> userList = userDAO.getAll();
        Users fromUser = userList.get(0);
        Users toUser = userList.get(1);
        Messages messages = new Messages("Привет!! тест", fromUser, toUser);

        messagesService.saveMessageService(messages);

        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("text", "messages was sent");
        return modelAndView;
    }

   /* @RequestMapping("/messagesCount")
    ModelAndView getMessages() {
        User user = new User(1001a, "Roman", Gender.MALE, "123", "Kiev");
        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("text", messageDAO.msgCount(user.getId()));
        return modelAndView;
    }*/

    @RequestMapping("/inbox")
    ModelAndView inbox(/*Users user*/) {
        Users user = userDAO.getAll().get(0);
        List<Messages> messages = messagesService.getMessagesByUser(user.getId());

        ModelAndView modelAndView = new ModelAndView("messagesList");
        modelAndView.addObject("messages", messages);
        modelAndView.addObject("userName", user.getUserName());
        return modelAndView;
    }

    @RequestMapping("/deleteMessage")
    ModelAndView deleteMessage(/*Long id*/) {
        Messages messageFromDB = messageDAO.getByUserId(1025l).get(0);

        Messages message = messagesService.deleteMessage(messageFromDB);

        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("message", message);

        return modelAndView;
    }

}