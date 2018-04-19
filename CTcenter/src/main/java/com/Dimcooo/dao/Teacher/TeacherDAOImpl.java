package com.Dimcooo.dao.Teacher;

import com.Dimcooo.model.Teacher;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
    private Session session;

    @Override
    public List<Teacher> GetDataFromTeacherTable() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Teacher.class);
        //List<Teacher> Teachers = criteria.list();

        session.getTransaction().commit();
        return criteria.list();
    }

    @Override
    public Teacher FindTeacherById(int id) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Teacher teacher = session.load(Teacher.class, id);

        session.getTransaction().commit();
        return teacher;
    }
}
