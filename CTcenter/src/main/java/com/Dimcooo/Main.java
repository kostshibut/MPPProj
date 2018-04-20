package com.Dimcooo;

import com.Dimcooo.dao.subject.SubjectDAOImpl;
import com.Dimcooo.model.Subject;
import com.Dimcooo.model.Teacher;
import com.Dimcooo.util.Encryptor;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.Iterator;
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
