package com.aheighton;

public class BlackJackPlayer extends Player
{
	public BlackJackPlayer(String name, boolean isCPU, boolean isDealer)
	{
		setName(name);
		setCPU(isCPU);
		setDealer(isDealer);
		setHand(new Hand());
	}

	public void hit(Card card)
	{
		getHand().addCard(card);
	}

	public void stick()
	{

	}

	public int getScore()
	{
		return getHand().getScore();
	}
}
