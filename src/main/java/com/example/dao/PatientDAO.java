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

    public Patient getPatient(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Patient patient = (Patient) session.get(Patient.class, id);
        tx.commit();
        session.close();
        return patient;
    }

    public void updatePatient(Patient patient) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.update(patient);
        tx.commit();
        session.close();
    }

    public void deletePatient(Patient patient) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(patient);
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
    public List<Patient> getPatients(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Patient";
        Query query = session.createQuery(hql);
        List<Patient> patients = query.list();
        tx.commit();
        session.close();
        return patients;
    }
}
