package com.Dimcooo.service.listScholarSubject;

import com.Dimcooo.model.ListScholarSubject;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Subject;

import java.util.List;

public interface ListScholarSubjectService {
    ListScholarSubject EnrollScholarToSubject(Scholar scholar, Subject subject);
    List<ListScholarSubject> GetAllScholars();
    List<ListScholarSubject> GetScholarSubject(Scholar scholar);
}
