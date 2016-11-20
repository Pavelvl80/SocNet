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
//    @RequestMapping("/logout")
//    ModelAndView logout(UserAll user) {
//        userService.logout(user);
//        return new ModelAndView("home");
//    }
//
    @RequestMapping("/register")
    ModelAndView register() throws Exception {
        Users user = new Users("mai@l.com", "12345", "admin", "Lotar");

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
//        List<UserAll> userList = userService.getAll();
//
//        UserAll fromUser = userList.get(0);
//        UserAll toUser = userList.get(1);
//
//        fromUser.getFriends().add(toUser);
//        toUser.getFriends().add(fromUser);
//    }
//
    @RequestMapping("/clean")
    ModelAndView clean() {
        userService.clean();
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