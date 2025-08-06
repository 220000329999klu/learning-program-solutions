package com.example.ormlearn;

import com.example.ormlearn.model.Department;
import com.example.ormlearn.model.Employee;
import com.example.ormlearn.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetDepartment();
    }

    private void testGetDepartment() {
        Department department = departmentService.get(1);
        System.out.println("Department: " + department);
        System.out.println("Employee List: " + department.getEmployeeList());
    }
}