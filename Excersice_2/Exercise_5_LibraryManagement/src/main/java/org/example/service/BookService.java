package org.example.service;

import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void issueBook(String title) {
        System.out.println("Issuing: " + title);
        bookRepository.save(title);
    }

    public void returnBook(String title) {
        System.out.println("Returning: " + title);
    }
}