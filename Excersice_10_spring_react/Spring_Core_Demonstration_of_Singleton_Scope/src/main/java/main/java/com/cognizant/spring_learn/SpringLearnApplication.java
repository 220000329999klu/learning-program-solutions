package main.java.com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		displayCountry();
	}

	public static void displayCountry() {
		LOGGER.info("START - displayCountry");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country1 = (Country) context.getBean("country");
		Country country2 = (Country) context.getBean("country");

		System.out.println("Country 1: " + country1);
		System.out.println("Country 2: " + country2);

		LOGGER.info("END - displayCountry");
		context.close();
	}
}