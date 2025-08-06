package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message logged to both console and file");
        logger.info("Info message logged to both console and file");
        logger.error("Error message logged to both console and file");
    }
}