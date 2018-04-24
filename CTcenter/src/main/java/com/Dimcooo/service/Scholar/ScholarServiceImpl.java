package com.Dimcooo.service.Scholar;

import com.Dimcooo.dao.Scholar.ScholarDAO;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScholarServiceImpl implements ScholarService {
    @Autowired
    private ScholarDAO scholarDAO;

    @Override
    public Boolean DeleteScholar(Scholar scholar) {
        try {
            return scholarDAO.DeleteScholar(scholar);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Scholar> GetAllScholars() {
        try {
            return scholarDAO.GetAllDataFromTable();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

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
    public User FindUserByScholar(Scholar scholar) {
        try {
            return scholarDAO.FindUserInfoByScholarId(scholar.getScholarId());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public User FindUserByScholar(int scholarId) {
        try {
            return scholarDAO.FindUserInfoByScholarId(scholarId);
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

    @Override
    public Scholar FindScholarById(int id) {
        try {
            return scholarDAO.FindScholarByScholarId(id);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}