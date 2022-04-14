package com.example.entity;

import com.example.model.Role;
import java.util.Set;

public class Doctor extends User{
        private Set<Triage> triages;

        public Doctor() {
        }

        public Doctor(Long id, String name, String surname, String username, String password, Role role,  Set<Triage> triages) {
                super(id,name, surname, username, password, role);
                this.triages = triages;
        }

        public Set<Triage> getTriages() {
                return triages;
        }

        public void setTriages(Set<Triage> triages) {
                this.triages = triages;
        }
}
