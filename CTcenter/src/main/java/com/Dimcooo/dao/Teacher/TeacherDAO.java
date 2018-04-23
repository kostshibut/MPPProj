package com.Dimcooo.dao.Teacher;

import com.Dimcooo.model.Teacher;
import com.Dimcooo.model.User;

import java.util.List;

public interface TeacherDAO {
    List<Teacher> GetDataFromTeacherTable();
    Teacher FindTeacherById(int id);
    Teacher FindTeacherByUserId(int id);
    Teacher AddTeacherToTable(User user, String spetialization);
    boolean DeleteTeacher(Teacher teacher);
}
