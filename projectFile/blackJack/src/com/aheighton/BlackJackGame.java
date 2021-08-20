package com.aheighton;

import java.util.List;

public class BlackJackGame extends Game
{
	public BlackJackGame(List<Player> players)
	{
		setPlayers(players);
		setDeck(new Deck());
	}

	@Override
	public void deal()
	{
		for (Player player: getPlayers())
		{
			hit(player);
			hit(player);
		}
	}
	
	public void hit(Player player)
	{
		player.hit(getDeck().removeCard());
	}

	@Override
	public void play()
	{

	}

	@Override
	public Player getWinner()
	{
		Player winner = getPlayers().get(0);
		for (Player player: getPlayers())
		{
			if (winner.getHand().getScore() < player.getHand().getScore())
			{
				if (player.getHand().getScore() <= 21)
				{
					winner = player;
				}
			}
		}
		return winner;
	}
}
