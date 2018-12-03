package com.geniusmonkey.deckOfCards.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	public static final int DCARDS = 52;
	private ArrayList<Card> cards;
	private int half;
	private List<Card> hand;
	private Card[] deckOfCards;
	private int currentCard;
	

	public Deck() {
		cards = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15; j++) {
				cards.add(new Card(j, createCardName(i,j)));
			}
		}
		
	half = (new Random()).nextInt(cards.size()-1) + 1;
		for (int i = 0; i < half; i++) {
			cards.add(cards.remove(0));
		}
	}
	
	public List<Card> getHand() {
		return cards;
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public int getHalf() {
		return half;
	}
	public void checkHand() {
		for (Card card : hand) {
			System.out.println(card.toString());
		}
	}
	
	public boolean discard(Card card) {
			return hand.remove(card);
		}
	
	public void deal(Deck deck) {
		cards.remove(0);
		hand.add(deck.deal()); 
	}	

	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void cut() {
		Collections.rotate(cards, half);			
	}	
	
	//public void rebuild() {
		//Collections.sort(cards, null);;
	//}
				
	public void order() {
       Collections.unmodifiableCollection(cards);          
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
