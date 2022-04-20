package com.teksystem.capstone.service;

import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

//    public User getCurrentlyLoggedInCustomer()
    // if you have some more complex logic then you can move it into
    // this class and run it from the controller

}
