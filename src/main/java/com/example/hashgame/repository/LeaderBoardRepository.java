package com.example.hashgame.repository;

import com.example.hashgame.model.Achievement;
import com.example.hashgame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaderBoardRepository extends JpaRepository<Achievement, Integer> {
    List<Achievement> findByWinner(Player winner);

    @Override
    List<Achievement> findAll();
}
