package com.Dimcooo;

import com.Dimcooo.model.Admin;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;

public class Main {
    public static void main(String args[]){
        try {
            System.out.println("start");
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            //Admin admin = new Admin();
            //System.out.println(session.get(admin.getClass(), 1));

            Scholar scholar = new Scholar();
            scholar.setUserUserId(3);
            session.save(scholar);

            session.getTransaction().commit();

            session.getSessionFactory().close();

            System.out.println("done");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
