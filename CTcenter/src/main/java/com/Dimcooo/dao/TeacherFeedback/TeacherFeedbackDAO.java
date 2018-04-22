package com.Dimcooo.dao.TeacherFeedback;

import com.Dimcooo.model.TeacherFeedback;

import java.util.List;

public interface TeacherFeedbackDAO {
    TeacherFeedback AddTeacherFeedbackToTable(TeacherFeedback teacherFeedback);
    List<TeacherFeedback> GetAllScholarFeedback(int scholarId);
    List<TeacherFeedback> GetAllTeacherFeedback(int teacherId);
}
