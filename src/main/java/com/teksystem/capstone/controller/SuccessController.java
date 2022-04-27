package com.teksystem.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SuccessController {

    @RequestMapping(value = "/productSuccess", method = RequestMethod.GET)
    public ModelAndView productSuccess() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("success/productSuccess");
        return response;
    }

    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public ModelAndView loginSuccess() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("success/loginSuccess");
        return response;
    }

    @RequestMapping(value = "/registerSuccess", method = RequestMethod.GET)
    public ModelAndView registerSuccess() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("success/registerSuccess");
        return response;
    }
}
