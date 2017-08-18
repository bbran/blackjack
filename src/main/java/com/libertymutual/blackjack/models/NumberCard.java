package com.libertymutual.blackjack.models;

public class NumberCard implements Card{
	private String suit;
	private int number;
	private int[] values;
	
	public NumberCard(String suit, int number) {
		this.suit = suit;
		this.number = number;
		this.values = new int[] {number, number};
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getName()	{
		return String.valueOf(number);
	}

	public int[] getValues()	{
		return values;
	}
	
	@Override
	public String toString() {
		return this.getName() + " of " + this.getSuit();
	}
}
