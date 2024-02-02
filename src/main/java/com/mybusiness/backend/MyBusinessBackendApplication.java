package com.mybusiness.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBusinessBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBusinessBackendApplication.class, args);
		System.out.println("Welcome to my business");
	}

}
