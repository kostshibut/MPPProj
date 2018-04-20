package com.Dimcooo.validator;

import com.Dimcooo.dao.User.UserDAOImpl;
import com.Dimcooo.model.*;
import com.Dimcooo.util.Encryptor;

import java.util.Iterator;
import java.util.List;

public class Validator {
    public static boolean AutentificationSignIn(User user, LoginUser loginUser) {

        if (user != null && user.getLogin().equals(loginUser.getLogin()) &&
                user.getPassword().equals(Encryptor.EncryptString(loginUser.getPass()))) {
            return true;
        }
        else {
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

    public static List<Subject> isScholarGotSubject(Scholar scholar,
                                                    List<Subject> subjectList,
                                                    List<ListScholarSubject> ScholarSubjectsList) {
        Iterator listSubject = subjectList.iterator();
        Iterator listScholarSubjects = ScholarSubjectsList.iterator();

        try {

            while (listScholarSubjects.hasNext()) {
                ListScholarSubject scholarSubject = (ListScholarSubject) listScholarSubjects.next();
                if (scholar.getScholarId() == scholarSubject.getScholarScholarId()) {
                    while (listSubject.hasNext()) {
                        Subject subject = (Subject) listSubject.next();
                        if (subject.getSubjectId() == scholarSubject.getSubjectSubjectId()) {
                            subjectList.remove(subject);
                        }
                    }
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return subjectList;
    }
}
