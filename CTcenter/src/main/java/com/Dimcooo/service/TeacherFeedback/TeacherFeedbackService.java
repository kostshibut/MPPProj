package com.Dimcooo.service.TeacherFeedback;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Teacher;
import com.Dimcooo.model.TeacherFeedback;

import java.util.List;

public interface TeacherFeedbackService {
    TeacherFeedback AddTeacherFeedback(TeacherFeedback teacherFeedback, Teacher teacher, Scholar scholar);
    List<TeacherFeedback> GetScholarFeedback(Scholar scholar);
    List<TeacherFeedback> GetTeacherFeedback(Teacher teacher);
    List<TeacherFeedback> GetTeacherFeedback(int teacherId);
}
