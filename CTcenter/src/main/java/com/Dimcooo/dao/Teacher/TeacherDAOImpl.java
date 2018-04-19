package com.Dimcooo.dao.Teacher;

import com.Dimcooo.model.Teacher;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
    private Session session;

    @Override
    public List<Teacher> GetDataFromTeacherTable() {
        return null;
    }
}
