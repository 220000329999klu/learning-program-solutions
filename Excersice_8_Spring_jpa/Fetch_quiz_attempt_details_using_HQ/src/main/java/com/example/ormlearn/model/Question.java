package com.example.ormlearn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import javax.swing.text.html.Option;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Integer id;
    private String text;
    private Double score;

    @OneToMany(mappedBy="question")
    private List<Option> options;
    // getters & setters
}