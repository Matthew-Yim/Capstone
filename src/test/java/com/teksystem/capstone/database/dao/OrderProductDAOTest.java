package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.OrderProduct;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderProductDAOTest {

    @Autowired
    private OrderProductDAO orderProductDao;
    @Test
    @org.junit.jupiter.api.Order(1)
    @Rollback(value = false)
    public void saveOrderProductTest(){
        OrderProduct orderProduct = new OrderProduct(10, 10, null, null);
        orderProductDao.save(orderProduct);
        // Testing to see if the order is actual created by determining that the id is not null
        Assertions.assertNotNull(orderProduct.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    public void getOrderProductTest(){
        OrderProduct order = orderProductDao.findById(1);
        Assertions.assertEquals(1, order.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void getListOfOrderProducts(){
        List<OrderProduct> orderProducts = orderProductDao.findAll();
        Assertions.assertTrue(orderProducts.size() > 0);
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    public void updateOrderProductTest(){
        OrderProduct orderProduct = orderProductDao.findById(1);
        orderProduct.setQuantity(22);
        Assertions.assertEquals(orderProductDao.findById(1).getQuantity(), orderProduct.getQuantity());
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    @Rollback(value = false)
    public void deleteOrderProductTest() {
        OrderProduct orderProduct = orderProductDao.findById(1);
        orderProductDao.delete(orderProduct);
        Optional<OrderProduct> optionalOrderProduct = Optional.ofNullable(orderProductDao.findById(orderProduct.getId()));

        OrderProduct Jonin = null;
        if ((optionalOrderProduct.isPresent())){
            Jonin = optionalOrderProduct.get();
        }

        Assertions.assertNull(Jonin);
    }}
