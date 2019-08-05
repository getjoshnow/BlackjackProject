package com.skilldistillery.enums.drills.cards;



public abstract class Hand {
	private Card card;
	private int cardValue;

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
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
