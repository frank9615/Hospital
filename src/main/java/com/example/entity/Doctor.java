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

        @Override
        public String toString() {
                return "Doctor{" + "id=" + super.getId() + ", name=" + super.getName() + ", surname=" + super.getSurname() + ", username=" + super.getUsername() + ", password=" + super.getPassword() + ", role=" + super.getRole() + '}';
        }
}
