package com.example.ormlearn;

import com.example.ormlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {


        double avgAll = employeeService.getAverageSalary();
        System.out.println("Overall Average Salary: " + avgAll);


        int deptId = 1;
        double avgDept = employeeService.getAverageSalaryByDeptId(deptId);
        System.out.println("Average Salary for Department ID " + deptId + ": " + avgDept);
    }
}