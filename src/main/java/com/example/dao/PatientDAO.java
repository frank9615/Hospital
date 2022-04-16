package com.example.dao;

import com.example.entity.Patient;
import com.example.util.HibernateUtil;
import org.hibernate.*;

import java.util.List;

public class PatientDAO {

    public void addPatient(Patient patient) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(patient);
        tx.commit();
        session.close();
    }

    public Patient getPatient(String cf) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Patient where cf = :cf";
        Query query = session.createQuery(hql);
        query.setParameter("cf", cf);
        Patient patient = (Patient) query.uniqueResult();
        tx.commit();
        session.close();
        return patient;
    }

}
