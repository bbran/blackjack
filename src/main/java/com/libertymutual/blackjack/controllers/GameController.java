package com.libertymutual.blackjack.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

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
	public ModelAndView initialPage()	{
		ModelAndView modelAndView = new ModelAndView("blackjack/index");
		modelAndView.addObject("player", player);
		return modelAndView;
	}
	
	@PostMapping("new-game")
	public ModelAndView newGame(int bet)	{
		ModelAndView modelAndView;
		//player must have enough money to bet and deck must have at least 4 cards to start new game
		if (player.getWallet().getBalance() <= 0)	{
			modelAndView = new ModelAndView("blackjack/error");
			modelAndView.addObject("errorMessage", "You're out of money.");
		}
		else if ((player.getWallet().getBalance() - bet) < 0)	{
			modelAndView = new ModelAndView("blackjack/error");
			modelAndView.addObject("errorMessage", "You bet more money than you have.");
		}
		else if (deck.getCards().size() < 4)	{
			modelAndView = new ModelAndView("blackjack/error");
			modelAndView.addObject("errorMessage", "There aren't enough cards to start another hand.");
		}
		else	{
			game = new Game(deck, bet, dealer, player);
			if (player.getHand().getCurrentHandValue() == 21)	{
				game.finishGame();
				modelAndView = new ModelAndView("redirect:/result");
			}
			else	{
				modelAndView = new ModelAndView("redirect:/play");
			}
		}
		return modelAndView;
	}
	
	@GetMapping("play")
	public ModelAndView tableView()	{
		ModelAndView modelAndView = new ModelAndView("blackjack/play");
		modelAndView.addObject("dealerShowCardName", dealer.getHand().getCards().get(0).getName());
		modelAndView.addObject("dealerShowCardSuit", dealer.getHand().getCards().get(0).getSuit());
		System.out.println(dealer.getHand().getCards());
		System.out.println(dealer.getHand().getCurrentHandValue());
		modelAndView.addObject("player", player);
		return modelAndView;
	}
	
	@PostMapping("player-hit")
	public ModelAndView playerHit()	{
		ModelAndView modelAndView;
		System.out.println(deck.getCards());
		System.out.println(deck.deckHasCards());
		if (deck.deckHasCards()) {
			player.takeCard(deck.takeCard());
			if (player.getHand().getCurrentHandValue() > 21) {
				game.finishGame();
				modelAndView = new ModelAndView("redirect:/result");
				return modelAndView;
			}
			else {
				modelAndView = new ModelAndView("redirect:/play");
				return modelAndView;
			}
		}
		else	{
			modelAndView = new ModelAndView("blackjack/error");
			modelAndView.addObject("errorMessage", "The deck is out of cards.");
			return modelAndView;
		}
	}
	
	@PostMapping("player-stand")
	public ModelAndView finishAndShowResult()	{
		ModelAndView modelAndView = new ModelAndView("redirect:/result");
		dealer.play(deck);
		game.finishGame();
		return modelAndView;
	}
	
	@GetMapping("result")
	public ModelAndView resultView()	{
		ModelAndView modelAndView = new ModelAndView("blackjack/result");
		modelAndView.addObject("dealer", dealer);
		modelAndView.addObject("player", player);
		modelAndView.addObject("game", game);
		return modelAndView;
	}

}
