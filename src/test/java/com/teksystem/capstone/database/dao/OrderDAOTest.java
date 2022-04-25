package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.Order;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderDAOTest {

    @Autowired
    private OrderDAO orderDao;

    @Test
    @org.junit.jupiter.api.Order(1)
    @Rollback(value = false)
    public void saveOrderTest(){
        Order order = new Order(10, null, "PENDING", null, null);
        orderDao.save(order);
        // Testing to see if the order is actual created by determining that the id is not null
        Assertions.assertNotNull(order.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    public void getOrderTest(){
        Order order = orderDao.findById(1);
        Assertions.assertEquals(1, order.getId());
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
        Order order = orderDao.findById(1);
        order.setStatus("COMPLETED");
        Assertions.assertEquals(orderDao.findById(1).getStatus(), order.getStatus());
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    @Rollback(value = false)
    public void deleteOrderTest() {
        Order order = orderDao.findById(1);
        orderDao.delete(order);
        Optional<Order> optionalOrder = Optional.ofNullable(orderDao.findById(order.getId()));

        Order orderUP = null;
        if ((optionalOrder.isPresent())){
            orderUP = optionalOrder.get();
        }

        Assertions.assertNull(orderUP);
    }
}
