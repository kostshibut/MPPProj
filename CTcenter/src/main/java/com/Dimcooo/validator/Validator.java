package com.Dimcooo.validator;

import com.Dimcooo.dao.User.UserDAOImpl;
import com.Dimcooo.model.LoginUser;
import com.Dimcooo.model.User;
import com.Dimcooo.util.Encryptor;

public class Validator {
    public static boolean AutentificationSignIn(User user, LoginUser loginUser) {

        if (user != null && user.getLogin().equals(loginUser.getLogin()) &&
                user.getPassword().equals(Encryptor.EncryptString(loginUser.getPass()))) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean FindSimilarLogins(String registerLogin){
        UserDAOImpl userDAO = new UserDAOImpl();
        if(userDAO.FindUserByLogin(registerLogin) != null){
            return false;
        }
        else {
            return true;
        }
    }
}
