package com.example.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name="options")
public class Option {
    @Id
    @GeneratedValue
    private Integer id;
    private String text;
    private Boolean isCorrect;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;
    // getters & setters
}