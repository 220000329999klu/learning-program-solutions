package org.example.repository;

public class BookRepository {
    public void save(String book) {
        System.out.println("Saving book to DB: " + book);
    }
}