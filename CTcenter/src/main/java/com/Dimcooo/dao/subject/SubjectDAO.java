package com.Dimcooo.dao.subject;

import com.Dimcooo.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SubjectDAO {
    List<Subject> GetDataFromSubjectTable();
}
