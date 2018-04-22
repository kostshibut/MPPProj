package com.Dimcooo.dao.TeacherFeedback;

import com.Dimcooo.model.TeacherFeedback;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherFeedbackDAOImpl implements TeacherFeedbackDAO {
    Session session;

    @Override
    public TeacherFeedback AddTeacherFeedbackToTable(TeacherFeedback teacherFeedback) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(teacherFeedback);

            session.getTransaction().commit();
            return teacherFeedback;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
