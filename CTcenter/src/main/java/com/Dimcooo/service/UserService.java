package com.Dimcooo.service;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;

public interface UserService {
    void SaveUser(User user);
    User LoginUser(String login, String pass);
    Scholar CreateScholar(User user);
    String AutologinUser(User user);
}
