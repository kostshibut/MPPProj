package com.Dimcooo.dao;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
import com.Dimcooo.util.Encryptor;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

    private Session session;

    @Transactional
    @Override
    public User AddUser(User user) {
        try {
            System.out.println("start");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            user.setPassword(Encryptor.EncryptString(user.getPassword()));

            session.save(user);
            System.out.println("In DAO " + user);
            session.getTransaction().commit();
            System.out.println("done");

            return user;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public User FindUserByID(int id) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            User user = session.load(User.class, id);

            session.getTransaction().commit();

            return user;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public User FindUserByLogin(String login) {
        try {
            System.out.println("start");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(User.class);
            User user = (User)(criteria.add(Restrictions.eq("login", login)).uniqueResult());

            session.getTransaction().commit();

//            session.getSessionFactory().close();

            System.out.println("done");

            return user;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        session = null;
    }
}
