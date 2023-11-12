package com.example.registrationdemo.repository;
import com.example.registrationdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface that will interact with our User entity class
// Spring JPA UserRepository classes will allow more funcitonality later
// when it is needed. We will have the ability to filter and search our database
// through the methods provided here.
@Repository
public interface userRepo extends JpaRepository <User, Long> {
}
