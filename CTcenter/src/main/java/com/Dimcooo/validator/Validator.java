package com.Dimcooo.validator;

import com.Dimcooo.dao.User.UserDAOImpl;
import com.Dimcooo.dao.subject.SubjectDAOImpl;
import com.Dimcooo.model.*;
import com.Dimcooo.util.Encryptor;
import com.sun.org.apache.xpath.internal.axes.IteratorPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Validator {
    public static boolean AutentificationSignIn(User user, LoginUser loginUser) {
        try {
            if (user != null && user.getLogin().equals(loginUser.getLogin()) &&
                    user.getPassword().equals(Encryptor.EncryptString(loginUser.getPass()))) {
                return true;
            } else {
                return false;
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean FindSimilarLogins(String registerLogin){
        UserDAOImpl userDAO = new UserDAOImpl();
        if(userDAO.FindUserByLogin(registerLogin) != null){
            return false;
        }
        else {
            return true;
        }
    }

    public static List<Subject> ShowUnSignedSubjects(Scholar scholar,
                                                     List<Subject> subjectList,
                                                     List<ListScholarSubject> ScholarSubjectsList) {
        Iterator listSubject = null;
        Iterator listScholarSubjects = ScholarSubjectsList.iterator();

            while (listScholarSubjects.hasNext()) {
                ListScholarSubject scholarSubject = (ListScholarSubject) listScholarSubjects.next();
                if (scholar.getScholarId() == scholarSubject.getScholarScholarId()) {
                    listSubject = subjectList.iterator();
                    while (listSubject.hasNext()) {
                        Subject subject = (Subject) listSubject.next();
                        if (subject.getSubjectId() == scholarSubject.getSubjectSubjectId()) {
                            listSubject.remove();
                        }
                    }
                    listSubject = null;
                }
            }
        return subjectList;
    }

    public static List<Subject> ShowSignedList(List<ListScholarSubject> scholarSubjectList){
        Iterator listSchSubIterator = scholarSubjectList.iterator();
        ArrayList<Subject> subbedSubjectList = new ArrayList<Subject>();
        ListScholarSubject scholarSubject = null;
        SubjectDAOImpl subjectDAO = new SubjectDAOImpl();

        while (listSchSubIterator.hasNext()){
            scholarSubject = (ListScholarSubject)listSchSubIterator.next();
            subbedSubjectList.add(subjectDAO.FindSubjectById(scholarSubject.getSubjectSubjectId()));
        }

        return subbedSubjectList;
    }
}
