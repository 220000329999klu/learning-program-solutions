package com.example.ormlearn.model;

import com.example.ormlearn.model.AttemptQuestion;
import jakarta.persistence.*;

import javax.swing.text.html.Option;

@Entity
@Table(name="attempt_option")
public class AttemptOption {
    @Id
    @GeneratedValue
    private Integer id;
    private Boolean selected;

    @ManyToOne
    @JoinColumn(name="attempt_question_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name="option_id")
    private Option option;
    // getters & setters
}