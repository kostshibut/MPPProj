package com.Dimcooo.dao.Admin;

import com.Dimcooo.model.Admin;
import com.Dimcooo.util.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO {
    private Session session;

    @Override
    public Admin FindAdminByUserId(int id) {
        try {
            System.out.println("Start finding admin by user id");
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Admin.class);

            Admin admin = (Admin)(criteria.add(Restrictions.eq("userUserId", id)).uniqueResult());

            session.getTransaction().commit();
            System.out.println("Finish finding admin by user id");
            return admin;
        }
        catch (Exception ex){
            System.out.println("Error with finding admin by user id");
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
