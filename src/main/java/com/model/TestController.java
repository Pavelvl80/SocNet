package com.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Edvard Piri on 16.10.2016.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("test");

        modelAndView.addObject("name", "Rest");
        return modelAndView;
    }
}
