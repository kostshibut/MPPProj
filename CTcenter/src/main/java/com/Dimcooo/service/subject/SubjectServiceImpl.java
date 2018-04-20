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
        return subjectDAO.GetDataFromSubjectTable();
    }

    @Override
    public Subject FindSubjectInfo(int id) {
        return subjectDAO.FindSubjectById(id);
    }
}
