package com.aheighton;

public class Hand extends Pile
{
	public int getScore(){
		int score = 0;
		for (Card card: getContents())
		{
			score += card.getPoints();
		}

		return score;
	}
}
