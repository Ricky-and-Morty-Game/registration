package com.example.registrationdemo.service;
import com.example.registrationdemo.model.User;
import com.google.firebase.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class userService {
// Service class, @Autowired works to connect all of our @annotated statements
// throughout our code. It works as a Dependency Injector
    @Autowired
    private PasswordEncoder passwordEncoder;
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    public User userRegistration (String userName, String password, String email) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);

        db.child("users").push().setValue(user, new DatabaseReference.CompletionListener() {

            public void onComplete(DatabaseError error, DatabaseReference ref) {
                System.err.println("Value was set, Error: " + error);
            }
        });
        return user;
        // Method that will push information to our DB
    }
}
