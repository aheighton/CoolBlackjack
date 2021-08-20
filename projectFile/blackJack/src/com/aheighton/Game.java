package com.aheighton;

import java.util.List;

public abstract class Game
{
	private Deck deck;
	private List<Player> players;

	public Deck getDeck()
	{
		return deck;
	}

	public void setDeck(Deck deck)
	{
		this.deck = deck;
	}

	public List<Player> getPlayers()
	{
		return players;
	}

	public void setPlayers(List<Player> players)
	{
		this.players = players;
	}

	public abstract void deal();
	public abstract void play();
	public abstract Player getWinner();
}
