package com.example.dao;


import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Triage;
import com.example.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class TriageDAO {
    public void addTriage(Triage triage) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(triage);
        tx.commit();
        session.close();
    }
    public Triage getTriage(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Triage triage = (Triage) session.get(Triage.class, id);
        tx.commit();
        Hibernate.initialize(triage.getPatient());
        session.close();
        return triage;
    }




}
