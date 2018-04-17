package com.Dimcooo.dao;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ScholarDAOImpl implements ScholarDAO {

    private Session session;

    @Transactional
    @Override
    public Scholar AddScholar(User user) {
        try {
            System.out.println("try to set data to Scholar");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            System.out.println("try to open session");

            Scholar scholar = new Scholar();
            scholar.setUserByUserUserId(user);

            session.save(scholar);
            session.getTransaction().commit();

            System.out.println("saved");

            session.close();
            return scholar;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public User FindScholarInfo(Scholar scholar) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            User user = session.load(User.class, scholar.getScholarId());

            session.getTransaction().commit();

            System.out.println("done");

            return user;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
