package com.Dimcooo.service.Admin;

import com.Dimcooo.dao.Admin.AdminDAO;
import com.Dimcooo.model.Admin;
import com.Dimcooo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Admin FindAdminByUser(User user) {
        try {
            return adminDAO.FindAdminByUserId(user.getUserId());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
