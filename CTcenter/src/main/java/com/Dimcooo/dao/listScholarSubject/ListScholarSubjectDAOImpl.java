package com.Dimcooo.dao.listScholarSubject;

import com.Dimcooo.model.ListScholarSubject;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Subject;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ListScholarSubjectDAOImpl implements ListScholarSubjectDAO {
    private Session session;

    @Transactional
    @Override
    public ListScholarSubject AddToListSnS(Scholar scholar, Subject subject) {
        try {
            System.out.println("Start adding scholar and subject to list");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            ListScholarSubject listScholarSubject = new ListScholarSubject();
            listScholarSubject.setScholarByScholarScholarId(scholar);
            listScholarSubject.setSubjectBySubjectSubjectId(subject);

            session.save(listScholarSubject);

            session.getTransaction().commit();
            System.out.println("Finish adding scholar and subject to list");
            return listScholarSubject;
        }
        catch (Exception ex){
            System.out.println("Error with adding scholar and subject to list");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ListScholarSubject> GetAllDataFromTable() {
        try {
            System.out.println("Start getting all data from list scholar subject");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(ListScholarSubject.class);

            session.getTransaction().commit();
            System.out.println("Finish getting all data from list scholar subject");
            return criteria.list();
        }
        catch (Exception ex){
            System.out.println("Error with getting all data from list scholar subject");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ListScholarSubject> GetAllScholarSubjects(int scholarId) {
        try {
            System.out.println("Start getting data from list scholar subject by scholar id");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            List<ListScholarSubject> scholarSubjectList = session.createCriteria(ListScholarSubject.class)
                    .add(Restrictions.like("scholarScholarId", scholarId))
                    .list();

            session.getTransaction().commit();
            System.out.println("Finish getting data from list scholar subject by scholar id");
            return scholarSubjectList;
        }
        catch (Exception ex){
            System.out.println("Error with getting data from list scholar subject by scholar id");
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
