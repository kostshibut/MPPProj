package com.Dimcooo.dao.Task;

import com.Dimcooo.model.Task;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    Session session;

    @Override
    public List<Task> GetDataFromTaskTable(int id) {
        try {
            System.out.println("Start finding task by lessonLessonId");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            List<Task> taskList = session.createCriteria(Task.class)
                    .add(Restrictions.like("lessonLessonId", id))
                    .list();

            session.getTransaction().commit();
            System.out.println("Finish finding task by lessonLessonId");
            return taskList;
        }
        catch (Exception ex){
            System.out.println("Error with finding task by lessonLessonId");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean DeleteTask(Task task) {
        try {
            session.clear();
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            session.delete(task);

            session.getTransaction().commit();
            System.out.println("finish deleting task");
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Task CreateTask(Task task) {
        try {
            System.out.println("Creation task");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(task);

            session.getTransaction().commit();

            return task;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Task FindTaskByTheme(String theme) {
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Task.class);
            Task task = (Task) (criteria.add(Restrictions.like("theme", theme)).uniqueResult());

            session.getTransaction().commit();
            return task;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Task FindTaskById(int taskId) {
        try {
            System.out.println("Start getting data by id");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Task task = session.load(Task.class, taskId);

            session.getTransaction().commit();
            System.out.println("Finish getting data by id");
            return task;
        }
        catch (Exception ex){
            System.out.println("Error with get data by id");
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
