package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MessagesController {
    private UserDAO userDAO = new UserDAOImpl();

    private MessageDAO messageDAO = new MessageDAOImpl();

    long id = 101;


    @RequestMapping("/sendMessage")
    ModelAndView sendMessage(/*User fromUser, User toUser, String msg*/) throws Exception {
//        if (!fromUser.isLogged()) throw new Exception("you are is not logged in");

//        Message message = new Message(id, msg, fromUser, toUser);
        ModelAndView modelAndView = new ModelAndView("sent");

        User fromUser = userDAO.get("Roman", "123");
        User toUser = userDAO.get("Roman", "123");

        Message message = new Message(id, "TEST", fromUser, toUser);

        message.setMessageType(MessageType.OUT);

        messageDAO.save(message);

        fromUser.getMessages().add(message);
        toUser.getMessages().add(message);
        id++;

        return modelAndView;
    }

    //getMessages

    @RequestMapping("/getUserMessages")
    ModelAndView getUserMessages() {
        User user = userDAO.get("Roman", "123");
        ModelAndView modelAndView = new ModelAndView("message");
        user.getMessages();
        modelAndView.addObject("user", user);
        modelAndView.addObject("numb", "all messages");
        return modelAndView;
    }

    @RequestMapping("/getFirstUserMessage")
    ModelAndView getFirstUserMessage() {
        User user = userDAO.get("Roman", "123");
        ModelAndView modelAndView = new ModelAndView("message");
        user.getMessages().get(0);
        modelAndView.addObject("user", user);
        modelAndView.addObject("numb", "first message");
        return modelAndView;
    }
}