package com.libertymutual.blackjack.models;

public class Player {
	private Hand hand;
	private int balance;
	
	public Player() {
		this.balance = 1000;
	}
	
	public void setInitialHand(Deck deck)	{
		hand = new Hand(deck);
	}
	
	public Hand getHand()	{
		return hand;
	}

	public int getBalance() {
		return balance;
	}
	
	public void adjustBalance(int amount)	{
		balance += amount;
	}
	
	public void takeCard(Card card)	{
		hand.takeCard(card);
	}

}
