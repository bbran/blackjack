package com.libertymutual.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.blackjack.models.Dealer;
import com.libertymutual.blackjack.models.Deck;
import com.libertymutual.blackjack.models.Game;
import com.libertymutual.blackjack.models.Player;

@Controller
@RequestMapping("/")
public class GameController {
	private Deck deck = new Deck();
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private Game game;
	
	@GetMapping("")
	public String initialPage()	{
		return "blackjack/bet";
	}
	
	@PostMapping("new-game")
	public ModelAndView startGame(int bet)	{
		ModelAndView modelAndView;
		if (player.getBalance() - bet >= 0)	{
			modelAndView = new ModelAndView("blackjack/play");
			game = new Game(deck, bet, dealer, player);
			game.initializeGame();
			modelAndView.addObject("dealerCards", dealer.getHand().getCards());
			modelAndView.addObject("dealerHandValue", dealer.getHand().getCurrentHandValue());
			System.out.println(dealer.getHand().getCards().toString());
			System.out.println(dealer.getHand().getCurrentHandValue());
			modelAndView.addObject("playerCards", player.getHand().getCards());
			modelAndView.addObject("playerHandValue", player.getHand().getCurrentHandValue());
			System.out.println(player.getHand().getCurrentHandValue());
			System.out.println(player.getHand().getCards().toString());
		}
		else {
			modelAndView = new ModelAndView("blackjack/out-of-money");
		}
		return modelAndView;
	}
	
	@GetMapping("play")
	public ModelAndView tableView()	{
		ModelAndView modelAndView = new ModelAndView("blackjack/play");
		modelAndView.addObject("dealerCards", dealer.getHand().getCards());
		modelAndView.addObject("dealerHandValue", dealer.getHand().getCurrentHandValue());
		modelAndView.addObject("playerCards", player.getHand().getCards());
		modelAndView.addObject("playerHandValue", player.getHand().getCurrentHandValue());
		return modelAndView;
	}
	
	@PostMapping("player-hit")
	public String playerHit()	{
		if (deck.deckHasCards()) {
			player.takeCard(deck.takeCard());
			return "redirect:/play";
		}
		else	{
			return "blackjack/out-of-cards";
		}
	}
	
	@PostMapping("player-stand")
	public ModelAndView finishAndShowResult()	{
		ModelAndView modelAndView = new ModelAndView("blackjack/result");
		dealer.play(deck);
		modelAndView.addObject("dealerCards", dealer.getHand().getCards());
		modelAndView.addObject("dealerHandValue", dealer.getHand().getCurrentHandValue());
		modelAndView.addObject("playerCards", player.getHand().getCards());
		modelAndView.addObject("playerHandValue", player.getHand().getCurrentHandValue());
//		modelAndView.addObject(", attributeValue)
		return modelAndView;
	}

}
