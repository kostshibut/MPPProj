package com.Dimcooo.dao.Scholar;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;

import java.util.List;

public interface ScholarDAO {
    List<Scholar> GetAllDataFromTable();
    Scholar AddScholar(User user);
    User FindUserInfoByScholarId(int id);
    Scholar FindScholarByUserId(int id);
    Scholar FindScholarByScholarId(int id);
    Boolean DeleteScholar(Scholar scholar);
}
