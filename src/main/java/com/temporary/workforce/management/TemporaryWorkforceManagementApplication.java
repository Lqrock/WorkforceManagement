package com.temporary.workforce.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.ParseException;

@SpringBootApplication
@ComponentScan({"com.temporary.workforce.management.*"})
public class TemporaryWorkforceManagementApplication{
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(TemporaryWorkforceManagementApplication.class, args);

	}
}
