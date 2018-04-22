package com.Dimcooo.service.TeacherFeedback;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Teacher;
import com.Dimcooo.model.TeacherFeedback;

public interface TeacherFeedbackService {
    TeacherFeedback AddTeacherFeedback(TeacherFeedback teacherFeedback, Teacher teacher, Scholar scholar);
}
