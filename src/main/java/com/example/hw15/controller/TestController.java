package com.example.hw15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView getTest() {
        ModelAndView result = new ModelAndView("notes/test");
        return result;
    }
}
