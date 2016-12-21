package com.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TestController {

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
        ModelAndView modelAndView = new ModelAndView("displayTestPost.vm");
        return modelAndView;
    }

    @RequestMapping(value = "/display_test", method = RequestMethod.GET)
    public ModelAndView  displayTest(@RequestParam String email, @RequestParam String name, @RequestParam String pass) {
        String result = "{'email' : '" + email + "', 'name' : '" + name + "', 'pass' : '" + pass + "'};";
        ModelAndView modelAndView = new ModelAndView("displayTestPost.vm");
        modelAndView.addObject("result", result);
        return modelAndView;
    }


    private boolean validateEmail(String email) {
        return email.contains("@") && email.contains("mail");
    }
}
