package com.example.registrationdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
// Main class that will execute application

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@ComponentScan(basePackages = "com.example.registrationdemo.repository")

public class RegistrationDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistrationDemoApplication.class, args);

	}
}

