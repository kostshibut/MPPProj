package com.Dimcooo.dao;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;

public interface UserDAO {
    void AddUser(User user);
    User FindUser(String login, String pass);
    Scholar AddScholar(User user);
}
