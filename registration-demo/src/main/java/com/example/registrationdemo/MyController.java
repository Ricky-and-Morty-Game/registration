package com.example.registrationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// The controller handles login and registration views, it's for webpage routing
@Controller
public class MyController {
    @Autowired
    private userService userService;

    // Local Instance of userService to be used in registerUser function
    // @GetMapping pulls our Thymeleaf Template for User Registration
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "UserReg";
    }

    // Maps to Registration Page (Thymeleaf Template UserReg.html)
    // Utilizing Model library for console error and testing reports
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (user.getUserName() == null || user.getPassword() == null || user.getEmail() == null) {
            // User will be kept at Registration if fields are left empty
            model.addAttribute("error", "Please fill in all required fields");
            return "UserReg";
        }
        try {
            // Calls userService function to push template info to our Firebase Database
            userService.userRegistration(user.getUserName(), user.getPassword(), user.getEmail());
        } catch (Exception e) {
            // Error Catching
            model.addAttribute("error", "Registration failed");
        }
        return "Home";
    }

    // Maps to Login Page (Thymeleaf Template UserLogin.html)
    @RequestMapping(value= "/login", method=RequestMethod.GET)
    public String userLogin() {
        return "UserLogin"; // Returns UserLogin Template
    }
}



