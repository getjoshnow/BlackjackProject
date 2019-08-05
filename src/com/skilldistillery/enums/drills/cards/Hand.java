package com.skilldistillery.enums.drills.cards;

import java.util.List;

public abstract class Hand {
	private List<Card> card;
	private int cardValue;
	private String name;

	
	
	/**
	 * @return the card
	 */
	public List<Card> getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(List<Card> card) {
		this.card = card;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cardValue
	 */
	public int getCardValue() {
		return cardValue;
	}

	/**
	 * @param cardValue the cardValue to set
	 */
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}



}
