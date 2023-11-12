package com.example.registrationdemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@Entity

@Table(name = "questions")
public class Question {
    @Id
    private String id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAns;

    public Question() {}
    public Question(String question, String answerA, String answerB, String answerC, String answerD, String correctAns ) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAns = correctAns;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }
    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }
    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }
    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getCorrectAns() {
        return correctAns;
    }
    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return correctAns == question1.correctAns &&
                Objects.equals(id, question1.id) &&
                Objects.equals(question,  question1.question) &&
                Objects.equals(answerA, question1.answerA) &&
                Objects.equals(answerB, question1.answerB) &&
                Objects.equals(answerC, question1.answerB) &&
                Objects.equals(answerD, question1.answerD);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, question, answerA, answerB, answerC, answerD, correctAns);
    }
}
