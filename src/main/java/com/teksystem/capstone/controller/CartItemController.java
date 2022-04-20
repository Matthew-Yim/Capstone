package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class CartItemController {
    @Autowired
    private CartService cartService;

    @Autowired
    private User user;

    @RequestMapping(value = "/user/cart", method = RequestMethod.GET)
    public ModelAndView home() throws Exception{
        ModelAndView response = new ModelAndView();

//        User user = userService.get
        response.setViewName("user/home");

        return response;
    }
}
