package com.Dimcooo.service.Scholar;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;

import java.util.List;

public interface ScholarService {
    Boolean DeleteScholar(Scholar scholar);
    List<Scholar> GetAllScholars();
    Scholar AddScholar(User user);
    User FindScholarInfo(Scholar scholar);
    Scholar FindScholarByUser(User user);
    Scholar FindScholarById(int id);
}
