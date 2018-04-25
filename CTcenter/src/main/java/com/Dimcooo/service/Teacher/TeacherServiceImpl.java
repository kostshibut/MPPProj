package com.Dimcooo.service.Teacher;

import com.Dimcooo.dao.Teacher.TeacherDAO;
import com.Dimcooo.model.Teacher;
import com.Dimcooo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    public List<Teacher> GetListOfTeachers() {
        try {
            return teacherDAO.GetDataFromTeacherTable();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Teacher FindTeacherInfo(int id) {
        try {
            return teacherDAO.FindTeacherById(id);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Teacher FindTeacherByUser(User user) {
        try {
            return teacherDAO.FindTeacherByUserId(user.getUserId());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Teacher CreateTeacher(User user, String spetialization) {
        try {
            return teacherDAO.AddTeacherToTable(user, spetialization);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Boolean DeleteTeacher(Teacher teacher) {
        try {
            return teacherDAO.DeleteTeacher(teacher);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
