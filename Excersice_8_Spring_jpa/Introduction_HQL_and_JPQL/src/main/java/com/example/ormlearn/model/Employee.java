package com.example.ormlearn.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "employee_skill",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skillList;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }
}