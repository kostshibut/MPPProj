package com.Dimcooo.service.listScholarSubject;

import com.Dimcooo.dao.listScholarSubject.ListScholarSubjectDAO;
import com.Dimcooo.model.ListScholarSubject;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListScholarSubjectServiceImpl implements ListScholarSubjectService {
    @Autowired
    ListScholarSubjectDAO scholarSubjectDAO;

    @Override
    public ListScholarSubject EnrollScholarToSubject(Scholar scholar, Subject subject) {
        try {
            return scholarSubjectDAO.AddToListSnS(scholar, subject);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ListScholarSubject> GetAllScholars() {
        try {
            return scholarSubjectDAO.GetAllDataFromTable();
        }
        catch (Exception ex){
            System.out.println("Error in getting data");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ListScholarSubject> GetScholarSubject(Scholar scholar) {
        try {
            return scholarSubjectDAO.GetAllScholarSubjects(scholar.getScholarId());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
