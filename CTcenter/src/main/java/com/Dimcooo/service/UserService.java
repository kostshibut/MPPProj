package com.Dimcooo.service;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;

public interface UserService {
    void SaveUser(User user);
    User FindByLogin(String login);
    Scholar CreateScholar(User user);
}
