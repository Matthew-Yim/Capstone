package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.dao.UserRoleDAO;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.database.entity.UserRole;
import com.teksystem.capstone.formbean.RegisterFormBean;
import com.teksystem.capstone.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class UserController {

    //same as doing a constructor less safe but cleaner
    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/home");

        return response;
    }

    // This method is for editing a user. There is a path parameter being used to pass the userid for the user that is to be edited
    // @GetMapping("/user/edit/{userId}") is equivalent to below
    @RequestMapping(value = "/user/edit/{userId}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDao.findById(userId);
        RegisterFormBean formBean = new RegisterFormBean();

        formBean.setId(user.getId());
        formBean.setEmail(formBean.getEmail());
        formBean.setFirstName(formBean.getFirstName());
        formBean.setLastName(formBean.getLastName());
        // form.setPassword(form.getPassword());

        response.addObject("formBean", formBean);
        log.info(formBean.toString()); // Replaces "("email from form submission = " + email)"
        return response;
    }
}
