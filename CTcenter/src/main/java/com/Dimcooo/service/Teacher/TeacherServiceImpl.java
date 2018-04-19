package com.Dimcooo.service.Teacher;

import com.Dimcooo.dao.Teacher.TeacherDAO;
import com.Dimcooo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    public List<Teacher> GetListOfTeachers() {
        return teacherDAO.GetDataFromTeacherTable();
    }
}
