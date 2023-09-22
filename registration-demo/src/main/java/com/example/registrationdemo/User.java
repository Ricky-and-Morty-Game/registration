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
@Entity
@Table(name="registration")
// MySQL table is Listed here to ensure connection
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ID will be auto-incremented
    @Column(nullable = false)
    private String userName;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false, unique = true)
    private String email;
}
