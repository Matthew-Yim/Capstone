package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.dao.UserRoleDAO;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.database.entity.UserRole;
import com.teksystem.capstone.formbean.LoginFormBean;
import com.teksystem.capstone.formbean.ProductFormBean;
import com.teksystem.capstone.formbean.RegisterFormBean;
import com.teksystem.capstone.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/user/cart", method = RequestMethod.GET)
    public ModelAndView cart() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/cart");
        return response;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/login");

        //Safety lines for JSP page substitution error
        LoginFormBean formBean = new LoginFormBean();
        response.addObject("formBean", formBean);
        return response;
    }

    @RequestMapping(value = "/user/loginSubmit", method ={ RequestMethod.POST, RequestMethod.GET })
    public ModelAndView loginSubmit(@Valid LoginFormBean formBean, BindingResult bindingResult) throws Exception{
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
            response.setViewName("user/login");
            return response;
        }
        response.setViewName("user/login");
        return response;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");
        //Safety lines for JSP page substitution error
        RegisterFormBean form = new RegisterFormBean();
        response.addObject("formBean", form);
        return response;
    }

    // Instead of doing "(@RequestParam("email") String email)" for every variable we can just use Formbean for all variable (no need to repeat x num of times)
   // This method now becomes a create and an edit based on if the id is populated in the RegisterFormBean
    @RequestMapping(value = "/user/registerSubmit", method ={ RequestMethod.POST, RequestMethod.GET })
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
            response.setViewName("user/register");
            return response;
        }
        // Assume that we are trying to edit first, but if user is null go to next statement
        User user = new User();
//        User user = userDao.findById(form.getId());
//        // Used to create a new user, if the user loaded by the database is null
//        if (user == null){
//            user = new User();
//        }
        log.info("We bout to set the data of a user");
        user.setEmail(formBean.getEmail());
        user.setFirstName(formBean.getFirstName());
        user.setLastName(formBean.getLastName());
        String password = passwordEncoder.encode(formBean.getPassword());
        user.setPassword(password);
        log.info(user.toString());
        // Saving to database
        userDao.save(user);
        // Creating userRole object so we can add  datato userRole table
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");
        userRoleDao.save(userRole);
        // Replaces "("email from form submission = " + email)"
        log.info(formBean.toString());
        // Redirecting user to edit page which will load the user from database
//        response.setViewName("user/edit");
        response.setViewName("user/register");
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
