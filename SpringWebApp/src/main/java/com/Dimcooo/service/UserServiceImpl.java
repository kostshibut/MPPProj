package com.Dimcooo.service;

import com.Dimcooo.dao.UserDAO;
import com.Dimcooo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserServiceImpl implements UserService {
    //@Autowired
    private UserDAO userDAO;

    public void save(User user) {

    }

    public User findByUsername(String username) {
        return null;
    }
}
