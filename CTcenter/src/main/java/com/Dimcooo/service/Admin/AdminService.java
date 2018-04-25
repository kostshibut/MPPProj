package com.Dimcooo.service.Admin;

import com.Dimcooo.model.Admin;
import com.Dimcooo.model.User;

public interface AdminService {
    Admin FindAdminByUser(User user);
}
