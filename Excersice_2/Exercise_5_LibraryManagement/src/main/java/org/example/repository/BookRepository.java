package org.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void save(String name) {
        System.out.println("Saving book to DB: " + name);
    }
}