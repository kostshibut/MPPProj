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
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Subject.class);
            System.out.println(criteria.list());

            session.getTransaction().commit();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
