package com.Dimcooo.service.Scholar;

import com.Dimcooo.dao.Scholar.ScholarDAO;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScholarServiceImpl implements ScholarService{
    @Autowired
    private ScholarDAO scholarDAO;

    @Override
    public Scholar AddScholar(User user) {
        try {
            return scholarDAO.AddScholar(user);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public User FindScholarInfo(Scholar scholar) {
        try {
            return scholarDAO.FindScholarById(scholar.getScholarId());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Scholar FindScholarByUser(User user) {
        try {
            return scholarDAO.FindScholarByUserId(user.getUserId());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}