package com.geniusmonkey.deckOfCards.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geniusmonkey.deckOfCards.entity.Deck;

@RestController
public class CardsController {

	List<String> cards = new ArrayList<String>();
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
	public Deck deal() {
		return deal();
	}
	
	@RequestMapping(value="/cards/shuffle", method=RequestMethod.GET)
	public Deck shuffle() {
		deck.shuffle();
		return deck;	
	}
	
	@RequestMapping(value="/cards/discard", method=RequestMethod.POST)
	public String discard(@RequestBody String card) {
		return "Succcessfully discarded: " + card;
	}
	
	@RequestMapping(value="/cards/cut", method=RequestMethod.GET)
	public Deck cut() {
		deck.cut();
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
