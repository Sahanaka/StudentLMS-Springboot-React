package com.example.studentlms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class StudentLMSApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentLMSApplication.class, args);
		System.out.println("SERVER IS RUNNING");
	}

}
