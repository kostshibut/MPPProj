package com.Dimcooo.dao.Scholar;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ScholarDAOImpl implements ScholarDAO {

    private Session session;

    @Transactional
    @Override
    public Scholar AddScholar(User user) {
        try {
            System.out.println("Start adding scholar");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Scholar scholar = new Scholar();
            scholar.setUserByUserUserId(user);

            session.save(scholar);
            session.getTransaction().commit();

            session.close();
            System.out.println("Finish adding scholar");
            return scholar;
        }
        catch (Exception ex){
            System.out.println("Error with adding scholar");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public User FindScholarById(int id) {
        try {
            System.out.println("Start finding scholar by id");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            User user = session.load(User.class, id);

            session.getTransaction().commit();

            System.out.println("Finish finding scholar by id");
            return user;
        }
        catch (Exception ex){
            System.out.println("Error with finding scholar by id");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Scholar FindScholarByUserId(int id) {
        try {
            System.out.println("Start finding scholar by user id");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Scholar.class);

            Scholar scholar = (Scholar) (criteria.add(Restrictions.eq("userUserId", id)).uniqueResult());

            session.getTransaction().commit();
            System.out.println("Finish finding scholar by user id");
            return scholar;
        }
        catch (Exception ex){
            System.out.println("Error with finding scholar by user id");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Scholar FindScholarByScholarId(int id) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Scholar scholar = session.load(Scholar.class, id);

            session.getTransaction().commit();
            return scholar;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
