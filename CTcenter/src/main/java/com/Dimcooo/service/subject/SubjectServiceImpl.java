package com.Dimcooo.service.subject;

import com.Dimcooo.dao.subject.SubjectDAO;
import com.Dimcooo.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private SubjectDAO subjectDAO;

    @Override
    public List<Subject> GetListOfSubjects() {
        try {
            return subjectDAO.GetDataFromSubjectTable();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Subject FindSubjectInfo(int id) {
        try {
            return subjectDAO.FindSubjectById(id);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean DeleteSubject(Subject subject) {
        try {
            return subjectDAO.DeleteSubject(subject);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Subject SaveSubject(String subjectName, Integer subjectDuration, int teacherId) {
        try {
            Subject subject = new Subject();
            subject.setName(subjectName);
            subject.setDuration(subjectDuration);
            subject.setTeacherTeacherId(teacherId);
            subjectDAO.AddSubject(subject);
            Subject subjectByName = subjectDAO.FindSubjectByName(subject.getName());
            return subjectByName;
        }
        catch (Exception ex){
            return null;
        }
    }
}
