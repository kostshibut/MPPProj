package com.Dimcooo.dao.Teacher;

import com.Dimcooo.model.Teacher;

import java.util.List;

public interface TeacherDAO {
    List<Teacher> GetDataFromTeacherTable();
    Teacher FindTeacherById(int id);
    Teacher FindTeacherByUserId(int id);
}
