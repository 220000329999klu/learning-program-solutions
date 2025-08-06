package com.com.cognizant.spring_learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cognizant.springlearn")
public class AppConfig {

    @Bean
    public DateDisplayService dateDisplayService() {
        return new DateDisplayService();
    }
}