package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.OrderDAO;
import com.teksystem.capstone.database.dao.OrderProductDAO;
import com.teksystem.capstone.database.dao.ProductDAO;
import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.entity.Order;
import com.teksystem.capstone.database.entity.OrderProduct;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.formbean.LoginFormBean;
import com.teksystem.capstone.formbean.ProductFormBean;
import com.teksystem.capstone.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Path;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
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

    @RequestMapping(value = "/AddCart/{order_products}", method = RequestMethod.GET)
    public ModelAndView addCart(@PathVariable("order_products") Integer orderProductsId) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/cart");
        Product product = productDao.findById(orderProductsId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDao.findByEmail(username);
        Order order = orderDao.findOrderByUserIdAndStatus(user.getId(), "pending");
        if (order == null){
            order = new Order();
            order.setStatus("pending");
            // We gunna save this to the cart(OrderProduct table)
            OrderProduct cart = new OrderProduct();
            cart.setOrder(order);
            cart.setProduct(product);
            cart.setQuantity(1);
            orderProductDao.save(cart);
        }
        else{
            if (order.getStatus().equals("completed")){
                order = new Order();
                order.setStatus("pending");
                // We gunna save this to the cart(OrderProduct table)
                OrderProduct cart = new OrderProduct();
                cart.setOrder(order);
                cart.setProduct(product);
                cart.setQuantity(1);
                orderProductDao.save(cart);
            }
            else{
                // For when the user still has a pending status
                // Need to find the order with the pending status
                // use that order to create a new orderProduct (cart)
                // To add a new cart with the same orderId as the pending status
                // create if statement before the create to search if the product id
                // is already present in the order by orderId, if so update, if not create.
                OrderProduct cart = orderProductDao.find
            }
        }

        log.info(product.toString());
        return response;
    }

    @RequestMapping(value = "/product/productSubmit", method ={ RequestMethod.POST, RequestMethod.GET })
    public ModelAndView submit(@Valid ProductFormBean formBean, BindingResult bindingResult) throws Exception{
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
            Product product = new Product();
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

    @RequestMapping(value = "/product/delete{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathParam("id") Integer id) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/login");

        Product product = productDao.findById(id);
        if(product == null){
            // Error message
        }
        else{
            productDao.delete(product);
        }
        return response;
    }
}
