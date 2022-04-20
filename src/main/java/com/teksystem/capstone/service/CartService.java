package com.teksystem.capstone.service;

import com.teksystem.capstone.database.dao.OrderProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private OrderProductDAO cartDao;

//    public List<CartItem> listCartItems(User user){
//        return cartDao.findByUser(user);
//    }
}
