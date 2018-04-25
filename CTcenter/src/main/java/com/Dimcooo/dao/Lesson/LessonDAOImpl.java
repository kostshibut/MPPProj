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

    @Override
    public boolean DeleteLesson(Lesson lesson) {
        try {
            session.clear();
            System.out.println("start delete lesson");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            session.delete(lesson);

            session.getTransaction().commit();
            return true;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Lesson CreateLesson(Lesson lesson) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(lesson);

            session.getTransaction().commit();
            System.out.println("finish");
            return lesson;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Lesson FindLessonByTheme(String themeLesson) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Lesson.class);
            Lesson lesson = (Lesson)(criteria.add(Restrictions.like("theme", themeLesson)).uniqueResult());

            session.getTransaction().commit();
            return lesson;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Lesson FindSubjectById(int lessonId) {
        try {
            System.out.println("Start getting data by id");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Lesson lesson = session.load(Lesson.class, lessonId);

            session.getTransaction().commit();
            System.out.println("Finish getting data by id");
            return lesson;
        }
        catch (Exception ex){
            System.out.println("Error with get data by id");
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
