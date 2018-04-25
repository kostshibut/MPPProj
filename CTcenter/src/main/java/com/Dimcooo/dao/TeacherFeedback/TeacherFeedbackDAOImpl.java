package com.Dimcooo.dao.TeacherFeedback;

import com.Dimcooo.model.TeacherFeedback;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<TeacherFeedback> GetAllScholarFeedback(int scholarId) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            List<TeacherFeedback> teacherFeedbackList = session.createCriteria(TeacherFeedback.class)
                    .add(Restrictions.like("scholarScholarId", scholarId))
                    .list();

            session.getTransaction().commit();
            return teacherFeedbackList;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<TeacherFeedback> GetAllTeacherFeedback(int teacherId) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            List<TeacherFeedback> teacherFeedbackList = session.createCriteria(TeacherFeedback.class)
                    .add(Restrictions.like("teacherTeacherId", teacherId))
                    .list();

            session.getTransaction().commit();
            return teacherFeedbackList;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
