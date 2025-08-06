package com.example.ormlearn.service;

import com.example.ormlearn.model.Attempt;
import com.example.ormlearn.repository.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {
    @Autowired
    private AttemptRepository repo;

    public Attempt getAttempt(Integer userId, Integer attemptId) {
        return repo.getAttempt(userId, attemptId);
    }
}