package com.controller;


import com.service.UserService;
import com.model.Users;
import com.dao.UserDAO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
public class UserController extends HttpServlet {


    @Autowired
    private UserDAO userDAO;

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
        Users user = userService.getUsers().get(0);
        Users msg = userService.checkIsLogin(user);
        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("result", msg);
        return modelAndView;
    }

    @RequestMapping("/login")
    ModelAndView login() throws Exception {
        String email = "nameless@gmail.com";
        String password = "12345";

        String result = userService.login(email, password);

        ModelAndView modelAndView = new ModelAndView("text");
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
        Long usersCount = userService.getUsersCount();

        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("result", usersCount);
        return modelAndView;
    }

    //
    @RequestMapping("/logout")
    ModelAndView logout() {
        Users user = userService.getUsers().get(0);

        String result = userService.logout(user);
        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    //
    @RequestMapping(value = "/register")
    ModelAndView register() {
        Users user = new Users("nameless@gmail.com", "12345", "admin", "Nameless");

        String savedUser = userService.registerUser(user);

        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("user", user);
        modelAndView.addObject("result", savedUser);
        modelAndView.addObject("state", "register");

        return modelAndView;
    }

    @RequestMapping("/profile")
    Object profile() {
        Users user = userService.getUsers().get(0);
        Users users = userService.checkIsLogin(user);

        if (users == null) return "redirect:/login";

        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("user", users);
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
        ModelAndView modelAndView = new ModelAndView("text");
        modelAndView.addObject("result", userService.getUsersCount());
        return modelAndView;
    }

    @RequestMapping(value = "/login_request")
    ResponseEntity<String> loginRequest(@RequestParam String email, @RequestParam String name) {
        ResponseEntity<String> response;
        if (validateEmail(email) && validateUserName(name))
            response = new ResponseEntity<String>(HttpStatus.OK);
        else response = new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
        return response;
    }

    private boolean validateEmail(String email) {
        return email.contains("@") && email.contains("mail");
    }

    private boolean validateUserName(String name) {
        return name != null && name.length() < 10;
    }
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