package com.Dimcooo.service;

import com.Dimcooo.dao.UserDAO;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void SaveUser(User user) {
        userDAO.AddUser(user);
    }

    @Override
    public User LoginUser(String login, String pass) {
        return userDAO.FindUser(login, pass);
    }

    @Override
    public Scholar CreateScholar(User user) {
        return userDAO.AddScholar(user);
    }
}
