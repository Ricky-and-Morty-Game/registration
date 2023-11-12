package com.example.registrationdemo.repository;

import com.example.registrationdemo.model.Scoreboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreboardRepo extends JpaRepository <Scoreboard, Long> {
}
