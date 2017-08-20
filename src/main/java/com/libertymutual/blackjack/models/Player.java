package com.libertymutual.blackjack.models;

public class Player {
	private Hand hand;
	private Wallet wallet = new Wallet();
	
	public void setInitialHand(Deck deck)	{
		hand = new Hand(deck);
	}
	
	public Hand getHand()	{
		return hand;
	}
	
	public void takeCard(Card card)	{
		hand.takeCard(card);
	}

	public Wallet getWallet() {
		return wallet;
	}
}
