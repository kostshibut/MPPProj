package com.Dimcooo.dao;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
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
    public void AddUser(User user) {
        try {
            System.out.println("start");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

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
    public User FindUser(String login, String pass) {
        try {
            System.out.println("start");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(User.class);
            User user = (User)(criteria.add(Restrictions.eq("login", login)).uniqueResult());

            session.getTransaction().commit();

            session.getSessionFactory().close();

            System.out.println("done");

            return user;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Scholar AddScholar(User user) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            User userToAdd = session.load(User.class, user.getUserId());

            Scholar scholar = new Scholar();
            scholar.setUserUserId(user.getUserId());
            scholar.setUserByUserUserId(userToAdd);

            session.save(scholar);
            session.getTransaction().commit();

            session.getSessionFactory().close();

            return scholar;
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
