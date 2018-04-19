package com.Dimcooo.service.User;

import com.Dimcooo.model.User;

public interface UserService {
    User SaveUser(User user);
    User FindByLogin(String login);
}
