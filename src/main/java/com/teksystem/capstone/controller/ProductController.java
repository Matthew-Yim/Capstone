package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.OrderDAO;
import com.teksystem.capstone.database.dao.OrderProductDAO;
import com.teksystem.capstone.database.dao.ProductDAO;
import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.entity.Order;
import com.teksystem.capstone.database.entity.OrderProduct;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.formbean.EditProductFormBean;
import com.teksystem.capstone.formbean.LoginFormBean;
import com.teksystem.capstone.formbean.ProductFormBean;
import com.teksystem.capstone.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Path;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private OrderProductDAO orderProductDao;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView product() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/product");
        //Safety lines for JSP page substitution error
        ProductFormBean form = new ProductFormBean();
        response.addObject("formBean", form);
        return response;
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public ModelAndView showAll() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/showAll");

        List<Product> productsKey = productDao.findAll();

        response.addObject("productsKey", productsKey);
        return response;
    }



    @RequestMapping(value = "/product/productSubmit", method ={ RequestMethod.POST, RequestMethod.GET })
    public ModelAndView submit(@Valid EditProductFormBean formBean, BindingResult bindingResult) throws Exception{
        ModelAndView response = new ModelAndView();

        log.info(formBean.toString());
        if(bindingResult.hasErrors()){
            for(FieldError error : bindingResult.getFieldErrors()){
                log.info(error.toString());
            }
            response.addObject("bindingResult", bindingResult);
            response.addObject("formBean", formBean);
        }
        else{
            //need if statement for when we want to edit
            Product product = productDao.findById(formBean.getId());
            if(product == null){
                product = new Product();
            }
            product.setName(formBean.getName());
            product.setDescription(formBean.getDescription());
            product.setPrice(formBean.getPrice());
            product.setCategory(formBean.getCategory());
            product.setImageUrl(formBean.getImageUrl());
            productDao.save(product);
        }
        response.setViewName("user/product");
        return response;
    }

    @RequestMapping(value = "/product/delete/{productId}", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable("productId") Integer productId) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/product");
        Product product = productDao.findById(productId);
        log.info("We finna delete Product: " + product.getName());
        if(product == null){
            String error = "You Dunn messed up";
            response.addObject("error", error);
        }
        else{
            productDao.delete(product);
        }
        return response;
    }

    @RequestMapping(value="/search", method= RequestMethod.GET )
    public ModelAndView search(@RequestParam(value = "productName", required = false) String productName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        List<Product> products = new ArrayList<>();

        // very basic example of error checking
        if (!StringUtils.isEmpty(productName)) {
            products = productDao.findByNameIgnoreCaseContaining(productName);
        }

        // this line puts the list of users that we just queried into the model
        // the model is a map ( key value store )
        // any object of any kind can go into the model using this key value
        // in this case it is a list of Users
        response.addObject("productsModelKey", products);
        response.addObject("productName", productName);

        return response;
    }

    @RequestMapping("/product/edit/{productId}")
    public ModelAndView editProduct(@PathVariable("productId") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/product");

        Product product = productDao.findById(productId);
        ProductFormBean form = new ProductFormBean();

        form.setId(product.getId());
        form.setName(product.getName());
        form.setDescription(product.getDescription());
        form.setPrice(product.getPrice());
        form.setImageUrl(product.getImageUrl());
        form.setCategory(product.getCategory());

        // in this case we are adding the RegisterFormBean to the model
        response.addObject("form", form);

        return response;
    }
}
