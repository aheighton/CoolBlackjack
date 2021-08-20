package com.aheighton;

public class Deck extends Pile
{
	public Deck()
	{
		addAll();
	}

	public void shuffle()
	{
		setContents(getContents());
		//TODO: actually make this shuffle
	}


}
