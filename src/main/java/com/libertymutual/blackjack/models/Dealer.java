package com.libertymutual.blackjack.models;

public class Dealer {
	private Hand hand;
	
	public void setInitialHand(Deck deck)	{
		hand = new Hand(deck);
	}
	
	public Hand getHand()	{
		return hand;
	}
	
	public void play()	{
		
	}
	
	public void takeCard(Card card)	{
		hand.takeCard(card);
	}

}
