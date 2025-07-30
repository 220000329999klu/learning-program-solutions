package org.example;

import org.example.library.LibraryManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        LibraryManager libraryManager = context.getBean(LibraryManager.class);

        libraryManager.manageLibrary();
    }
}