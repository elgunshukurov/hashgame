package com.example.hashgame.service;

import com.example.hashgame.model.Achievement;
import com.example.hashgame.model.Player;

import java.util.List;

public interface LeaderBoardService {
    List<Achievement> getAllAchievements();
    List<Achievement> getAchievement(Player winner);
    void saveAchievement(Achievement achievement);
}
