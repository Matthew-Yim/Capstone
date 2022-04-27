package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    public Product findById(@Param("id") Integer id);

    public Product findProductByName(@Param("name") String name);

    public Product findProductByImageUrl(@Param("imageUrl") String imageUrl);

    public Product findProductByCategory(@Param("category") String category);

    public Product findProductByDescription(@Param("description") String description);

    public List<Product> findByPrice(@Param("price") Double price);

    public List<Product> findByNameIgnoreCaseContaining(@Param("name") String name);

    @Query("select product from Product as product where product.category = :category")
    public List<Product> findByCategory(@Param("category") String category);
}
