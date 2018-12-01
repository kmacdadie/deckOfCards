package com.geniusmonkey.deckOfCards.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	private List<Card> cards;
	private List<Card> hand;

	public Deck() {
		cards = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15; j++) {
				cards.add(new Card(j, createCardName(i,j)));
			}
		}
	}
	
	public List<Card> cut() {
		int half = (new Random()).nextInt(cards.size()-1) + 1;
			for (int i = 0; i < half; i++)
				cards.add(cards.remove(0));
		Collections.rotate(cards, half);	
			return cards;
	}	
	
	public void rebuild() {
		cards.clear();
		return;
		
	}
			
	public boolean discard(Card card) {
		hand = new ArrayList<Card>();
		return hand.remove(card);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void order() {
       for (int i = 0; i < 0; i++)
          System.out.println(cards);
       //return cards;
    }
	
	public Card deal() {
		return cards.remove(0);
	}	
		
	private String createCardName(int suit, int value) {
		return new StringBuilder()
			.append(determineValueString(value))
			.append(" of ")
			.append(determineSuitString(suit))
			.toString();
	}
	
	private String determineSuitString(int suit) {
		String result = "";
		switch(suit) {
			case 0:
				result = ("Spades");
				break;
			case 1:
				result = ("Hearts");
				break;
			case 2:
				result = ("Clubs");
				break;
			case 3:
				result = ("Diamonds");
				break;
			default:
				result = ("Default");
		}

		return result;
	}

	private String determineValueString(int value) {
		String result = "";
		switch (value) {
			case 11:
				result = ("Jack");
				break;
			case 12:
				result = ("Queen");
				break;
			case 13:
				result = ("King");
				break;
			case 14:
				result = ("Ace");
				break;
			default:
				result = "" + value;
			
		}
		return result;
	}
}
