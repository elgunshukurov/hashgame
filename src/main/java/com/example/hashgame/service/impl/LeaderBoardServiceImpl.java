package com.example.hashgame.service.impl;

import com.example.hashgame.model.Achievement;
import com.example.hashgame.model.Player;
import com.example.hashgame.repository.LeaderBoardRepository;
import com.example.hashgame.service.LeaderBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderBoardServiceImpl implements LeaderBoardService {
    private final LeaderBoardRepository leaderBoardRepository;



    @Override
    public List<Achievement> getAllAchievements() {
        // TODO: implement only body
        return leaderBoardRepository.findAll();
    }

    @Override
    public List<Achievement> getAchievement(Player winner) {
        // TODO: implement only body
        return leaderBoardRepository.findByWinner(winner);
    }

    @Override
    public void saveAchievement(Achievement achievement) {
        // TODO: implement only body
        leaderBoardRepository.save(achievement);
    }
}
