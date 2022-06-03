package com.example.studentlms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class StudentlmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentlmsApplication.class, args);
		System.out.println("SERVER IS RUNNING");
	}

}
