package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.OrderDAO;
import com.teksystem.capstone.database.dao.OrderProductDAO;
import com.teksystem.capstone.database.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.entity.Order;
import com.teksystem.capstone.database.entity.OrderProduct;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.database.entity.User;

import javax.validation.Valid;
import java.util.List;

public class CartController {

    @Autowired
    private ProductDAO productDao;

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private OrderProductDAO orderProductDao;

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cartView() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/cart");

        List<OrderProduct> ordersKey = orderProductDao.findAll();

        response.addObject("productsKey", ordersKey);
        return response;
    }
//    Cart cart = orderProductDao.findById(form.ge) // userDao.findById(form.getId());
//    // Used to create a new user, if the user loaded by the database is null
//        if (user == null){
//        user = new User();
//    }
//    Order order = orderDao.findById()
//
//    @RequestMapping(value = "/cart", method = RequestMethod.GET)
//    public ModelAndView displayCart() throws Exception {
//        ModelAndView response = new ModelAndView();
//
//        response.setViewName("cart");
//        return response;
//    }

//    @RequestMapping(value = "/cart/addProduct", method = RequestMethod.POST)
//    public ModelAndView addToCart(@RequestParam Integer productId, @Valid BindingResult bindingResult) throws Exception {
//        ModelAndView response = new ModelAndView();
//
//        Product product = productDao.findById(productId);
//        response.setViewName("cart");
//        // first look up the user from the spring security
//        // next query the product based on the product Id
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        User user = userDao.findByEmail(username);
//
//
//        // need to query the produt from the database using the productid
//        // if you are able to find the product in the database okay
//        // if not then its an error and we can exit here and show some error message
//        // if the product is null then its an error condition
//        if (product == null) {
//            response.addObject("productNotFoundError", bindingResult);
//        }
//
//        Order order = orderDao.findOrderByUserIdAndStatus(user.getId(), "pending");
//        if (order == null){
//            order = new Order();
//            order.setStatus("pending");
//        }
//        else{
//
//        }
//        // look up the order in the database by the user id and the status
//        // for the create we are looking for an order with the status pending
//        // select * from orders wehre user_id = 1 and status = 'pending'
//        // either returns a record or not
//        // if no record returns .. then we need to create a new order
//        // set your user object onto the order and set pending status on the order
//        // order.setUser(user);
//        // order.setStatus("PENDING");
//        // save order
//
//        // query the orderproduct using the order_id and the product_id
//        // if the order product exists then increment the quantity
//        // otherwise create a new one with quantity 1
//
//        // here actually want to make the new OrderProduct entity
//        OrderProduct orderProduct = new OrderProduct();
//        //orderProduct.setProduct(product);
//        //orderProduct.setOrder(order);
//
//        // save this using the dao
//
//
//        return response;
//    }

}
