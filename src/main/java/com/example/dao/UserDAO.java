package com.example.dao;

import com.example.entity.User;
import com.example.model.Role;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class UserDAO {
    public void addUser(User user) {
        try{
            //1. Configure Hibernate
            Configuration configuration = new Configuration().configure();
            //2. Create a session factory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            //3. Create a session
            Session session = sessionFactory.openSession();
            //4. Starting a transaction
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    public User getUser(String username, String password) {
        try{
            //1. Configure Hibernate
            Configuration configuration = new Configuration().configure();
            //2. Create a session factory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            //3. Create a session
            Session session = sessionFactory.openSession();
            //4. Starting a transaction
            Transaction transaction = session.beginTransaction();
            User user = (User) session.get(User.class, username);
            transaction.commit();
            if(user != null && user.getPassword().equals(password)){
                return user;
            }
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
