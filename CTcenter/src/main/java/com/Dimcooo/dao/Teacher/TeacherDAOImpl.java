package com.Dimcooo.dao.Teacher;

import com.Dimcooo.model.Teacher;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
    private Session session;

    @Override
    public List<Teacher> GetDataFromTeacherTable() {
        try {
            System.out.println("Start getting all data from Teacher table");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Teacher.class);

            session.getTransaction().commit();
            System.out.println("Finish getting all data from Teacher table");
            return criteria.list();
        }
        catch (Exception ex){
            System.out.println("Error with getting all data from Teacher table");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Teacher FindTeacherById(int id) {
        try {
            System.out.println("Start getting data from Teacher table by id");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Teacher teacher = session.load(Teacher.class, id);

            session.getTransaction().commit();
            System.out.println("Finish getting data from Teacher table by id");
            return teacher;
        }
        catch (Exception ex){
            System.out.println("Error with finding data by id in Teacher table");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Teacher FindTeacherByUserId(int id) {
        try {
            System.out.println("Start finding data by user id");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Teacher.class);

            Teacher teacher = (Teacher) (criteria.add(Restrictions.eq("userUserId", id)).uniqueResult());

            session.getTransaction().commit();
            System.out.println("Finish finding data by user id");
            return teacher;
        }
        catch (Exception ex){
            System.out.println("Error with finding data by user id in Teacher table");
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
