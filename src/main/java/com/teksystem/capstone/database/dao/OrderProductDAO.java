package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderProductDAO extends JpaRepository<OrderProduct, Long> {
    //public List<Cart> listCartItems(User user);
//    public List<CartItem> findByUser(User user);
    public OrderProduct findById(@Param("id") Integer id);
    public List<OrderProduct> findByOrderId(@Param("orderId") Integer orderId);
    public OrderProduct findByProductId(@Param("productId") Integer Productid);
    public OrderProduct findByQuantity(@Param("quantity") Integer quantity);

    // Need querys for special gets, should have normal gets though
}
