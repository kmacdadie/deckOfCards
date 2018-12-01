package com.geniusmonkey.deckOfCards.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

	List<String> cards = new ArrayList<String>();
	
	@RequestMapping(value="/cards", method=RequestMethod.POST)
	public String addCard(@RequestBody String card) {
		cards.add(card);
		return "Succcessfully added: " + card;
	}
	
	@RequestMapping("/cards")
	public List<String> getCards() {
		return cards;
	}
	
}
