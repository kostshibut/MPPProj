package com.Dimcooo.dao;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;

public interface ScholarDAO {
    Scholar AddScholar(User user);
    User FindScholarInfo(int id);
}
