package com.temporary.workforce.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@SpringBootApplication
@ComponentScan({"com.temporary.workforce.management.*"})
public class TemporaryWorkforceManagementApplication{
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(TemporaryWorkforceManagementApplication.class, args);
	}
}
