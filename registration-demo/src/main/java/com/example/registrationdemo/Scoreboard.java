package com.example.registrationdemo;

import java.sql.Timestamp;
import java.util.Objects;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "scoreboard")
public class Scoreboard {
    @Id
    private String id;
    private String userName;
    private int score;
    private Timestamp timestamp;

    public Scoreboard() {}
    public Scoreboard(String userName, int score, Timestamp timestamp) {
        this.userName = userName;
        this.score = score;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }
    public void setID (String id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTimestamp() {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scoreboard that = (Scoreboard) o;
        return score == that.score &&
                Objects.equals(id, that.id) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, score, timestamp);
    }
}
