package com.cognizant.spring_learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {
	public static void main(String[] args) {
		System.out.println("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("country");
		System.out.println(country); // This line prints the bean

		System.out.println("END");
	}
}