package org.example.service;

import org.example.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String repoName;

    // ✅ Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Constructor Injection Done");
    }

    // ✅ Setter Injection
    public void setRepoName(String repoName) {
        this.repoName = repoName;
        System.out.println("Setter Injection Done: " + repoName);
    }

    public void issueBook(String title) {
        System.out.println("Issuing: " + title + " using " + repoName);
        bookRepository.save(title);
    }

    public void returnBook(String title) {
        System.out.println("Returning: " + title);
    }
}