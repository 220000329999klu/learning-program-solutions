package org.example.library;

import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryManager {

    @Autowired
    private BookService bookService;

    public void manageLibrary() throws InterruptedException {
        bookService.issueBook("Spring in Action");
        bookService.returnBook("Spring in Action");
    }
}