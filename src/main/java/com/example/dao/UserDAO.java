package com.example.dao;

import com.example.entity.User;
import com.example.model.Role;
import com.example.util.HibernateUtil;
import org.hibernate.*;
import java.util.List;

public class UserDAO {
    public void addUser(User user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }


    public User getUser(String username, String password) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "from User where username = :username and password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        tx.commit();
        session.close();
        return  user;
    }

    public List<User> getDoctors() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "from User where role = :role";
        Query query = session.createQuery(hql);
        query.setParameter("role", Role.DOCTOR);
        List<User> users = (List<User>) query.list();
        tx.commit();
        session.close();
        return users;
    }

}
