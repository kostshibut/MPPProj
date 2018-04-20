package com.Dimcooo.dao.listScholarSubject;

import com.Dimcooo.model.ListScholarSubject;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Subject;

import java.util.List;

public interface ListScholarSubjectDAO {
    ListScholarSubject AddToListSnS(Scholar scholar, Subject subject);
    List<ListScholarSubject> GetAllDataFromTable();
}
