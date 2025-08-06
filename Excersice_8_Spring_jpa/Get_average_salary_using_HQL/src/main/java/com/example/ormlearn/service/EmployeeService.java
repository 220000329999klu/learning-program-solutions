package com.example.ormlearn.service;

import com.example.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Overall average salary
    public double getAverageSalary() {
        return employeeRepository.getAverageSalary();
    }

    // Department-specific average salary
    public double getAverageSalaryByDeptId(int deptId) {
        return employeeRepository.getAverageSalary(deptId);
    }
}