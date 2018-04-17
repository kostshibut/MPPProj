package com.Dimcooo.service;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;

public interface UserService {
    User SaveUser(User user);
    User FindByLogin(String login);
}
