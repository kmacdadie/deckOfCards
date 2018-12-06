package com.geniusmonkey.deckOfCards.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Deck {

	private static ArrayList<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15;  j++) {
				cards.add(new Card(j, createCardName(i,j)));
			}
		}
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public Card deal() {
		Card card = cards.remove(0);
		System.out.println("Card Dealt: " + card.getCardSuit() + " " + card.getValue());
		return card;
	}
		
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void cut(int position) {
		Collections.rotate(cards, position);
	}	
	
	public class CardChainedComparator implements Comparator<Card> {
		private List<Comparator<Card>> listComparators;
		@SafeVarargs
		public CardChainedComparator(Comparator<Card>...comparators) {
			this.listComparators = Arrays.asList(comparators);
		}
		public int compare(Card a, Card b) {
			for(Comparator<Card> comparator : listComparators) {
				int result = comparator.compare(a, b);
				if (result != 0) {
					return result;
				}
			}
			return 0;
		}
	}
	public class SuitComparator implements Comparator<Card> {
		public int compare(Card a, Card b) {
			return a.getCardSuit().compareTo(b.getCardSuit());
		}
	}
	public class ValueComparator implements Comparator<Card> {	
	   public int compare (Card a, Card b) {
	        if(a.getValue() > b.getValue()) {
	            return 1;
	        } else if(a.getValue() < b.getValue()) {
	            return -1;
	        } else {
	            return 0;
	        }
	    }
	}
	
	public void order() {
		Collections.sort(cards,	new ValueComparator());
    }
	
	public void rebuild() {
		Collections.sort(cards, new SuitComparator()); 
	}
	
	private String createCardName(int cardSuit, int value) {
		return new StringBuilder()
			.append(determineValueString(value))
			.append(" of ")
			.append(determineSuitString(cardSuit))
			.toString();
	}
	
	private String determineSuitString(int cardSuit) {
		String result = "";
		switch(cardSuit) {
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
