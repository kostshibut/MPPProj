package com.Dimcooo.dao.Lesson;

import com.Dimcooo.model.Lesson;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonDAOImpl implements LessonDAO {
    Session session;

    @Override
    public List<Lesson> GetDataFromLessonTable(int id) {
        try {
            System.out.println("Start finding lesson by subjectSubjectId");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            List<Lesson> lessonList = session.createCriteria(Lesson.class)
                    .add(Restrictions.like("subjectSubjectId", id))
                    .list();

            session.getTransaction().commit();
            System.out.println("Finish finding lesson by subjectSubjectId");
            return lessonList;
        }
        catch (Exception ex){
            System.out.println("Error with finding lesson by subjectSubjectId");
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
