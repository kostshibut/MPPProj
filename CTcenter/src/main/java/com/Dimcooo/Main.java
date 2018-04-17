package com.Dimcooo;

import com.Dimcooo.model.Admin;
import com.Dimcooo.model.LoginUser;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
import com.Dimcooo.service.UserServiceImpl;
import com.Dimcooo.util.Encryptor;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.security.MessageDigest;
import java.util.List;

public class Main {
    public static void main(String args[]){
        try {
            System.out.println(Encryptor.EncryptString("123"));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
