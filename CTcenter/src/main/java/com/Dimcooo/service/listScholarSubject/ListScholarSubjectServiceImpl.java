package com.Dimcooo.service.listScholarSubject;

import com.Dimcooo.dao.listScholarSubject.ListScholarSubjectDAO;
import com.Dimcooo.model.ListScholarSubject;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListScholarSubjectServiceImpl implements ListScholarSubjectService {
    @Autowired
    ListScholarSubjectDAO scholarSubjectDAO;

    @Override
    public ListScholarSubject EnrollScholarToSubject(Scholar scholar, Subject subject) {
        return scholarSubjectDAO.AddToListSnS(scholar, subject);
    }
}
