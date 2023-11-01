package com.example.registrationdemo;

import com.google.firebase.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

// The controller handles login and registration views, it's for webpage routing
@Controller
public class MyController {
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    @Autowired
    private userService userService;
    @Autowired
    private gameService gameService;
    @Autowired
    private PasswordEncoder passwordEncoder;
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

    @GetMapping("/login")
    public String showLoginPage() {
        return "UserLogin";
    }

    @PostMapping("/login")
    public CompletableFuture<String> loginUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        DatabaseReference usersRef = db.child("users");
        Query query = usersRef.orderByChild("userName").equalTo(username);
        CompletableFuture<String> future = new CompletableFuture<>();
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = null;
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    user = childSnapshot.getValue(User.class);
                    break;
                }
                if (user != null && passwordEncoder.matches(password, user.getPassword())) {
                    future.complete("redirect:/Game");
                } else {
                    model.addAttribute("error", "Invalid Credentials");
                    future.complete("UserLogin");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                model.addAttribute("error", "Error occured during Login");
                future.complete("UserLogin");
            }
        });
        return future;
    }
    // Maps to Login Page (Thymeleaf Template UserLogin.html)
    @GetMapping("/game")
    public String showGamePage(Model model) {
       gameService.initializeGame();
       Question currentQuestion = gameService.getCurrentQuestion();
       if (currentQuestion != null) {
           model.addAttribute("question", currentQuestion);
           return "Game";
       } else{
           return "NoMoreQuestions";
       }
    }
    @PostMapping("/game")
    public String handleAnswerSubmission(@RequestParam("questionId") int questionId, @RequestParam("selectedChoice") String selectedChoice, Model model) {
        String result = gameService.submitAnswer(questionId, selectedChoice);
        model.addAttribute("result", result);

        if(gameService.isFinished()) {
            int score = gameService.calculateScore();
            model.addAttribute("score", score);
            gameService.saveScore("User");
            List<Scoreboard> topScores = gameService.getTopScores();
            model.addAttribute("topScores", topScores);
            return "GameFinished";
            } else {
            Question currentQuestion = gameService.getCurrentQuestion();
            model.addAttribute("question", currentQuestion);
            return "Game";
        }
    }
}
