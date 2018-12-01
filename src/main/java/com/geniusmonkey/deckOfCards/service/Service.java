package com.geniusmonkey.deckOfCards.service;

import com.geniusmonkey.deckOfCards.entity.Deck;

public class Service {

	public static void main(String[] args) {
		
		Deck myDeck = new Deck();
		
		//shuffle(;)
		
		System.out.println(myDeck.deal().toString());
		System.out.println(myDeck.order());
		//System.out.println(myDeck.discard(null));
		//System.out.println(myDeck.cut());

	}

}
