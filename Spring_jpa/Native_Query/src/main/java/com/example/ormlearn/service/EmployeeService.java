package com.example.ormlearn.service;

import com.example.ormlearn.entity.Employee;
import com.example.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeesUsingNativeQuery() {
        return employeeRepository.getAllEmployeesNative();
    }
}