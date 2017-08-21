package com.libertymutual.blackjack.models;

public class Game {
	private int currentBet;
	private Dealer dealer;
	private Player player;
	private String gameResult;
	private int payout;
	
	
	public Game(Deck deck, int bet, Dealer dealer, Player player) {
		this.dealer = dealer;
		this.player = player;
		this.currentBet = bet;
		this.dealer.setInitialHand(deck);
		this.player.setInitialHand(deck);
		this.player.getWallet().adjustBalance(-1 * bet);
	}
	
	private void setResult()	{
		int dealerHandValue = dealer.getHand().getCurrentHandValue();
		int playerHandValue = player.getHand().getCurrentHandValue();
		int playerHandSize = player.getHand().getCards().size();
		if (playerHandValue > 21)	{
			gameResult = "Player Bust";
		}
		else if (playerHandValue == 21 && playerHandSize == 2 && dealerHandValue !=21)	{
			gameResult = "Blackjack";
		}
		else if (playerHandValue == dealerHandValue) {
			gameResult = "Push";
		}
		else if (playerHandValue < dealerHandValue && dealerHandValue < 22)	{
			gameResult = "Dealer Wins";
		}
		else	{
			gameResult = "Player Wins";
		}
	}
	
	private void setPayout()	{
		if (gameResult == "Blackjack")	{
			payout = currentBet + (currentBet * (3/2));
			player.getWallet().adjustBalance(payout);
		}
		else if (gameResult == "Player Wins")	{
			payout = currentBet*2;
			player.getWallet().adjustBalance(payout);
		}
		else if (gameResult == "Push") {
			payout = currentBet;
			player.getWallet().adjustBalance(payout);
		}
	}
	
	
	
	public void finishGame()	{
		setResult();
		setPayout();
	}
	
	public String getGameResult() {
		return gameResult;
	}

	public int getPayout() {
		return payout;
	}

	public int getCurrentBet() {
		return currentBet;
	}
	
	public void doubleDown()	{
		player.getWallet().adjustBalance(-1 * currentBet);
		currentBet = currentBet*2;
	}
}
