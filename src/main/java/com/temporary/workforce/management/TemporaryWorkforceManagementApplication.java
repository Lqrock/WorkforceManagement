package com.temporary.workforce.management;

import controller.AccommodationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import service.AccommodationService;

@SpringBootApplication
@ComponentScan
public class TemporaryWorkforceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemporaryWorkforceManagementApplication.class, args);
	}

}
