package com.Dimcooo.dao.subject;

import com.Dimcooo.model.Subject;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDAOImpl implements SubjectDAO {
    private Session session;

    @Override
    public List<Subject> GetDataFromSubjectTable() {
        try {
            System.out.println("Start get all data from subject table");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Subject.class);

            session.getTransaction().commit();
            System.out.println("Finish get all data from subject table");
            return criteria.list();
        }
        catch (Exception ex){
            System.out.println("Error with get all data from subject table");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Subject FindSubjectById(int id) {
        try {
            System.out.println("Start getting data by id");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Subject subject = session.load(Subject.class, id);

            session.getTransaction().commit();
            System.out.println("Finish getting data by id");
            return subject;
        }
        catch (Exception ex){
            System.out.println("Error with get data by id");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean DeleteSubject(Subject subject) {
        try {
            session.clear();
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            session.delete(subject);

            session.getTransaction().commit();
            System.out.println("Finish deletion subject");
            return true;
        }
        catch (Exception ex){
            System.out.println("Error with deletion subject");
            return false;
        }
    }

    @Override
    public Subject AddSubject(Subject subject) {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(subject);

            session.getTransaction().commit();
            System.out.println("Finish deletion subject");
            return subject;
    }

    @Override
    public Subject FindSubjectByName(String name) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Subject.class);
            Subject subject = (Subject)(criteria.add(Restrictions.eq("name", name)).uniqueResult());

            session.getTransaction().commit();

            return subject;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
