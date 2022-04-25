package com.teksystem.capstone.controller;

import com.teksystem.capstone.formbean.ProductFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class DrinkController {

    @RequestMapping(value = "/freshBlenders", method = RequestMethod.GET)
    public ModelAndView freshBlenders() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("drinks/freshBlenders");
        //Safety lines for JSP page substitution error
        ProductFormBean form = new ProductFormBean();
        response.addObject("formBean", form);
        return response;
    }

    @RequestMapping(value = "/hypnoticMixers", method = RequestMethod.GET)
    public ModelAndView hypnoticMixers() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("drinks/hypnoticMixers");
        //Safety lines for JSP page substitution error
        ProductFormBean form = new ProductFormBean();
        response.addObject("formBean", form);
        return response;
    }

    @RequestMapping(value = "/icySnows", method = RequestMethod.GET)
    public ModelAndView icySnows() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("drinks/icySnows");
        //Safety lines for JSP page substitution error
        ProductFormBean form = new ProductFormBean();
        response.addObject("formBean", form);
        return response;
    }

    @RequestMapping(value = "/tranquilTeas", method = RequestMethod.GET)
    public ModelAndView tranquilTeas() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("drinks/tranquilTeas");
        //Safety lines for JSP page substitution error
        ProductFormBean form = new ProductFormBean();
        response.addObject("formBean", form);
        return response;
    }
}
