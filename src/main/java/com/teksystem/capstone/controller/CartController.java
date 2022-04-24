package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.dao.OrderDAO;
import com.teksystem.capstone.database.dao.OrderProductDAO;
import com.teksystem.capstone.database.dao.ProductDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.teksystem.capstone.database.dao.UserDAO;
import com.teksystem.capstone.database.entity.Order;
import com.teksystem.capstone.database.entity.OrderProduct;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.database.entity.User;

import java.util.List;

@Slf4j
@Controller
public class CartController {

    @Autowired
    private ProductDAO productDao;

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private OrderProductDAO orderProductDao;

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/cart/cart", method = RequestMethod.GET)
    public ModelAndView cartView() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("cart/cart");

        List<OrderProduct> ordersKey = orderProductDao.findAll();

        response.addObject("ordersKey", ordersKey);
        return response;
    }

    //this has too be product id not order_products
    @RequestMapping(value = "/AddCart/{productId}", method = RequestMethod.GET)
    public ModelAndView addItemToList(@PathVariable("productId") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("cart/cart");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDao.findByEmail(username);

        // add items to list
        //create new order there and set status to pending
        //in the cart have the cart look up for any active order associated to the user log in and have them completed
        Product product = productDao.findById(productId);
        OrderProduct cartItem;
        Order order = orderDao.findOrderByUserIdAndStatus(user.getId(), "PENDING");
        // Fresh Start new order and new cartItem
        if (order == null) {
            order = new Order();
            order.setStatus("PENDING");
            order.setUser(user);
            //order.setOrderDate();
            // We gunna save this to the cart(OrderProduct table)
            cartItem = new OrderProduct();
            cartItem.setOrder(order);
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
        } else {
            // If user's current order is complete --> create new order and new cartItem
            if (order.getStatus().equals("COMPLETE")) {
                order = new Order();
                order.setStatus("active");
                // We gunna save this to the cart(OrderProduct table)
                cartItem = new OrderProduct();
                cartItem.setOrder(order);
                cartItem.setProduct(product);
                cartItem.setQuantity(1);
                orderProductDao.save(cartItem);
            // If user's current order is incomplete --> create new cartItem set cartItem.order --> PENDING order #
            } else {
                cartItem = orderProductDao.findOrderProductByProductAndOrder(product, order);
                if (cartItem == null){
                    cartItem = new OrderProduct();
                    cartItem.setOrder(order);
                    cartItem.setProduct(product);
                    cartItem.setQuantity(1);
                }
                else{
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                }
            }
        }
        orderDao.save(order);
        orderProductDao.save(cartItem);
        log.info("added: " + cartItem.getProduct().getName());
        return response;
    }
    @RequestMapping(value = "/cart/delete/{orderProductId}", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable("orderProductId") Integer orderProductId) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("cart/cart");
        OrderProduct cartItem = orderProductDao.findById(orderProductId);
        if(cartItem == null){
            String error = "You Dunn messed up";
            response.addObject("error", error);
        }
        else{
            orderProductDao.delete(cartItem);
            log.info("We finna delete Product: " + cartItem.getId());
        }
        return response;
    }

    @RequestMapping(value = "/cart/subtract/{orderProductId}", method = RequestMethod.GET)
    public ModelAndView subtractQuantity(@PathVariable("orderProductId") Integer orderProductId) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/cart/cart");
        OrderProduct cartItem = orderProductDao.findById(orderProductId);
        if(cartItem == null){
            String error = "You Dunn messed up";
            response.addObject("error", error);
        }
        else{
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            orderProductDao.save(cartItem);
            log.info("We finna alter quantity down, quantity:" + cartItem.getQuantity());
        }
        return response;
    }

    @RequestMapping(value = "/cart/plus/{orderProductId}", method = RequestMethod.GET)
    public ModelAndView addQuantity(@PathVariable("orderProductId") Integer orderProductId) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/cart/cart");
        OrderProduct cartItem = orderProductDao.findById(orderProductId);
        if(cartItem == null){
            String error = "You Dunn messed up";
            response.addObject("error", error);
        }
        else{
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            orderProductDao.save(cartItem);
            log.info("We finna alter quantity up: " + cartItem.getId());
        }
        return response;
    }
}