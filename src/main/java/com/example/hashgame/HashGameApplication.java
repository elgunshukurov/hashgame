package com.example.hashgame;

import com.example.hashgame.gui.HashGameView;
import com.example.hashgame.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HashGameApplication implements CommandLineRunner {
	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(HashGameApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.setProperty("java.awt.headless", "false");
		HashGameView hashGameView = new HashGameView((LeaderBoardService) applicationContext.getBean("leaderBoardServiceImpl"));
		hashGameView.setVisible(true);
	}
}
