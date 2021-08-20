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
		try
		{
			return parseInt(getValue());
		} catch (Exception e)
		{
			if (getValue().equals("A"))
			{
				return 11;
			}
			return 10;
		}
	}

	public String toString()
	{
		StringBuilder output = new StringBuilder();

		if (getValue().equals("1"))
		{
			output.append("A");
		}
		else
		{
			output.append(getValue());
		}

		switch (getSuit())
		{
			case 'C' -> output.append("♣");
			case 'H' -> output.append("♥");
			case 'S' -> output.append("♠");
			case 'D' -> output.append("♦");
		}

		return output.toString();
	}
}
