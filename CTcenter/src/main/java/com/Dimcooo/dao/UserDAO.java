package com.Dimcooo.dao;

import com.Dimcooo.model.User;

public interface UserDAO {
    User AddUser(User user);
    User FindUserByID(int id);
    User FindUserByLogin(String login);
}