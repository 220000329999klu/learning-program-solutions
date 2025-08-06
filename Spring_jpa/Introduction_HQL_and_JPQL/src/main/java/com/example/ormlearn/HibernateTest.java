package com.example.ormlearn;

import com.example.ormlearn.model.Employee;
import com.example.ormlearn.model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure(); // reads hibernate.cfg.xml
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Employee emp = session.get(Employee.class, 1);
        System.out.println("Employee: " + emp.getName());
        System.out.println("Skills:");
        for (Skill skill : emp.getSkillList()) {
            System.out.println(" - " + skill.getName());
        }

        session.close();
        factory.close();
    }
}