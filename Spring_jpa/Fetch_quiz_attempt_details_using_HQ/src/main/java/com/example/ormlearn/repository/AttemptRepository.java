package com.example.ormlearn.repository;

import com.example.ormlearn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    @Query("""
      SELECT a FROM Attempt a
      JOIN FETCH a.user u
      JOIN FETCH a.attemptQuestions aq
      JOIN FETCH aq.question q
      JOIN FETCH q.options opt
      JOIN FETCH aq.attemptOptions ao
      JOIN FETCH ao.option o
      WHERE u.id = :userId AND a.id = :attemptId
    """)
    Attempt getAttempt(@Param("userId") Integer userId, @Param("attemptId") Integer attemptId);
}