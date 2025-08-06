package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Arman";
        int items = 5;

        logger.info("User {} added {} items to the cart", user, items);
        logger.debug("Debugging session started for user: {}", user);
        logger.warn("Cart size limit is almost reached for user: {}", user);
    }
}