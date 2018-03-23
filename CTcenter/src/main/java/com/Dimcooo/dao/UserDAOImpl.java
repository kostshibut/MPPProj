package com.Dimcooo.dao;

import com.Dimcooo.model.User;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

    private Session session;

    @Transactional
    public void AddUser(User user) {
        try {
            System.out.println("start");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            user.setFirstName("some first name"); //costyl
            user.setLastName("some last name"); //costyl

            session.save(user);
            session.getTransaction().commit();

            session.getSessionFactory().close();

            System.out.println("done");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void finalize() throws Throwable {
        session = null;
    }
}
