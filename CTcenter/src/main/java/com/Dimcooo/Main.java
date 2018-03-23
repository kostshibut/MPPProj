package com.Dimcooo;

import com.Dimcooo.model.User;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;

public class Main {
    public static void main(String args[]){
        try {
            System.out.println("start");
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            User user = new User();
            user.setLogin("test login");
            user.setPassword("test password");
            user.setFirstName("Test Name");
            user.setLastName("Test Last Name");
            user.setAge(18);
            user.setEmail("some email");
            user.setEducation("Test Education");

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
