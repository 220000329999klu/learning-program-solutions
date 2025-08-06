package com.example.orm;

import com.example.orm.hibernate.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Configure session
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Create employee
        Employee emp = new Employee();
        emp.setName("Arman Khan");
        emp.setSalary(75000.0);
        session.save(emp);

        // Fetch all employees
        List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
        for (Employee e : employees) {
            System.out.println(e);
        }

        // Commit and close
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}