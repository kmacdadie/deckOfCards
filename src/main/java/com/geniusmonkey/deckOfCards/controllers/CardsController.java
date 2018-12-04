package com.geniusmonkey.deckOfCards.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geniusmonkey.deckOfCards.entity.Deck;
import com.geniusmonkey.deckOfCards.entity.Card;

@RestController
public class CardsController {

	List<Card> discards = new ArrayList<Card>();
	Deck deck = new Deck();
	
	
	//deal cards
	
	//discard
	
	//order
	//rebuild

	@RequestMapping(value="/cards", method=RequestMethod.GET)
	public Deck getDeck() {
		return deck;
	}
	
	@RequestMapping(value="/cards/deal", method=RequestMethod.GET)
	public Card deal() {
		return deck.deal();
	}
	
	@RequestMapping(value="/cards/shuffle", method=RequestMethod.GET)
	public Deck shuffle() {
		deck.shuffle();
		return deck;	
	}
	
	@RequestMapping(value="/cards/discard", method=RequestMethod.POST)
	public Card discard(@RequestBody Card card) {
		discards.add(card);
		return card;
	}
	
	@RequestMapping(value="/cards/cut", method=RequestMethod.POST)
	public Deck cut(@RequestBody int position) {
		deck.cut(position);
		return deck;
	}
	
	@RequestMapping(value="/cards/order", method=RequestMethod.GET)
	public Deck order() {
		return deck;
	}
	
	@RequestMapping(value="/cards/rebuild", method=RequestMethod.GET)
	public Deck rebuild() {
		deck.rebuild();
		return deck;
	}
}
