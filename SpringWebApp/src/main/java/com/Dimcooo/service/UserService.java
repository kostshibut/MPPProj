package com.Dimcooo.service;

import com.Dimcooo.dao.UserDAO;
import com.Dimcooo.model.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public boolean RegisterUser(UsersEntity user){
        return userDAO.AddUser(user);
    }
}
