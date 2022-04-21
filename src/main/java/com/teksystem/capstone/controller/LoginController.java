package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.formbean.LoginFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/login");

        //Safety lines for JSP page substitution error
//        LoginFormBean formBean = new LoginFormBean();
//        log.info(formBean.toString());
//        response.addObject("formBean", formBean);

        return response;
    }

//    @RequestMapping(value = "/user/loginSubmit", method ={ RequestMethod.POST, RequestMethod.GET })
//    public ModelAndView loginSubmit(@Valid LoginFormBean formBean, BindingResult bindingResult) throws Exception{
//        ModelAndView response = new ModelAndView();
//        log.info(formBean.toString());
//        if (bindingResult.hasErrors()){
//            for(ObjectError error : bindingResult.getAllErrors()){
//                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
//            }
//            response.addObject("formBean", formBean);
//            // add the error list to the model
//            response.addObject("bindingResult", bindingResult);
//            // because there is 1 or more error we do not want to process the logic below
//            // that will create a new user in the database. We want to show the register.jsp
//            response.setViewName("user/login");
//            return response;
//        }
//        response.setViewName("user/login");
//        return response;
//    }
}
