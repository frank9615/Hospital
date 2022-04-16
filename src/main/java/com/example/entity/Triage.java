package com.example.entity;

import com.example.model.TriageColor;

import java.util.Date;

public class Triage {
    private Long id;
    private TriageColor triageColor;
    private String notes;
    private Date triageDate;
    private Patient patient;
    private Doctor doctor;
    private Operator operator;

    public Triage() {
    }

    public Triage( Patient patient, TriageColor triageColor, String notes, Date triageDate, Doctor doctorAssigned, Operator operator) {
        this.patient = patient;
        this.triageColor = triageColor;
        this.notes = notes;
        this.triageDate = triageDate;
        this.doctor = doctorAssigned;
        this.operator = operator;
    }

    public Triage(Long id, Patient patient, TriageColor triageColor, String notes, Date triageDate, Doctor doctorAssigned, Operator operator) {
        this.id = id;
        this.patient = patient;
        this.triageColor = triageColor;
        this.notes = notes;
        this.triageDate = triageDate;
        this.doctor = doctorAssigned;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public TriageColor getTriageColor() {
        return triageColor;
    }

    public void setTriageColor(TriageColor triageColor) {
        this.triageColor = triageColor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getTriageDate() {
        return triageDate;
    }

    public void setTriageDate(Date triageDate) {
        this.triageDate = triageDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Triage{" +
                "id=" + id +
                ", patient=" + patient +
                ", triageColor=" + triageColor +
                ", notes='" + notes + '\'' +
                ", triageDate=" + triageDate +
                ", doctorId=" + doctor +
                ", operatorId=" + operator +
                '}';
    }
}



