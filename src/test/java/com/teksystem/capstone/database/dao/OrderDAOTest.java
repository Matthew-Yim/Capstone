package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.Order;
import com.teksystem.capstone.database.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrderDAOTest {

    @Autowired
    private OrderDAO orderDao;

    @Test
    public void testMethod(){

    }
    @Test
    @org.junit.jupiter.api.Order(1)
    public void saveOrderTest(){
        User user = new User();

        user.setId(20);
        user.setEmail("ff@gmail.com");
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setPassword("password");
        Order order = new Order(10, null, "PENDING", null, user);
        orderDao.save(order);
        Assertions.assertNotNull(order.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    public void getOrderTest(){
        Order order = orderDao.findById(2);
        Assertions.assertEquals(2, order.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void getListOfOrders(){
        List<Order> orders = orderDao.findAll();
        Assertions.assertTrue(orders.size() > 0);
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    public void updateOrderTest(){
        Order order = orderDao.findById(2);
        order.setStatus("COMPLETED");
        orderDao.save(order);
        Assertions.assertEquals(orderDao.findById(2).getStatus(), order.getStatus());
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    public void deleteOrderTest() {
        Order order = orderDao.findById(2);
        orderDao.delete(order);
        Optional<Order> optionalOrder = Optional.ofNullable(orderDao.findById(order.getId()));

        Order orderUP = null;
        if ((optionalOrder.isPresent())){
            orderUP = optionalOrder.get();
        }

        Assertions.assertNull(orderUP);
    }
}
