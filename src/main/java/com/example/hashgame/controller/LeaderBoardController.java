package com.example.hashgame.controller;

import com.example.hashgame.model.Achievement;
import com.example.hashgame.model.Player;
import com.example.hashgame.service.LeaderBoardService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/leaderboard")
public class LeaderBoardController {
    private final LeaderBoardService leaderBoardService;

    @GetMapping
    public ResponseEntity<List<Achievement>> getAllAchievements() {
        // TODO: implement only body
        return new ResponseEntity<List<Achievement>>(leaderBoardService.getAllAchievements(), HttpStatus.OK);
    }

    @GetMapping("/{player}")
    public ResponseEntity<List<Achievement>> getAchievement(@PathVariable String player) {
        // TODO: implement only body
        List<Achievement> achievements;

        if (player.equals("Human")){
            achievements = leaderBoardService.getAchievement(Player.HUMAN);
            return new ResponseEntity<List<Achievement>>(achievements, HttpStatus.OK);
        } else if (player.equals("Machine")){
            achievements = leaderBoardService.getAchievement(Player.MACHINE);
            return new ResponseEntity<List<Achievement>>(achievements, HttpStatus.OK);
        }else if (player.equals("Nobody")){
            achievements = leaderBoardService.getAchievement(Player.NOBODY);
            return new ResponseEntity<List<Achievement>>(achievements, HttpStatus.OK);
        }
        return new ResponseEntity<List<Achievement>>(HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Achievement addAchievemnt(@RequestBody Achievement achievement) {
         leaderBoardService.saveAchievement(achievement);
          return achievement;
    }
}
