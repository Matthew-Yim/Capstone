package com.teksystem.capstone.service;

import com.teksystem.capstone.database.dao.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDao;
}
