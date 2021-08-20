package com.aheighton;

import static java.lang.Integer.parseInt;

public class Card
{
	private String value;
	private char suit;

	public Card(String value, char suit)
	{
		setValue(value);
		setSuit(suit);
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public char getSuit()
	{
		return suit;
	}

	public void setSuit(char suit)
	{
		this.suit = suit;
	}

	public char getColour()
	{
		if (getSuit() == 'S' || getSuit() == 'C') return 'B';
		else return 'R';
	}

	public int getPoints()
	{
		//TODO: how to handle aces?
		try
		{
			return parseInt(getValue());
		} catch (Exception e)
		{
			return 10;
		}
	}
}
