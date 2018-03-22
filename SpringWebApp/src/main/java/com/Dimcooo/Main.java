package com.Dimcooo;

import com.Dimcooo.model.User;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args){
        try {
            System.out.println("start");
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            User user = new User();
            user.setUsername("Ivan");
            user.setPassword("$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG");

            session.save(user);
            session.getTransaction().commit();

            session.getSessionFactory().close();

            System.out.println("done");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
