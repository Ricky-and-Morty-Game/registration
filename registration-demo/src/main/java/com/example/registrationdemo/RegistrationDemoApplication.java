package com.example.registrationdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// Main class that will execute application
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RegistrationDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistrationDemoApplication.class, args);
	}
}
