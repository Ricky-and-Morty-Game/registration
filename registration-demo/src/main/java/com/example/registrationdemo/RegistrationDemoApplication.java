package com.example.registrationdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


// Main class that will execute application

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

public class RegistrationDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistrationDemoApplication.class, args);

	}
}

