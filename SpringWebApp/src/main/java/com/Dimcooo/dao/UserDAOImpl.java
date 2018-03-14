package com.Dimcooo.dao;

import com.Dimcooo.model.UsersEntity;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private Session session;

    public UserDAOImpl(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public boolean AddUser(UsersEntity user) {
        try {
            session.save(user);
            return true;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        session.getSessionFactory().close();
    }
}
