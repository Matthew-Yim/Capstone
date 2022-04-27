package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDao;

    @Test
    @Order(1)
    public void saveUserTest(){
        User user = new User(10, "strawberry@aol.com", "Will", "Smith", "Jaded");
        userDao.save(user);
        // Testing to see if the order is actual created by determining that the id is not null
        Assertions.assertNotNull(user.getId());
    }

    @Test
    @Order(2)
    public void getUserTest(){
        User user = userDao.findById(8);
        Assertions.assertEquals(8, user.getId());
    }

    @Test
    @Order(3)
    public void getListOfUsers(){
        List<User> users = userDao.findAll();
        Assertions.assertTrue(users.size() > 0);
    }

    @Test
    @Order(4)
    public void updateUserTest(){
        User user = userDao.findById(8);
        user.setFirstName("Rick");
        userDao.save(user);
        Assertions.assertEquals(userDao.findById(8).getFirstName(), user.getFirstName());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest() {
        User user = userDao.findById(8);
        userDao.delete(user);
        Optional<User> optionalUser = Optional.ofNullable(userDao.findById(user.getId()));

        User Spongebob = null;
        if ((optionalUser.isPresent())){
            Spongebob = optionalUser.get();
        }

        Assertions.assertNull(Spongebob);
    }
}
