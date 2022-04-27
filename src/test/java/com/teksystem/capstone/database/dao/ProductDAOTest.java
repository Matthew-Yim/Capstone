package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDao;

    @Test
    @Order(1)
    public void saveProductTest(){
        Product product = new Product(10,"Pepsi", "Sugar Free Pepsi", 0.75, "pepsi.jpg", "Soft Drink");
        productDao.save(product);
        Assertions.assertNotNull(product.getId());
    }

    @Test
    @Order(2)
    public void getProductTest(){
        Product product = productDao.findById(1);
        Assertions.assertEquals(1, product.getId());
    }

    @Test
    @Order(3)
    public void getListOfProducts(){
        List<Product> products = productDao.findAll();
        Assertions.assertTrue(products.size() > 0);
    }

    @Test
    @Order(4)
    public void updateProductTest(){
        Product product = productDao.findById(11);
        product.setDescription("This is just coffee in disguise");
        productDao.save(product);
        Assertions.assertEquals(productDao.findById(11).getDescription(), product.getDescription());
    }

    @Test
    @Order(5)
    public void deleteProductTest() {
        Product product = productDao.findById(12);
        productDao.delete(product);
        Optional<Product> optionalProduct = Optional.ofNullable(productDao.findById(product.getId()));

        Product coffee = null;
        if ((optionalProduct.isPresent())){
            coffee = optionalProduct.get();
        }

        Assertions.assertNull(coffee);
    }
}
