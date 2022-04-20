package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.Order;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {

    public Order findById(@Param("id") Integer id);

    public Order findByUserId(@Param("userId") Integer userId);

    public Order findByCreditCard(@Param("creditCard") String creditCard);

    public List<Order> findByOrderDate(@Param("orderDate") Date orderDate);

    public List<Order> findByStatus(@Param("status") String status);

    @Query("select u from User as u join Order as o where u.id = :userId and o.status = :status")
    public Order findOrderByUserIdAndStatus(@Param("userId") Integer userId, @Param("status") String status);

}
