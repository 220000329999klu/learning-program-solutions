package com.com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.text.ParseException;

public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		LOGGER.info("START MAIN");

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DateDisplayService service = context.getBean(DateDisplayService.class);
		service.displayDate();

		LOGGER.info("END MAIN");
	}
}