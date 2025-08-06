package com.example.ormlearn;

import com.example.ormlearn.model.Attempt;
import com.example.ormlearn.repository.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    @Autowired
    private AttemptRepository attemptRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(String... args) {
        Integer userId = 1;
        Integer attemptId = 1;

        try {
            Attempt attempt = attemptRepository.getAttempt(userId, attemptId);
            System.out.println("Attempt ID: " + attempt.getId());
            System.out.println("User: " + attempt.getUser().getName());
            System.out.println("Total Questions: " + attempt.getAttemptQuestions().size());
        } catch (Exception e) {
            System.err.println("Error fetching attempt: " + e.getMessage());
            e.printStackTrace();
        }
    }
}