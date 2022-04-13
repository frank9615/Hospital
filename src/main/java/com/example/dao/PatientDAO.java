package com.example.dao;

import com.example.entity.Patient;
import com.example.entity.User;
import com.example.model.Role;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PatientDAO {
    public void addPatient(Patient patient) {
        try{
            //1. Configure Hibernate
            Configuration configuration = new Configuration().configure();
            //2. Create a session factory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            //3. Create a session
            Session session = sessionFactory.openSession();
            //4. Starting a transaction
            Transaction transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }
    }

}
