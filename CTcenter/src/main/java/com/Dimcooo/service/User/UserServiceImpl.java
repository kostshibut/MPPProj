package com.Dimcooo.service.User;

import com.Dimcooo.dao.User.UserDAO;
import com.Dimcooo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User SaveUser(User user) {
        try {
            userDAO.AddUser(user);
            User userByLogin = FindByLogin(user.getLogin());
            System.out.println("in Service" + userByLogin);
            return userByLogin;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public User FindByLogin(String login) {
        try {
            return userDAO.FindUserByLogin(login);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public User FindUserById(int id) {
        try {
            return userDAO.FindUserByID(id);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
