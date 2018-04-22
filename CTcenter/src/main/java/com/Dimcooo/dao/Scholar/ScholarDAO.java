package com.Dimcooo.dao.Scholar;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;

public interface ScholarDAO {
    Scholar AddScholar(User user);
    User FindScholarById(int id);
    Scholar FindScholarByUserId(int id);
    Scholar FindScholarByScholarId(int id);
}
