package com.example.entity;

import com.example.model.TriageColor;

import java.util.Date;

public class Triage {
    private Integer id;
    private Integer patientId;
    private TriageColor triageColor;
    private String notes;
    private Date triageDate;
    private Integer doctorAssignedId;
    private Integer operatorId;

    public Triage() {
    }

    public Triage(Integer id, Integer patientId, TriageColor triageColor, String notes, Date triageDate, Integer doctorAssignedId, Integer operatorId) {
        this.id = id;
        this.patientId = patientId;
        this.triageColor = triageColor;
        this.notes = notes;
        this.triageDate = triageDate;
        this.doctorAssignedId = doctorAssignedId;
        this.operatorId = operatorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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

    public Integer getDoctorAssignedId() {
        return doctorAssignedId;
    }

    public void setDoctorAssignedId(Integer doctorAssignedId) {
        this.doctorAssignedId = doctorAssignedId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}



