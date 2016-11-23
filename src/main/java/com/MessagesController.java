package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MessagesController {

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

       /* if (!fromUser.isLogged()) {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("error", "you are is not logged in");
            return modelAndView;
        }*/

        messageDAO.saveMessage(messages);

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

}