package com.libertymutual.blackjack.models;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Deck deck;
	
	public Hand(Deck deck) {
		this.deck = deck;
		for (int i = 0 ; i < 2 ; i += 1) {
			takeCard(this.deck.takeCard());
		}
	}
	
	public void takeCard(Card card)	{
		cards.add(card);
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	private ArrayList<Integer> calculateHandTotals()	{
		ArrayList<Integer> currentHandTotals = new ArrayList<Integer>();
		int handMin = 0;
		int handAces = 0;
		int handMax = 0;
		int numAces = 0;
		
		for (Card card : cards)	{
			if(card.getName() == "A")	{
				numAces += 1;
			}
			handMin += card.getValues()[0];
			handMax += card.getValues()[1];
		}
		
		currentHandTotals.clear();
		currentHandTotals.add(handMin);
		currentHandTotals.add(handMax);
		
		if (numAces > 1)	{
			handAces = handMin + 10;
			currentHandTotals.add(handAces);
		}
		return currentHandTotals;
	}
	
	public int getCurrentHandValue()	{
		int bestNonBustResult = 0;
		for (int value : calculateHandTotals())	{
			if(value > bestNonBustResult && value < 22)	{
				bestNonBustResult = value;
			}
		}
		if (bestNonBustResult == 0)	{
			return 22;
		}
		else	{
			return bestNonBustResult;
		}
	}

}
