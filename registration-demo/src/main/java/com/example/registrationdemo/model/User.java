package com.example.registrationdemo.model;

import com.google.firebase.database.annotations.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Entity
// MySQL table is Listed here to ensure connection
public class User {
    @Id
    @GeneratedValue
    // ID will be auto-incremented
    private String userName;
    private String password;
    private String email;
}
