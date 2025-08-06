package com.example.ormlearn;

import com.example.ormlearn.entity.Employee;
import com.example.ormlearn.entity.Skill;
import com.example.ormlearn.service.EmployeeService;
import com.example.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // testGetEmployee();
        testAddSkillToEmployee(); // Uncomment this
    }

    public void testGetEmployee() {
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee.getName());
        LOGGER.debug("Skills: {}", employee.getSkillList()); // This will cause LazyInitializationException if FetchType is LAZY
    }

    public void testAddSkillToEmployee() {
        Employee employee = employeeService.get(1);
        Skill skill = skillService.get(2); // Assuming ID 2 exists and not already mapped

        Set<Skill> skillList = employee.getSkillList();
        skillList.add(skill);

        employee.setSkillList(skillList);
        employeeService.save(employee);

        LOGGER.info("Skill added to employee successfully!");
    }
}