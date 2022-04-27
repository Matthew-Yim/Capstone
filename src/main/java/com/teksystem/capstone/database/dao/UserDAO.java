package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    public User findById(@Param("id") Integer id);

    public User findUserByEmail(@Param("email") String email);

    public List<User> findByFirstName(@Param("firstName") String firstName);

    public List<User> findByLastName(@Param("lastName") String lastName);

    public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    //Native query = SQL / Query in Hibernate or Java = HQL
    @Query("select u from User u where u.password = :password")
    public List<User> getByPassword(@Param("password") String password);

    // select * from user where upper(first_name) like '%A%';
    List<User> findByFirstNameIgnoreCaseContaining(@Param("firstName") String search);

    User findByEmail(String value);
}
