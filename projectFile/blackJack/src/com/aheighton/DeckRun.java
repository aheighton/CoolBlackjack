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
		Player player = new BlackJackPlayer("Player",false,false);
		Player dealer = new BlackJackPlayer("CPU",true,true);
		players.add(player);
		players.add(dealer);


		Game game = new BlackJackGame(players);

		game.deal();

		Scanner scanner = new Scanner(System.in);
		String move;
		do
		{
			System.out.println(game.play(player));
			move = scanner.nextLine().toLowerCase();

			if (move.equals("hit") || move.equals("stick")) System.out.println(game.play(player, move));
		} while ((!move.equals("stick") && (player.getHand().getScore() <= 21)));


		System.out.println(game.play(players.get(1)));

		System.out.println(game.getWinner().getName());

	}
}
