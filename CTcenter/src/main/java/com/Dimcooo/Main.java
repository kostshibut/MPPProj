package com.Dimcooo;

import com.Dimcooo.model.Admin;
import com.Dimcooo.model.LoginUser;
import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.User;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {
    public static void main(String args[]){
        try {
            System.out.println("start");
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            User loginUser = new User();
            loginUser.setLogin("dimco");

            Criteria criteria = session.createCriteria(User.class);
            User user = (User)(criteria.add(Restrictions.eq("login", loginUser.getLogin())).uniqueResult());

            System.out.println(user.getLogin() + " " + user.getFirstName());

            session.getTransaction().commit();

            session.getSessionFactory().close();

            System.out.println("done");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
