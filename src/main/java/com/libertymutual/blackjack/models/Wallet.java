package com.libertymutual.blackjack.models;

public class Wallet {
	private int balance = 100;

	public int getBalance() {
		return balance;
	}
	
	public void adjustBalance(int amount)	{
		balance += amount;
	}

}
