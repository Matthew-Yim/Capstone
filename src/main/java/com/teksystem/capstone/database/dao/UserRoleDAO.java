package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    public UserRole findById(@Param("id") Integer id);

    List<UserRole> findByUserId(@Param("userId") Integer userId);

    List<UserRole> findByUserRole(@Param("userRole") String userRole);

}
