package com.Dimcooo.service.subject;

import com.Dimcooo.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> GetListOfSubjects();
    Subject FindSubjectInfo(int Id);
    boolean DeleteSubject(Subject subject);
    Subject SaveSubject(String subjectName, Integer subjectDuration, int teacherId);
}
