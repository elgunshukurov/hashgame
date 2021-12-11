package com.example.hashgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String result;
    private Player winner;
    private LocalDateTime finishedAt;

    public Achievement(String result, Player winner) {
        this.result = result;
        this.winner = winner;
        this.finishedAt = LocalDateTime.now();
    }
}
