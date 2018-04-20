package com.Dimcooo.dao.listScholarSubject;

import com.Dimcooo.model.ListScholarSubject;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Subject;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ListScholarSubjectDAOImpl implements ListScholarSubjectDAO {
    private Session session;

    @Transactional
    @Override
    public ListScholarSubject AddToListSnS(Scholar scholar, Subject subject) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        ListScholarSubject listScholarSubject = new ListScholarSubject();
        listScholarSubject.setScholarByScholarScholarId(scholar);
        listScholarSubject.setSubjectBySubjectSubjectId(subject);

        session.save(listScholarSubject);

        session.getTransaction().commit();

        return listScholarSubject;
    }
}
