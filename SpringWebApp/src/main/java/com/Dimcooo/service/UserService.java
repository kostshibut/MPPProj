package com.Dimcooo.service;

import com.Dimcooo.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
