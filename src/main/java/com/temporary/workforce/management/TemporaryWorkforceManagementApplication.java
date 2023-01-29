package com.temporary.workforce.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.util.Random;

@SpringBootApplication
@ComponentScan({"com.temporary.workforce.management.*"})
public class TemporaryWorkforceManagementApplication{
	public static void main(String[] args) {
		SpringApplication.run(TemporaryWorkforceManagementApplication.class, args);
	}
}
