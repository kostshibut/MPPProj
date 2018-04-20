package com.Dimcooo.service.listScholarSubject;

import com.Dimcooo.model.ListScholarSubject;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Subject;

public interface ListScholarSubjectService {
    ListScholarSubject EnrollScholarToSubject(Scholar scholar, Subject subject);
}
