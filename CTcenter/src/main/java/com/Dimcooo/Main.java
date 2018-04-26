package com.Dimcooo;

import com.Dimcooo.dao.Lesson.LessonDAO;
import com.Dimcooo.dao.Lesson.LessonDAOImpl;
import com.Dimcooo.dao.listScholarSubject.ListScholarSubjectDAOImpl;
import com.Dimcooo.dao.subject.SubjectDAOImpl;
import com.Dimcooo.model.Subject;
import com.Dimcooo.model.Teacher;
import com.Dimcooo.util.Encryptor;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String args[]){
        try {
            ListScholarSubjectDAOImpl scholarSubjectDAO = new ListScholarSubjectDAOImpl();
            System.out.println(scholarSubjectDAO.GetAllScholarSubjects(23));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}