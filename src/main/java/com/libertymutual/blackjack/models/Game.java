package com.libertymutual.blackjack.models;

public class Game {
	private Deck deck;
	private int bet;
	private Dealer dealer;
	private Player player;
	
	public Game(Deck deck, int bet, Dealer dealer, Player player) {
		this.deck = deck;
		this.dealer = dealer;
		this.player = player;
		this.bet = bet;
	}
	
	public void initializeGame()	{
		dealer.setInitialHand(deck);
		player.setInitialHand(deck);
		player.adjustBalance(-1 * bet);
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public void payout()	{
		
	}

}
