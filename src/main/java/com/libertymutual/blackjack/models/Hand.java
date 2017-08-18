package com.libertymutual.blackjack.models;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Deck deck;
	private int[] currentHandValues = new int[] {0,0};
	
	public Hand(Deck deck) {
		this.deck = deck;
		for (int i = 0 ; i < 2 ; i += 1) {
			takeCard(this.deck.takeCard());
		}
	}
	
	public void takeCard(Card card)	{
		cards.add(card);
		currentHandValues = calculateHand(card);
	}
	
	public void stand()	{
		
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public int[] calculateHand(Card card)	{
		int[] allTotals = new int[] {
				currentHandValues[0] + card.getValues()[0],
				currentHandValues[0] + card.getValues()[1],
				currentHandValues[1] + card.getValues()[0],
				currentHandValues[1] + card.getValues()[1],
				};
		int validTotal1=0;
		int validTotal2=0;
		for (int i = 0; i < 4; i += 1) {
			if (validTotal1 = 0 && validTotal1 != allTotals[i])	{
				
			}
		}
		int[] validTotals = new int[2];
		return validTotals;
		
	}
	
	public int finalHandValue()	{
		
	}

}
