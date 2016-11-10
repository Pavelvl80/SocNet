package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
public class UserController {
    @Autowired
    UserDAO userDAO;

//
//    @Autowired
//    private UserService userService;
//
//    //    db connection emulator
//    private MessageDAO messageDAO = new MessageDAOImpl();
//
////    User login(String name, String password) throws Exception {
////        User curUser = userDAO.get(name, password);
////
////        if (curUser == null)
////            throw new Exception("wrong username or password");
////
////        userDAO.setLogin(curUser);
////
////        return curUser;
////    }
//
//    @RequestMapping("/login")
//    ModelAndView login() throws Exception {
//        String name = "denis";
//        String password = "111";
//
//        User curUser = userService.get(name, password);
//        userService.setLogin(curUser);
//
//        ModelAndView modelAndView = new ModelAndView("welcome");
//        if (curUser == null)
//            modelAndView = new ModelAndView("error");
//        else modelAndView = new ModelAndView("welcome");
//        modelAndView.addObject("user", curUser);
//        modelAndView.addObject("state", "logged in");
//        return modelAndView;
//    }
//
    @RequestMapping("/users")
    ModelAndView getUsers() {
        List<Users> users = userDAO.getAll();

        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
//
//    @RequestMapping("/logout")
//    ModelAndView logout(User user) {
//        userService.logout(user);
//        return new ModelAndView("home");
//    }
//
//    @RequestMapping("/register")
//    ModelAndView register() throws Exception {
//        User user = new User(1001, "Roman", Gender.MALE, "123", "Kiev");
//
//        User savedUser = userService.save(user);
//
//        ModelAndView modelAndView = new ModelAndView("welcome");
//        modelAndView.addObject("user", savedUser);
//        modelAndView.addObject("state", "register");
//
//        return modelAndView;
//    }
//
//    void addToFriend() throws Exception {
//        List<User> userList = userService.getAll();
//
//        User fromUser = userList.get(0);
//        User toUser = userList.get(1);
//
//        fromUser.getFriends().add(toUser);
//        toUser.getFriends().add(fromUser);
//    }
//
//    @RequestMapping("/clean")
//    ModelAndView clean() {
//        userService.clean();
//        ModelAndView modelAndView = new ModelAndView("users");
//        modelAndView.addObject("users", userService.getAll());
//        return modelAndView;
//    }
//
//
//    //getUserMessages - size - count messages
//    //getMessages()
//
//
////    List<Message> getMessages(long userId) {
////        //if (!fromUser.isLogged()) throw new Exception("you are is not logged in");
////        return messageDAO.getByUserId(userId);
////    }
//
//
//    Map<User, List<Message>> getMessageByUsers(List<User> users) {
//        //TODO make implemetation
//        //задание: разделить сообщения по юзерам (fromUser)
//        Map<User, List<Message>> messages = new HashMap<>();
//        List<Message> allMessages = messageDAO.getAll();
//        allMessages.forEach(message -> messages.put(message.getFromUser(), null));
//
//        for (Map.Entry<User, List<Message>> entry : messages.entrySet()) {
//            ArrayList<Message> timeList = new ArrayList<>();
//            for (Message message : allMessages) {
//                if (message.getFromUser().equals(entry.getKey())) timeList.add(message);
//            }
//            entry.setValue(timeList);
//        }
//        return messages;
//    }
//
//    List<Message> outboxMessages(long userId) {
//        //TODO make implemetation
//        List<Message> allMessages = messageDAO.getByUserId(userId);
//        List<Message> outBoxMessages = new ArrayList<>();
//
//        allMessages.forEach(message -> {
//            if (message.getMessageType() != null && message.getMessageType().equals(MessageType.OUT))
//                outBoxMessages.add(message);
//        });
//
//        return outBoxMessages;
//    }
//
//    List<Message> inboxMessages(long userId) {
//        //TODO make implemetation
//        List<Message> allMessages = messageDAO.getByUserId(userId);
//        List<Message> inBoxMessages = new ArrayList<>();
//
//        allMessages.forEach(message -> {
//            if (message.getMessageType() != null && message.getMessageType().equals(MessageType.IN))
//                inBoxMessages.add(message);
//        });
//        return inBoxMessages;
//    }
//
//
//    //inclass
//    //TODO inboxMessages/outboxMessages for time period

}