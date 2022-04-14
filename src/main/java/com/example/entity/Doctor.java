package com.example.entity;

import com.example.model.Role;

import java.util.List;

public class Doctor extends User{
        private List<Patient> patients;

        public Doctor() {
        }

        public Doctor(Long id, String name, String surname, String username, String password, Role role,  List<Patient> patients) {
                super(id,name, surname, username, password, role);
                this.patients = patients;
        }

        public List<Patient> getPatients() {
                return patients;
        }

        public void setPatients(List<Patient> patients) {
                this.patients = patients;
        }
}
