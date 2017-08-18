package com.libertymutual.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		String[] suits = new String[] {"Diamonds", "Clubs", "Hearts", "Spades"};
		String[] faces = new String[] {"J", "Q", "K"};
		for (String suit : suits)	{
			cards.add(new AceCard(suit));
			for (String face : faces)	{
				cards.add(new FaceCard(suit, face));
			}
			for (int i = 2; i < 11; i += 1)	{
				cards.add(new NumberCard(suit, i));
			}
		}
		shuffle();
	}
	
	public Card takeCard()	{
		return cards.remove(0);
	}
	
	public Boolean deckHasCards()	{
		return !cards.isEmpty();
	}
	
	public void shuffle()	{
		for (int i = 0; i < 7; i += 1)	{
			Collections.shuffle(cards);
		}
	}
	
	public ArrayList<Card> getCards()	{
		return cards;
	}
	

}
