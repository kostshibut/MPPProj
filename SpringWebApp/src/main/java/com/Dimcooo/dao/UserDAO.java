package com.Dimcooo.dao;

import com.Dimcooo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
    boolean AddUser(User user);
}
