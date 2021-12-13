package com.example.hashgame.controller;

import com.example.hashgame.model.Achievement;
import com.example.hashgame.model.Player;
import com.example.hashgame.service.LeaderBoardService;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class LeaderBoardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LeaderBoardService leaderBoardService;

    private List<Achievement> achievementList = new ArrayList<>();

    @BeforeEach
    public void setup() {
        Achievement achievement = new Achievement();
        achievement.setId(1);
        achievement.setWinner(Player.MACHINE);
        achievement.setResult("I  G O T  Y O U!\n I have won the game!");
        achievement.setFinishedAt(LocalDateTime.now());

        this.achievementList.add(achievement);

        achievement = new Achievement();
        achievement.setId(2);
        achievement.setWinner(Player.HUMAN);
        achievement.setResult("C O N G R A T U L A T I O N S! \nYou won the game!");
        achievement.setFinishedAt(LocalDateTime.now());

        this.achievementList.add(achievement);

        achievement = new Achievement();
        achievement.setId(3);
        achievement.setWinner(Player.NOBODY);
        achievement.setResult("Nobody wins the game.\nYou are really good");
        achievement.setFinishedAt(LocalDateTime.now());

        achievementList.add(achievement);

        Mockito.when(this.leaderBoardService.getAllAchievements()).thenReturn(achievementList);
        Mockito.when(this.leaderBoardService.getAchievement(Player.MACHINE)).thenReturn(achievementList);
        Mockito.when(this.leaderBoardService.getAchievement(Player.HUMAN)).thenReturn(achievementList);
        Mockito.when(this.leaderBoardService.getAchievement(Player.NOBODY)).thenReturn(achievementList);
    }

    @Test
    void getAllAchievementsFullyPlayed() throws Exception {
        mockMvc.perform(get("/api/v1/leaderboard"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(achievementList.size())))

                .andExpect(jsonPath("$[0].id", equalTo(achievementList.get(0).getId())))
//                .andExpect(jsonPath("$[0].winner", equalTo(achievementList.get(0).getWinner())))
                .andExpect(jsonPath("$[0].result", equalTo(achievementList.get(0).getResult())))
//                .andExpect(jsonPath("$[0].finishedAt", equalTo(achievementList.get(0).getFinishedAt())))

                .andExpect(jsonPath("$[1].id", equalTo(achievementList.get(1).getId())))
//                .andExpect(jsonPath("$[1].winner", equalTo(achievementList.get(1).getWinner())))
                .andExpect(jsonPath("$[1].result", equalTo(achievementList.get(1).getResult())))
//                .andExpect(jsonPath("$[1].finishedAt", equalTo(achievementList.get(1).getFinishedAt())))

                .andExpect(jsonPath("$[2].id", equalTo(achievementList.get(2).getId())))
//                .andExpect(jsonPath("$[2].winner", equalTo(achievementList.get(2).getWinner())))
                .andExpect(jsonPath("$[2].result", equalTo(achievementList.get(2).getResult())));
//                .andExpect(jsonPath("$[2].finishedAt", equalTo(achievementList.get(2).getFinishedAt())));

//        Mockito.verify(leaderBoardService).;
    }
    @Test
    void getAchievementsByPlayer() throws Exception {
        System.out.println(achievementList);

        mockMvc.perform(get("/api/v1/leaderboard/Machine"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())

                .andExpect(jsonPath("$[0].id", equalTo(achievementList.get(0).getId())))
//                .andExpect(jsonPath("$[0].winner", equalTo(achievementList.get(0).getWinner())))
                .andExpect(jsonPath("$[0].result", equalTo(achievementList.get(0).getResult())))
//                .andExpect(jsonPath("$[0].finishedAt", equalTo(achievementList.get(0).getFinishedAt())))
        ;
        mockMvc.perform(get("/api/v1/leaderboard/Human"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())

                .andExpect(jsonPath("$[1].id", equalTo(achievementList.get(1).getId())))
//                .andExpect(jsonPath("$[1].winner", equalTo(achievementList.get(1).getWinner())))
                .andExpect(jsonPath("$[1].result", equalTo(achievementList.get(1).getResult())))
//                .andExpect(jsonPath("$[1].finishedAt", equalTo(achievementList.get(1).getFinishedAt())))
        ;
        mockMvc.perform(get("/api/v1/leaderboard/Nobody"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())

                .andExpect(jsonPath("$[2].id", equalTo(achievementList.get(2).getId())))
//                .andExpect(jsonPath("$[2].winner", equalTo(achievementList.get(2).getWinner())))
                .andExpect(jsonPath("$[2].result", equalTo(achievementList.get(2).getResult())))
//                .andExpect(jsonPath("$[2].finishedAt", equalTo(achievementList.get(2).getFinishedAt())))
        ;
    }
}