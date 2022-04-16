package com.example.dao;

import com.example.entity.Doctor;
import com.example.entity.Operator;
import com.example.entity.Triage;
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

    public User getUser(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        User user = (User) session.get(User.class, id);
        tx.commit();
        session.close();
        return user;
    }

    public Doctor getDoctor(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Doctor doctor = (Doctor) session.get(Doctor.class, id);
        tx.commit();
        Hibernate.initialize(doctor.getTriages());
        session.close();
        return doctor;
    }

    public Operator getOperator(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Operator operator = (Operator) session.get(Doctor.class, id);
        tx.commit();
        session.close();
        return operator;
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
