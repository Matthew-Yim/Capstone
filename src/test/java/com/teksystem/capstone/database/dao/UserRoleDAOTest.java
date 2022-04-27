package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.database.entity.UserRole;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRoleDAOTest {

    @Autowired
    private UserRoleDAO userRoleDao;

    @Test
    @org.junit.jupiter.api.Order(1)
    @Rollback(value = false)
    public void saveUserTest(){
        UserRole userRole = new UserRole(10, 10, "ADMIN");
        userRoleDao.save(userRole);
        Assertions.assertNotNull(userRole.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    public void getUserRoleTest(){
        UserRole userRole = userRoleDao.findById(1);
        Assertions.assertEquals(1, userRole.getId());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void getListOfUserRoles(){
        List<UserRole> userRoles = userRoleDao.findAll();
        Assertions.assertTrue(userRoles.size() > 0);
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    public void updateUserRoleTest(){
        UserRole userRole = userRoleDao.findById(1);
        userRole.setUserRole("UNEMPLOYED");
        Assertions.assertEquals(userRoleDao.findById(1).getUserRole(), userRole.getUserRole());
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    @Rollback(value = false)
    public void deleteUserRoleTest() {
        UserRole userRole = userRoleDao.findById(1);
        userRoleDao.delete(userRole);
        Optional<UserRole> optionalUserRole = Optional.ofNullable(userRoleDao.findById(userRole.getId()));

        UserRole Squidz = null;
        if ((optionalUserRole.isPresent())){
            Squidz = optionalUserRole.get();
        }

        Assertions.assertNull(Squidz);
    }
}
