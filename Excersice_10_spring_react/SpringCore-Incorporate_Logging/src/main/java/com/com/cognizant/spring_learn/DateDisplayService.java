package com.com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDisplayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateDisplayService.class);

    public void displayDate() {
        LOGGER.info("START");

        String dateStr = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        LOGGER.debug(dateStr);

        LOGGER.info("END");
    }
}