package com.Dimcooo.validator;

import com.Dimcooo.model.LoginUser;
import com.Dimcooo.model.User;

public class Validator {
    public boolean AutentificationSignIn(User user, LoginUser loginUser) {
        if (user.getLogin().equals(loginUser.getLogin()) && user.getPassword().equals(loginUser.getPass())){
            return true;
        }
        else {
            return false;
        }
    }
}
