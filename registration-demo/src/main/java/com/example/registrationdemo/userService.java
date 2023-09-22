package com.example.registrationdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class userService {
// Service class, @Autowired works to connect all of our @annotated statements
// throughout our code. It works as a Dependency Injector
    @Autowired
    private userRepo userRepo;

    public User userRegistration (String userName, String password, String email) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        return userRepo.save(user);
        // Method that will push information to our DB
    }
}
