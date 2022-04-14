package com.example.dao;


import com.example.entity.Triage;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TriageDAO {
    public void addTriage(Triage triage) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(triage);
        tx.commit();
        session.close();
    }


}
