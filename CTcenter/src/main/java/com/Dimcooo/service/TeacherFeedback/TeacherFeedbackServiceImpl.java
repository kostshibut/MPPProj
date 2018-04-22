package com.Dimcooo.service.TeacherFeedback;

import com.Dimcooo.dao.TeacherFeedback.TeacherFeedbackDAO;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Teacher;
import com.Dimcooo.model.TeacherFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherFeedbackServiceImpl implements TeacherFeedbackService {
    @Autowired
    private TeacherFeedbackDAO teacherFeedbackDAO;

    @Override
    public TeacherFeedback AddTeacherFeedback(TeacherFeedback teacherFeedback, Teacher teacher, Scholar scholar) {
        try {
            teacherFeedback.setScholarByScholarScholarId(scholar);
            teacherFeedback.setTeacherByTeacherTeacherId(teacher);
            return teacherFeedbackDAO.AddTeacherFeedbackToTable(teacherFeedback);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
