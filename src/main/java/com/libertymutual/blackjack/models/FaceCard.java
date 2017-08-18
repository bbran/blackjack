package com.libertymutual.blackjack.models;

public class FaceCard implements Card {
	private String suit;
	private String face;
	private int[] values = new int[] {10, 10};
	
	public FaceCard(String suit, String face) {
		this.suit = suit;
		this.face = face;
	}
	
	public String getSuit() {
		return suit;
	}

	public String getName()	{
		return face;
	}

	public int[] getValues()	{
		return values;
	}
	
	@Override
	public String toString() {
		return this.getName() + " of " + this.getSuit();
	}
}
