package com.libertymutual.blackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.libertymutual.blackjack.controllers.GameController;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackApplication.class, args);
		
		GameController gc = new GameController();
		gc.newGame(50);
		
	}
}
