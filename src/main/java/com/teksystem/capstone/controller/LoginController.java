package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.dao.UserRoleDAO;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.database.entity.UserRole;
import com.teksystem.capstone.formbean.LoginFormBean;
import com.teksystem.capstone.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");

        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("login/register");
        //Safety lines for JSP page substitution error
        RegisterFormBean form = new RegisterFormBean();
        response.addObject("formBean", form);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User loggedInUser = userDao.findByEmail(currentPrincipalName);

        if ( loggedInUser == null ) {
            log.debug("Not logged in");
        } else {
            log.debug("User logged in " + loggedInUser);
        }
        return response;
    }

    // Instead of doing "(@RequestParam("email") String email)" for every variable we can just use Formbean for all variable (no need to repeat x num of times)
    // This method now becomes a create and an edit based on if the id is populated in the RegisterFormBean
    @RequestMapping(value = "/registerSubmit", method ={ RequestMethod.POST, RequestMethod.GET })
    public ModelAndView registerSubmit(@Valid RegisterFormBean formBean, BindingResult bindingResult) throws Exception{
        ModelAndView response = new ModelAndView();
        log.info(formBean.toString());
        if (bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            response.addObject("formBean", formBean);
            // add the error list to the model
            response.addObject("bindingResult", bindingResult);
            // because there is 1 or more error we do not want to process the logic below
            // that will create a new user in the database. We want to show the register.jsp
            response.setViewName("login/register");
            return response;
        }
        // Assume that we are trying to edit first, but if user is null go to next statement
        User user = userDao.findById(formBean.getId());
        // Used to create a new user, if the user loaded by the database is null
        if (user == null){
            user = new User();
        }
        log.info("We bout to set the data of a user");
        user.setEmail(formBean.getEmail());
        user.setFirstName(formBean.getFirstName());
        user.setLastName(formBean.getLastName());
        String password = passwordEncoder.encode(formBean.getPassword());
        user.setPassword(password);
        log.info(user.toString());
        // Saving to database
        userDao.save(user);
        // Creating userRole object so we can add data to userRole table
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");
        userRoleDao.save(userRole);
        log.info(formBean.toString());
        response.setViewName("redirect:/registerSuccess");
        return response;
    }
}