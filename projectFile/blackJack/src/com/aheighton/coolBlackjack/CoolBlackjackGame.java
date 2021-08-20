package com.aheighton.coolBlackjack;

import com.aheighton.blackjack.*;

import java.util.List;

public class CoolBlackjackGame extends BlackJackGame
{
	public CoolBlackjackGame(List<Player> players)
	{
		super(players);
	}

	@Override
	public void deal()
	{
		for (Player player: getPlayers()) play(player,"hit");
		for (Player player: getPlayers()) play(player, "hit");
		for (Player player: getPlayers()) player.newAbility();
	}

	@Override
	public String play(Player player)
	{
		StringBuilder output = new StringBuilder();

		if (player.isCPU())
		{
			String move;
			do
			{
				move = "stick";

				if (player.isDealer())
				{
					move = player.getHand().getScore() < 16? "hit" : "stick";
				}
				else
				{
					//TODO: work out what move the CPU will make
					if (player.getHand().getScore() < 16)
					{
						move = "hit";
					}
				}
				output.append(play(player, move));



			} while ((player.getHand().getScore() <= 21) && move.equals("hit"));
		}
		else
		{
			output.append(player.getName()).append(" has ").append(player.getHand().toString());

			output.append(", a score of ").append(player.getHand().getScore()).append(".");

			output.append(player.getAbility().equals("")?"\nHit or Stick?":"\nHit, Stick, or Cheat? \nYour cheat is: "+player.getAbility()+".");

		}
		return output.toString();
	}

	@Override
	public String play(Player player, String move)
	{
		StringBuilder output = new StringBuilder();

		if (player.isCPU())
		{
			if (player.isDealer())
			{
				output.append("Dealer ");
			}
			output.append(player.getName()).append(" has ").append(player.getHand().toString());
			output.append(", a score of ").append(player.getHand().getScore()).append(". ");
			output.append(move.equals("hit") ? "Hit. \n" : "Stick.");
		}

		if (move.equals("hit"))
		{
			player.hit(getDeck().removeCard());
		}

		else if (move.equals("cheat"))
		{
			output.append("When nobody is looking, ");

			switch (player.getAbility())
			{
				case "Free ace" -> {
					output.append("you sneak an ace onto the table!\n");
					int suitNo = (int) (Math.random()*4);
					player.hit(new Card("A", new char[]{'C', 'H', 'S', 'D'}[suitNo]));
				}
				case "Ditch last card" -> {
					output.append("you slip your last card off the table!\n");
					player.getHand().removeCard();

					for (Card card: player.getHand().getContents())
					{
						if (card.getValue().equals("1"))
						{
							card.setValue("A");
						}
					}

				}
				case "See other hands" -> {
					output.append("you turn over everyone's cards!\n");
					for (Player opponent : getPlayers())
					{
						output.append(opponent.getName()).append(" has ").append(opponent.getHand().toString());
						output.append(".\n");
					}
				}

				default -> output.append("you try and fail to cheat again!\n");
			}

			player.setAbility("");
		}

		if (player.getHand().getScore() > 21)
		{
			for (Card card: player.getHand().getContents())
			{
				if (card.getValue().equals("A"))
				{
					card.setValue("1");
					if (player.getHand().getScore() <= 21) return output.toString();
				}
			}

			if (player.isDealer())
			{
				output.append("Dealer ");
			}

			output.append(player.getName()).append(" has ").append(player.getHand().toString()).append(", a score of ");
			output.append(player.getHand().getScore()).append(". Bust.");
		}

		return output.toString();
	}
}
