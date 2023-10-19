package com.example.registrationdemo;
import org.springframework.data.jpa.repository.JpaRepository;
// Repository interface that will interact with our User entity class
// Spring JPA UserRepository classes will allow more funcitonality later
// when it is needed. We will have the ability to filter and search our database
// through the methods provided here.
public interface userRepo extends JpaRepository<User, Long> {
}
