package com.example.entity;

import java.util.Date;
import java.util.Set;

public class Patient {
    private Long id;
    private String cf;
    private String name;
    private String surname;
    private Date birthday;
    private Date registrationDate;
    private Set<Triage> triages;

    public Patient() {
    }

    public Patient(String cf, String name, String surname, Date birthday, Date registrationDate) {
        this.cf = cf;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.registrationDate = registrationDate;
    }

    public Patient(Long id, String cf, String name, String surname, Date birthday, Date registrationDate) {
        this.id = id;
        this.cf = cf;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Triage> getTriages() {
        return triages;
    }

    public void setTriages(Set<Triage> triages) {
        this.triages = triages;
    }

}

