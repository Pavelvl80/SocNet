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
////    UserAll login(String name, String password) throws Exception {
////        UserAll curUser = userDAO.get(name, password);
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
//        UserAll curUser = userService.get(name, password);
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
//    ModelAndView logout(UserAll user) {
//        userService.logout(user);
//        return new ModelAndView("home");
//    }
//
    @RequestMapping("/register")
    ModelAndView register() throws Exception {
        Users user = new Users("mai@l.com", "12345", "admin");

        Users savedUser = userService.save(user);

        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("user", savedUser);
        modelAndView.addObject("state", "register");

        return modelAndView;
    }

    @RequestMapping("/profile")
    ModelAndView profile() throws Exception {
        List<Users> userProfile = userDAO.getByUser();
        Users user = userProfile.get(0);

        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
//
//    void addToFriend() throws Exception {
//        List<UserAll> userList = userService.getAll();
//
//        UserAll fromUser = userList.get(0);
//        UserAll toUser = userList.get(1);
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
//    Map<UserAll, List<Message>> getMessageByUsers(List<UserAll> users) {
//       //TODO make implemetation
//        //задание: разделить сообщения по юзерам (fromUser)
//        Map<UserAll, List<Message>> messages = new HashMap<>();
//        List<Message> allMessages = messageDAO.getAll();
//        allMessages.forEach(message -> messages.put(message.getFromUser(), null));
//
//        for (Map.Entry<UserAll, List<Message>> entry : messages.entrySet()) {
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