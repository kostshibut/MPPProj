package com.Dimcooo.dao.User;

import com.Dimcooo.model.User;

public interface UserDAO {
    User AddUser(User user);
    User FindUserByID(int id);
    User FindUserByLogin(String login);
}