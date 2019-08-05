package com.skilldistillery.enums.drills.cards;

public class Dealer extends Hand {
	
	public Dealer() {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer visable card is "+ getCard());
		return builder.toString();
	}
	
	
	
	
	
}
