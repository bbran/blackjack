package com.libertymutual.blackjack.models;

public class AceCard implements Card{
	private String name = "A";
	private int[] values = new int[] {1, 11};
	private String suit;
	
	public AceCard(String suit) {
		this.suit = suit;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getName()	{
		return name;
	}

	public int[] getValues()	{
		return values;
	}

	@Override
	public String toString() {
		return this.getName() + " of " + this.getSuit();
	}
}
