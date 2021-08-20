package com.aheighton;

import java.util.*;

public class DeckRun
{
	public static void main(String[] args)
	{
		runGame();
	}
	public static void runGame()
	{
		List<Player> players = new LinkedList<>();
		players.add(new BlackJackPlayer("CPU1",true,false));
		players.add(new BlackJackPlayer("CPU2",true,true));


		Game game = new BlackJackGame(players);

		game.deal();

		System.out.println(game.play(players.get(0)));

		System.out.println(game.play(players.get(1)));

		System.out.println(game.getWinner().getName());

	}
}
