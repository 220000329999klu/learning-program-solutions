package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    public void issueBook(String name) throws InterruptedException {
        Thread.sleep(400); // simulate time delay
        System.out.println("📚 Issued: " + name);
    }

    public void returnBook(String name) throws InterruptedException {
        Thread.sleep(300);
        System.out.println("📖 Returned: " + name);
    }
}