package com.Dimcooo;

import com.Dimcooo.dao.listScholarSubject.ListScholarSubjectDAOImpl;

public class Main {

    public static void main(String args[]){
        try {
            ListScholarSubjectDAOImpl scholarSubjectDAO = new ListScholarSubjectDAOImpl();
            System.out.println(scholarSubjectDAO.GetAllScholarSubjects(23));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
