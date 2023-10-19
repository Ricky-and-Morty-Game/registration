package com.example.registrationdemo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// Entity class, Username, Password and Email
// Setters, Getters, Constructor will be established in Service class

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// MySQL table is Listed here to ensure connection
public class User {
    private String id;
    // ID will be auto-incremented
    private String userName;
    private String password;
    private String email;
}
