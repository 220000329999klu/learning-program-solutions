package org.example;

import org.example.library.LibraryManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        LibraryManager manager = context.getBean(LibraryManager.class);
        manager.manageLibrary();
    }
}