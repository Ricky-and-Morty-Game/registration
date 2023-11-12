package com.example.registrationdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//Security Configuration - Users will be directed to registration page upon arrival at site
@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Password encryption
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/register").permitAll()
                        .anyRequest().authenticated())
                        // Allow access to home and root pages
                        //.anyRequest().authenticated())  Anything else requires authentication
                .formLogin((form) -> form
                        .loginPage("/login.html")
                        .permitAll()// Specifies the login page
                )
                .logout((logout) -> logout
                        .permitAll()); // Allows access to logout
        return http.build();
    }
    // Password encoding, for user security/encryption

}