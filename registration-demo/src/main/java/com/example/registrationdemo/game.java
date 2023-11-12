package com.example.registrationdemo;

import com.example.registrationdemo.service.answerLogic;
import com.example.registrationdemo.service.questionLogic;

import java.util.List;
import java.util.ArrayList;

public class game {
    public static List<questionLogic> initializeQuestions() {
        List<questionLogic> questions = new ArrayList<>();

        List<answerLogic> answers1 = new ArrayList<>();
        answers1.add(new answerLogic("22", false));
        answers1.add(new answerLogic("4", true));
        answers1.add(new answerLogic("44", false));
        answers1.add(new answerLogic("5", false));
        questions.add(new questionLogic("What is 2 + 2?", answers1));

        List<answerLogic> answers2 = new ArrayList<>();
        answers2.add(new answerLogic("Rick", true));
        answers2.add(new answerLogic("Jick", false));
        answers2.add(new answerLogic("Bick", false));
        answers2.add(new answerLogic("Morty", false));
        questions.add(new questionLogic("What is Rick's name?", answers2));

        List<answerLogic> answers3 = new ArrayList<>();
        answers3.add(new answerLogic("A", true));
        answers3.add(new answerLogic("B", false));
        answers3.add(new answerLogic("C", false));
        answers3.add(new answerLogic("Triangle", false));
        questions.add(new questionLogic("What is the first letter of the alphabet?", answers3));
        // Add more questions as needed

        return questions;
    }
}


