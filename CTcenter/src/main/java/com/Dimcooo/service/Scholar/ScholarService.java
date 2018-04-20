package com.Dimcooo.service.Scholar;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;

public interface ScholarService {
    Scholar AddScholar(User user);
    User FindScholarInfo(Scholar scholar);
    Scholar FindScholarByUser(User user);
}
