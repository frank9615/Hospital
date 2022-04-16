package com.example.entity;

import com.example.model.Role;
import java.util.Set;


public class Operator extends User {
    private Set<Triage> triages;

    public Operator() {
    }

    public Operator(Long id, String name, String surname, String username, String password, Role role, Set<Triage> triages) {
        super(id, name, surname, username, password, role);
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
        return "Operator{" + "id=" + getId() + ", name=" + getName() + ", surname=" + getSurname() + ", username=" + getUsername() + ", password=" + getPassword() + ", role=" + getRole() + '}';
    }

}
