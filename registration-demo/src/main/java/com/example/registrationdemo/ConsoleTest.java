//package com.example.registrationdemo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Scanner;
//@Component
//// Test class using SpringBoot's CommandLineRunner
//// User prompted to enter User, Password, and Email, this will then be pushed to MySql
//
//public class ConsoleTest implements CommandLineRunner{
//
//    @Autowired
//    private userService userService;
//
//    @Override
//    public void run(String... args) {
//        Scanner scanner = new Scanner(System.in);
//        // User prompted for User, Pass, Email. Authentication will have to be added
//        System.out.println("Welcome to User Registration");
//        System.out.println("Enter your Username: ");
//        String userName = scanner.nextLine();
//        // Definitely need to add password specification as well as a field to confirm the first is correct
//        System.out.println("Enter your password: ");
//        String password = scanner.nextLine();
//
//        System.out.println("Enter your email: ");
//        String email = scanner.nextLine();
//
//        scanner.close();
//
//        User registeredUser = userService.userRegistration(userName, password, email);
//        System.out.println("User successfully registered, your ID is: " + registeredUser.getId());
//        System.out.println("Thank you, " + registeredUser.getUserName());
//
////        String userName = "jordan";
////        String password = "1234";
////        String email = "jordan@email.com";
////
////        User registeredUser = userService.userRegistration(userName,password,email);
//
//    }
//}


// NO LONGER BEING USED, ONLY USEFUL WITH LOCAL DATABASE AND HIBERNATE/PERSISTENCE
