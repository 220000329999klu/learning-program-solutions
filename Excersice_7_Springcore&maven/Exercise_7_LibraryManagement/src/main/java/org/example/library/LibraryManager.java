package org.example.library;

import org.example.service.BookService;

public class LibraryManager {
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void manageLibrary() {
        bookService.issueBook("Effective Java");
        bookService.returnBook("Effective Java");
    }
}