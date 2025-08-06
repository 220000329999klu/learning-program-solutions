package org.example;

import org.example.IntegrationTestWithSpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest(classes = IntegrationTestWithSpringBootApplication.class)
public class IntegrationTest {

    @Test
    void contextLoads() {
        System.out.println("Integration test passed!");
    }
}