package com.Dimcooo.service.Scholar;

import com.Dimcooo.dao.Scholar.ScholarDAO;
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
        return scholarDAO.FindScholarById(scholar.getScholarId());
    }

    @Override
    public Scholar FindScholarByUser(User user) {
        return scholarDAO.FindScholarByUserId(user.getUserId());
    }
}
