package com.geniusmonkey.deckOfCards.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
		
	private int value;
	private String cardSuit;

	public Card(int value, String cardSuit) {
		this.value = value;
		this.cardSuit = cardSuit;
	}
	
	@Override
	public String toString() {
		return cardSuit;
	}	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getCardSuit() {
		return cardSuit;
	}
	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}
}