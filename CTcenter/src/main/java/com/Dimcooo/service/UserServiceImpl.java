package com.Dimcooo.service;

import com.Dimcooo.dao.UserDAO;
import com.Dimcooo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User SaveUser(User user) {
        userDAO.AddUser(user);
        User userByLogin = FindByLogin(user.getLogin());
        System.out.println("in Service" + userByLogin);
        return userByLogin;
    }

    @Override
    public User FindByLogin(String login) {
        return userDAO.FindUserByLogin(login);
    }
}
