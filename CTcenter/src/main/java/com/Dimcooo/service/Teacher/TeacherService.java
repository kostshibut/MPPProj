package com.Dimcooo.service.Teacher;

import com.Dimcooo.model.Teacher;
import com.Dimcooo.model.User;

import java.util.List;

public interface TeacherService {
    List<Teacher> GetListOfTeachers();
    Teacher FindTeacherInfo(int id);
    Teacher FindTeacherByUser(User user);
    Teacher CreateTeacher(User user, String spetialization);
    Boolean DeleteTeacher(Teacher teacher);
}
