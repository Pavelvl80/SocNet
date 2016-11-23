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
    @Autowired
    private UserService userService;

    //
//    //    db connection emulator
//    private MessageDAO messageDAO = new MessageDAOImpl();
//
////    UserOld login(String name, String password) throws Exception {
////        UserOld curUser = userDAO.get(name, password);
////
////        if (curUser == null)
////            throw new Exception("wrong username or password");
////
////        userDAO.setLogin(curUser);
////
////        return curUser;
////    }

    @RequestMapping("/isLogin")
    ModelAndView isLogin() {
        String msg = userService.checkIsLogin();
        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("text", msg);
        return modelAndView;
    }

    @RequestMapping("/login")
    ModelAndView login() throws Exception {
        String email = "victor@mail.com";
        String password = "12345";

        String result = userService.login(email, password);

        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("result", result);
        modelAndView.addObject("state", "logged in");
        return modelAndView;
    }

    //
    @RequestMapping("/users")
    ModelAndView getUsers() {
        List<Users> users = userService.getUsers();

        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping("/countUsers")
    ModelAndView countUsers() {
        List<Users> users = userService.getUsers();

        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users.size());
        return modelAndView;
    }

    //
    @RequestMapping("/logout")
    ModelAndView logout() {
        Users user = new Users("victor@mail.com", "12345", "admin", "Victor");

        userService.logout(user);
        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("text", "logout complete");
        return modelAndView;
    }

    //
    @RequestMapping("/register")
    ModelAndView register() throws Exception {
        Users user = new Users("victor@mail.com", "12345", "admin", "Victor");

        String savedUser = userService.registerUser(user);

        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("user", user);
        modelAndView.addObject("result", savedUser);
        modelAndView.addObject("state", "register");

        return modelAndView;
    }

    @RequestMapping("/profile")
    ModelAndView profile() throws Exception {
        Users userProfile = userDAO.getByUser();

        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("user", userProfile);

        return modelAndView;
    }

    //
//    void addToFriend() throws Exception {
//        List<UserOld> userList = userService.getAll();
//
//        UserOld fromUser = userList.get(0);
//        UserOld toUser = userList.get(1);
//
//        fromUser.getFriends().add(toUser);
//        toUser.getFriends().add(fromUser);
//    }
//
    @RequestMapping("/cleanUsers")
    ModelAndView clean() {
        userService.cleanUsers();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.getUsers().size());
        return modelAndView;
    }
//
//
//    //getUserMessages - size - count messages
//    //getMessages()
//
//
////    List<Messages> getMessages(long userId) {
////        //if (!fromUser.isLogged()) throw new Exception("you are is not logged in");
////        return messageDAO.getByUserId(userId);
////    }
//
//
//    Map<UserOld, List<Messages>> getMessageByUsers(List<UserOld> users) {
//       //TODO make implemetation
//        //задание: разделить сообщения по юзерам (fromUser)
//        Map<UserOld, List<Messages>> messages = new HashMap<>();
//        List<Messages> allMessages = messageDAO.getAll();
//        allMessages.forEach(message -> messages.put(message.getFromUser(), null));
//
//        for (Map.Entry<UserOld, List<Messages>> entry : messages.entrySet()) {
//            ArrayList<Messages> timeList = new ArrayList<>();
//            for (Messages message : allMessages) {
//                if (message.getFromUser().equals(entry.getKey())) timeList.add(message);
//            }
//            entry.setValue(timeList);
//        }
//        return messages;
//    }
//
//    List<Messages> outboxMessages(long userId) {
//        //TODO make implemetation
//        List<Messages> allMessages = messageDAO.getByUserId(userId);
//        List<Messages> outBoxMessages = new ArrayList<>();
//
//        allMessages.forEach(message -> {
//            if (message.getMessageType() != null && message.getMessageType().equals(MessageType.OUT))
//                outBoxMessages.add(message);
//        });
//
//        return outBoxMessages;
//    }
//
//    List<Messages> inboxMessages(long userId) {
//        //TODO make implemetation
//        List<Messages> allMessages = messageDAO.getByUserId(userId);
//        List<Messages> inBoxMessages = new ArrayList<>();
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