package com.example.ormlearn.model;

import jakarta.persistence.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;

@Entity
@Table(name="attempt_question")
public class AttemptQuestion {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name="attempt_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name="question_id")
    private TypePatternQuestions.Question question;

    @OneToMany(mappedBy="attemptQuestion", cascade=CascadeType.ALL)
    private List<AttemptOption> attemptOptions;
    // getters & setters
}