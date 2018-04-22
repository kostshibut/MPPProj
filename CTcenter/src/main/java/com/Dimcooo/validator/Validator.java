package com.Dimcooo.validator;

import com.Dimcooo.dao.User.UserDAOImpl;
import com.Dimcooo.dao.subject.SubjectDAOImpl;
import com.Dimcooo.model.*;
import com.Dimcooo.util.Encryptor;
import com.sun.org.apache.xpath.internal.axes.IteratorPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Validator {
    public static boolean AutentificationSignIn(User user, LoginUser loginUser) {
        try {
            if (user != null && user.getLogin().equals(loginUser.getLogin()) &&
                    user.getPassword().equals(Encryptor.EncryptString(loginUser.getPass()))) {
                return true;
            } else {
                return false;
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
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
