package com.example.ormlearn;


import com.example.ormlearn.entity.Product;
import com.example.ormlearn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> results = productService.searchProducts("Windows", 16.0, 2.5, "Intel i7", 2.0, 4);
        results.forEach(System.out::println);
    }
}