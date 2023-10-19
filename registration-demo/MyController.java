package com.example.registrationdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// The controller handles login and registration views, it's for webpage routing
@Controller
public class MyController {
    // Maps to Login Page (Thymeleaf Template UserLogin.html)
    @GetMapping("user/login")
    public String userLogin() {
        return "UserLogin"; // Returns UserLogin Template
    }
    // Mapts to Registration Page (Thymeleaf Template UserReg.html)
    @GetMapping("user/registration")
    public String userRegistration() {
        return "UserReg"; // Returns UserReg Template
    }
}
