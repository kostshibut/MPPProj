package com.Dimcooo.dao.Task;

import com.Dimcooo.model.Task;
import com.Dimcooo.util.HibernateSessionFactory;
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
}
