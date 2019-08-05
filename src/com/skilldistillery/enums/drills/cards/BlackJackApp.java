package com.skilldistillery.enums.drills.cards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BlackJackApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BlackJackApp app = new BlackJackApp();
		app.launch();
	}

//*****************************GAME Procedures*********************************************
	private void launch() {
		Scanner kb = new Scanner(System.in);
		boolean winOrLose = false;
		boolean hitOrStay = false;
		boolean userLost = false;
		boolean dealWinOrLose = false;
		int value = 0;
		boolean quit;
		boolean dealerLost = false;
		Deck deck = new Deck();

		List<Card> userHand = new ArrayList<>();
		List<Card> dealerHand = new ArrayList<>();
		Player player = new Player();

		do {
		deck.shuffle();
		int userValue = 0;
		int dealerValue = 0;
			dealerHand.clear();
			userHand.clear();
			introduction();
		for (int i = 0; i < 2; i++) { // two cards each
			Card c = deck.dealCard();
			userValue += c.getValue();
			userHand.add(c);
			c = deck.dealCard();
			dealerValue += c.getValue();
			dealerHand.add(c);
		}
		System.out.println("Player is dealt:");
		Dealing.printHandAndValue(userHand, userValue);
		System.out.println("Dealer is dealt:");
		Dealing.printHandAndValue(dealerHand, dealerValue);
			checkForWinorLost(userValue);

			if (!checkForWinorLost(value)) {
				do { // allows user to hit or fold until satisfied.
					hitOrStay = getUserHit(kb);
					if (hitOrStay) {
						Card c = deck.dealCard();
						System.out.println("You are dealt: " + c);
						userValue += c.getValue();
						userHand.add(c);
					}

					System.out.println("Value is " + userValue);
					userLost = checkForWinorLost(userValue);
				} while (hitOrStay && !userLost);
			}

			if (!userLost) {
				do {
					Card c = deck.dealCard();
					dealerValue += c.getValue();
					System.out.println("Dealer Hits:" + c.getValue());
					dealerHand.add(c);
					dealerLost = checkForWinorLost(dealerValue);
				} while (dealerValue <= 16 && !dealerLost);

				if (dealerLost) {
					System.out.println("Dealer has gone over with"+dealerValue+" pts, You have won!");
				} else {
					displayWinner(userValue, dealerValue);
				}
			}
		} while (playAgain(kb));

	}

	private void displayWinner(int userValue, int dealerValue) {
		// TODO Auto-generated method stub
		if (userValue > dealerValue) {
			System.out.println("Player wins with "+userValue + " versus dealer "+ dealerValue);
		} else if (userValue < dealerValue) {
			System.out.println("Dealer wins with "+dealerValue + " versus Player "+userValue );
		} else {
			System.out.println("Tie game.  Chips returned.");
		}
	}

//*******************************************************************************************
	private boolean checkForWinorLost(int value) {
		if (checkForWinner(value)) {
			return true;
		}
		if (checkForLost(value)) {
			return true;
		}

		return false;
	}

//*******************************************************************************************
	private boolean checkForWinner(int value) {
		if (value == 21) {
			return true;
		}

		return false;
	}

//*******************************************************************************************
	private boolean checkForLost(int value) {
		if (value > 21) {
			return true;
		}

		return false;
	}

//*****************************GAME Procedures*********************************************
	private void dealTwoHandsofCards(Deck deck) {
		// TODO Auto-generated method stub

		deck.shuffle();
		List<Card> dealerHand = new ArrayList<>();
		List<Card> userHand = new ArrayList<>();
		int userValue = 0;
		int dealerValue = 0;
		for (int i = 0; i < 2; i++) { // two cards each
			Card c = deck.dealCard();
			userValue += c.getValue();
			userHand.add(c);
			c = deck.dealCard();
			dealerValue += c.getValue();
			dealerHand.add(c);
		}
		Dealing.printHandAndValue(userHand, userValue);
		Dealing.printHandAndValue(dealerHand, dealerValue);
	}

//*****************************GAME Procedures*********************************************
	private boolean getUserHit(Scanner kb) {
		// get score
		int userValue = 0;
		List<Card> userHand = null;
		System.out.println("Stay:");
		System.out.println("Hit:");
		System.out.println("What would you like to do?:");
		String input = kb.next();
		boolean hit = false;
		switch (input) {
		case "stay":
		case "Stay":
		case "STAY":
			hit = false;
			break;
		case "Hit":
		case "hit":
		case "HIT":

			hit = true;
			break;
		}

		return hit;
	}

//***************************************************************************************
	private boolean playAgain(Scanner kb) {
		boolean quit = true;
		System.out.println("Would you like to reset and play again?(Yor N):");
		String input = kb.next();
		switch (input) {
		case "Yes":
		case "yes":
		case "YES":
		case "y":
		case "Y":
			quit = true;
			break;
		default:
			quit = false;
			break;

		}
		return quit;
	}

	private void introduction() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to BlackJack! ");
	}

}