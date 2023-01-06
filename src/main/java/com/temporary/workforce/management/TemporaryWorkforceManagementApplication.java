package com.temporary.workforce.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.temporary.workforce.management.*"})
public class TemporaryWorkforceManagementApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TemporaryWorkforceManagementApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(TemporaryWorkforceManagementApplication.class, args);
	}

}
