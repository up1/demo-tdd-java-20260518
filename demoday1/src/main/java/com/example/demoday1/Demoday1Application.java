package com.example.demoday1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demoday1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(Demoday1Application.class, args);
		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println(bean);
		}
		System.out.println(context.getBeanDefinitionCount());
	}

}
