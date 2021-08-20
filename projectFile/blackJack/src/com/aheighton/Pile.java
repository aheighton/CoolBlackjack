package com.aheighton;

import java.util.List;

public abstract class Pile
{
	private List<Card> contents;

	public void addCard(Card card)
	{
		contents.add(card);
	}

	public Card removeCard()
	{
		return contents.remove(contents.size()-1);
	}

	public void removeCard(Card card)
	{
		contents.remove(card);
	}

	public Card removeCard(int index)
	{
		return contents.remove(index);
	}

	public void addAll()
	{
		for (char suit: new char[]{'C', 'H', 'S', 'D'})
		{
			for (String value: new String[]{"1","2","3","4","5","6","7","8","9","10","J","Q","K"})
			{
				addCard(new Card(value, suit));
			}
		}
	}

	public List<Card> getContents()
	{
		return contents;
	}

	public void setContents(List<Card> contents)
	{
		this.contents = contents;
	}
}
