package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.dao.UserRoleDAO;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.database.entity.UserRole;
import com.teksystem.capstone.formbean.EditUserFormBean;
import com.teksystem.capstone.formbean.RegisterFormBean;
import com.teksystem.capstone.formbean.UserRoleFormBean;
import com.teksystem.capstone.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping(value = "/user/edit/{userId}")
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("login/register");

        User user = userDao.findById(userId);
        log.info(user.toString());
        EditUserFormBean form = new EditUserFormBean();
        UserRoleFormBean userRoleForm = new UserRoleFormBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        userRoleForm.setUserRole(userRoleForm.getUserRole());
        userRoleForm.setUserId(user.getId());
        // form.setPassword(form.getPassword());

        response.addObject("form", form);
        response.addObject("urForm", userRoleForm);
        log.info(form.toString()); // Replaces "("email from form submission = " + email)"
        return response;
    }

    @RequestMapping(value="/searchUser", method= RequestMethod.GET )
    public ModelAndView search(@RequestParam(value = "userName", required = false) String userName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("search/searchUser");

        List<User> users = new ArrayList<>();

        // very basic example of error checking
        if (!StringUtils.isEmpty(userName)) {
            users = userDao.findByFirstNameIgnoreCaseContaining(userName);
        }

        // this line puts the list of users that we just queried into the model
        response.addObject("usersModelKey", users);
        response.addObject("userName", userName);

        return response;
    }
}
