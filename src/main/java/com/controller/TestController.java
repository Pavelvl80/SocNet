package com.controller;

import com.dao.UserDAO;
import com.google.gson.Gson;
import com.model.Users;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("index.vm");
        return modelAndView;
    }

//    @RequestMapping(value = "/text_ajax")
//    public String processAjax(@RequestParam String email, @RequestParam String name) {
//
//        String response;
//        if (validateEmail(email))
//            response = "{\"response\" : \"success\"}";
//        else
//            response = "{\"response\" : \"failed\"}";
//        return response;
//    }

    @RequestMapping(value = "/test_ajax")
    public ResponseEntity<String> processAjax(@RequestParam String email, @RequestParam String name) {
        ResponseEntity<String> response;
        if (validateEmail(email))
            response = new ResponseEntity<String>(HttpStatus.OK);
        else response = new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);

        return response;
    }

    @RequestMapping(value = "/testLoginRequest")
    public ModelAndView testLoginRequest() {
        ModelAndView modelAndView = new ModelAndView("loginRequestPost.vm");
        return modelAndView;
    }


    @RequestMapping(value = "/displayTest")
    public ModelAndView displayTest() {
        ModelAndView modelAndView = new ModelAndView("displayTest.vm");
        return modelAndView;
    }

    @RequestMapping(value = "/display_test", method = RequestMethod.GET)
    public ResponseEntity<String> displayTest(@RequestParam String email, @RequestParam String name, @RequestParam String pass) {
        String result = "{\"email\" : \"" + email + "\", \"name\" : \"" + name + "\", \"pass\" : \"" + pass + "\"};";
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/checkEquals")
    public ModelAndView checkEquals() {
        return new ModelAndView("/new.vm");
    }

    @RequestMapping(value = "/checkEqualsRequest")
    public ResponseEntity<String> checkEquals(@RequestParam String first, @RequestParam String second) {
        ResponseEntity response;
        if (first.equals(second)) response = new ResponseEntity(HttpStatus.OK);
        else response = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        return response;
    }

    @RequestMapping(value = "/testUserCount")
    public ModelAndView testUserCont() {
        return new ModelAndView("testUserCount.vm");
    }

    @RequestMapping(value = "/testUserCountRequest")
    public ResponseEntity<String> stringResponseEntity(@RequestParam Integer numb) {
        List<Users> users = userDAO.getNumbUsers(numb);
        String json = new Gson().toJson(users);
        return new ResponseEntity(json, HttpStatus.OK);
    }

    @RequestMapping(value = "/sendMessage")
    ModelAndView sendMessage() {
        return new ModelAndView("sendmessage.vm");
    }

    @RequestMapping(value = "/getMessages")
    ModelAndView getMessages() {
        return new ModelAndView("watchmessages.vm");
    }

    private boolean validateEmail(String email) {
        return email.contains("@") && email.contains("mail");
    }
}
