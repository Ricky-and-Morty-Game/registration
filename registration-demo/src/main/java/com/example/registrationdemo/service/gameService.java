package com.example.registrationdemo.service;

import com.example.registrationdemo.model.Question;
import com.example.registrationdemo.model.Scoreboard;
import com.example.registrationdemo.repository.QuestionRepo;
import com.example.registrationdemo.repository.ScoreboardRepo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import org.springframework.stereotype.Service;
import com.google.firebase.database.*;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class gameService {
    private int score; // Current user score
    private String result; // Result of the last submitted answer
    private List<Question> questions; // List of questions in the game
    private int currentQuestionIndex; // Index of the current question
    private boolean finished; // Indicates if the game has finished

    private final QuestionRepo questionRepo; // Repository for accessing questions
    private final ScoreboardRepo scoreboardRepo; // Repository for scoreboard
    private DatabaseReference db;

    public gameService(QuestionRepo questionRepo, ScoreboardRepo scoreboardRepo) {
        this.questionRepo = questionRepo;
        this.scoreboardRepo = scoreboardRepo;
    }
    @PostConstruct
    public void initializeFirebase() {
        FirebaseApp.initializeApp();
    }

    // Initialize game and resets the game to '0'
    public void initializeGame() {
        DatabaseReference questionsRef = db.child("questions");
        questionsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            //game loop: iterates through list of questions
            public void onDataChange(DataSnapshot dataSnapshot) {
                questions = new ArrayList<>();
                for (DataSnapshot questionSnapshot : dataSnapshot.getChildren()) {
                    Question question = questionSnapshot.getValue(Question.class);
                    questions.add(question);
                }
                score = 0;
                result = "";
                currentQuestionIndex = 0;
                finished = false;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //ERRORS
            }
        });
    }
    // Retrieves the current question based on an index
    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }
    // Submits the answer for a question and updates the game
    public String submitAnswer(int questionId, String selectedChoice) {
        Question currentQuestion = getCurrentQuestion();
        if (currentQuestion != null && currentQuestion.getId().equals(String.valueOf(questionId))) {
            String correctAnswer = currentQuestion.getCorrectAns();
            if (correctAnswer.equalsIgnoreCase(selectedChoice)) {
                score++;
                result = "Correct!";
            } else {
                result = "Incorrect";
            }
            currentQuestionIndex++;
            if (currentQuestionIndex >= questions.size()) {
                finished = true;
            }
        }
        return result;
    }
    // Checks if the game has finished
    public boolean isFinished() {
        return finished;
    }
    // Calculates the final score
    public int calculateScore() {
        return score;
    }
    // Generates a result message based on the final score
    public String generateResult(int score) {
        return "Your score is: " + score;
    }
    // Saves the player's score to the scorebaord
    public void saveScore(String userName) {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setUserName(userName);
        scoreboard.setScore(score);
        scoreboard.setTimestamp();
        scoreboardRepo.save(scoreboard);
    }
    public List<Scoreboard> getTopScores() {
        DatabaseReference scoreboardRef = db.child("scoreboard");
        scoreboardRef.orderByChild("score")
                .limitToLast(10)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        List<Scoreboard> topScores = new ArrayList<>();
                        for (DataSnapshot childSnap : dataSnapshot.getChildren()) {
                            Scoreboard score = childSnap.getValue(Scoreboard.class);
                            topScores.add(score);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //ERRORS
                    }
                });
        return null;
    }
}



