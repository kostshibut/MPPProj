package com.Dimcooo;

import com.Dimcooo.model.AdminsEntity;
import com.Dimcooo.model.UsersEntity;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args){
        try {
            System.out.println("start");
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setName("Test");
            usersEntity.setAge(10);

            AdminsEntity adminsEntity = new AdminsEntity();
            adminsEntity.setName("AdmTest");

            session.save(usersEntity);
            session.save(adminsEntity);
            session.getTransaction().commit();

            session.getSessionFactory().close();

            System.out.println("done");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
