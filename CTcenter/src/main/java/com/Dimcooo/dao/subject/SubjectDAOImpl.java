package com.Dimcooo.dao.subject;

import com.Dimcooo.model.Subject;
import com.Dimcooo.model.Teacher;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDAOImpl implements SubjectDAO {
    private Session session;

    @Override
    public List<Subject> GetDataFromSubjectTable() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Subject.class);

        session.getTransaction().commit();
        return criteria.list();
    }
}
