package com.Dimcooo.service.TeacherFeedback;

import com.Dimcooo.dao.TeacherFeedback.TeacherFeedbackDAO;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Teacher;
import com.Dimcooo.model.TeacherFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<TeacherFeedback> GetScholarFeedback(Scholar scholar) {
        try{
            return teacherFeedbackDAO.GetAllScholarFeedback(scholar.getScholarId());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<TeacherFeedback> GetTeacherFeedback(Teacher teacher) {
        try{
            return teacherFeedbackDAO.GetAllTeacherFeedback(teacher.getTeacherId());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<TeacherFeedback> GetTeacherFeedback(int teacherId) {
        try{
            return teacherFeedbackDAO.GetAllTeacherFeedback(teacherId);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}