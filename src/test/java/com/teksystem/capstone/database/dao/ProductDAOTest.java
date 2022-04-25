package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDao;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveProductTest(){
        Product product = new Product(10,"Pepsi", "Sugar Free Pepsi", 0.75, "pepsi.jpg", "Soft Drink");
        productDao.save(product);
        // Testing to see if the product is actual created by determining that the id is not null
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
        Product product = productDao.findById(1);
        product.setDescription("This is just coffee in disguise");
        Assertions.assertEquals(productDao.findById(1).getDescription(), product.getDescription());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteProductTest() {
        Product product = productDao.findById(1);
        productDao.delete(product);
        Optional<Product> optionalProduct = Optional.ofNullable(productDao.findById(product.getId()));

        Product coffee = null;
        if ((optionalProduct.isPresent())){
            coffee = optionalProduct.get();
        }

        Assertions.assertNull(coffee);
    }
}
