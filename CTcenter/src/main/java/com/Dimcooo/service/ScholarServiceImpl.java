package com.Dimcooo.service;

import com.Dimcooo.dao.ScholarDAO;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScholarServiceImpl implements ScholarService{
    @Autowired
    ScholarDAO scholarDAO;

    @Override
    public Scholar AddScholar(User user) {
        return scholarDAO.AddScholar(user);
    }

    @Override
    public User FindScholarInfo(Scholar scholar) {
        return scholarDAO.FindScholarInfo(scholar);
    }
}
