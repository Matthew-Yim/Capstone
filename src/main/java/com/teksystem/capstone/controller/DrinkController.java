package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.ProductDAO;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.formbean.ProductFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class DrinkController {

    @Autowired
    ProductDAO productDao;

    @RequestMapping(value = "/freshBlenders", method = RequestMethod.GET)
    public ModelAndView freshBlenders() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("drinks/freshBlenders");
        List<Product> freshBlenders = productDao.findByCategory("Fresh Blenders");
        response.addObject("freshBlenders",freshBlenders);
        log.info("freshBlenders available");
        return response;
    }

    @RequestMapping(value = "/hypnoticMixers", method = RequestMethod.GET)
    public ModelAndView hypnoticMixers() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("drinks/hypnoticMixers");
        List<Product> hypnoticMixers = productDao.findByCategory("Hypnotic Mixers");
        response.addObject("hypnoticMixers",hypnoticMixers);
        log.info("hypnoticMixers available");
        return response;
    }

    @RequestMapping(value = "/icySnows", method = RequestMethod.GET)
    public ModelAndView icySnows() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("drinks/icySnows");
        List<Product> icySnows = productDao.findByCategory("Icy Snows");
        response.addObject("icySnows",icySnows);
        log.info("icySnows available");
        return response;
    }

    @RequestMapping(value = "/tranquilTeas", method = RequestMethod.GET)
    public ModelAndView tranquilTeas() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("drinks/tranquilTeas");
        List<Product> tranquilTeas = productDao.findByCategory("Tranquil Teas");
        response.addObject("tranquilTeas",tranquilTeas);
        log.info("tranquilTeas available");
        return response;
    }
}
