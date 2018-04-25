package com.Dimcooo.dao.subject;

import com.Dimcooo.model.Subject;

import java.util.List;

public interface SubjectDAO {
    List<Subject> GetDataFromSubjectTable();
    Subject FindSubjectById(int id);
    boolean DeleteSubject(Subject subject);
    Subject AddSubject(Subject subject);
    Subject FindSubjectByName(String name);
}
