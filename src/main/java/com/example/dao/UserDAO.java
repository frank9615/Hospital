package com.example.dao;

import com.example.entity.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

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
            String hql = "from User where username = :username and password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("password", password);



             User user = (User) query.uniqueResult();
             System.out.println(user);

            transaction.commit();
            session.close();
            sessionFactory.close();
            return  user;

        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
