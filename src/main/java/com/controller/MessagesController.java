package com.controller;


import com.google.gson.Gson;
import com.model.Messages;
import com.model.Users;
import com.dao.MessageDAO;
import com.dao.UserDAO;
import com.service.MessagesService;
import com.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private UserService userService;

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
        modelAndView.addObject("userName", user.getUserName() + "'s messages:");
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

    @RequestMapping("/sendMessageIfLogin")
    ModelAndView sendMessageIfLogin() {
        List<Users> userList = userDAO.getAll();
        Users fromUser = userList.get(0);
        Users toUser = userList.get(1);
        Messages messages = new Messages("первое!! тест", fromUser, toUser);

        String result = messagesService.saveMessageIfLogin(messages);

        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

//    @RequestMapping("/sendMessageToFriend")
//    ModelAndView sendMessageToFriend() {
//        List<Users> userList = userDAO.getAll();
//        Users fromUser = userList.get(0);
//    }

    @RequestMapping("/lastMessages")
    public ModelAndView lastMessages() {
        List<Messages> messages = messagesService.getLastNumbMessagesByUserId(1025l);

        ModelAndView modelAndView = new ModelAndView("messagesList");
        modelAndView.addObject("messages", messages);

        return modelAndView;
    }

    @RequestMapping("/messagesByDate")
    public ModelAndView messagesByDate() throws Exception {
        Long id = 1025l;
        List<Messages> messages = messagesService.getMessagesByUserIdAndDate(id, "07/12/2016");


        ModelAndView modelAndView = new ModelAndView("messagesList");
        modelAndView.addObject("userName", "from " + id);
        modelAndView.addObject("messages", messages);

        return modelAndView;
    }

    @RequestMapping("/send_message")
    ResponseEntity<String> sendMessage(@RequestParam("usernamefrom") String userNameFrom,
                                       @RequestParam("usernameto") String userNameTo, @RequestParam String message) {
        //check users - if not exist 404
        //create message
        //send message
        Users userFrom = userService.getByUserName(userNameFrom);
        Users userTo = userService.getByUserName(userNameTo);
        if (userService.getByUserName(userNameFrom) == null || userService.getByUserName(userNameTo) == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Messages messagesObj = new Messages(message, userFrom, userTo);
        if (messagesService.saveMessage(messagesObj) == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping("/get_messages")
    ResponseEntity<String> getMessages(@RequestParam("username") String userName, @RequestParam String email) {
        Users user = userDAO.getByEmailOrUserName(email, userName);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        String users = new Gson().toJson(messageDAO.getByUserId(user.getId()));

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}