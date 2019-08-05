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
		boolean hitOrStay = false;
		boolean userLost = false;
		boolean userWin = false;
		boolean dealerWon = false;
		boolean dealerLost = false;
		Deck deck = new Deck();

		Player player = new Player();
		Dealer dealer = new Dealer();
		player.setName(introduction(kb));

		do {
			dealer.setName("Casino Dealer");
			deck.shuffle();
			player.setCardValue(0); // reset
			dealer.setCardValue(0); // reset

			player = dealTwoCards(deck);
			dealer = dealTwoCardsDealer(deck);

			System.out.println(player.getName() + ":You are dealt:");
			Dealing.printHandAndValue(player.getCard(), player.getCardValue());
			System.out.println("Dealer is dealt:");
			Dealing.printHandAndValue(dealer.getCard(), dealer.getCardValue());
			userWin = checkForWinner(player.getCardValue(), player);
			dealerWon = checkForWinner(dealer.getCardValue(), dealer);

			if (!userWin && !dealerWon) {
				do { // allows user to hit or fold until satisfied.
					hitOrStay = getUserHit(kb);
					if (hitOrStay) {
						Card c = deck.dealCard();
						System.out.println("You are dealt: " + c);
						player.setCardValue(player.getCardValue() + c.getValue());
						System.out.println("New point value is " + player.getCardValue() + "pts");
					}

					userWin = checkForWinner(player.getCardValue(), player);
					userLost = checkForLost(player.getCardValue(), player);
				} while (hitOrStay && !userLost && !userWin);
			}

			if (!userLost && !userWin && !dealerWon) {

				System.out.println("entering computer loop");
				if (dealer.getCardValue() < 17) {
					System.out.println("dealer value" + dealer.getCardValue());
					
					while (((dealer.getCardValue() < 17)) && (!dealerWon && !dealerLost))
					{
						Card c = deck.dealCard();
						dealer.setCardValue(dealer.getCardValue() + c.getValue());
						System.out.println("Dealer Hits:" + c.getValue());
						dealerLost = checkForLost(dealer.getCardValue(), dealer);
						dealerWon = checkForWinner(dealer.getCardValue(), dealer);
					}
				}
				if (dealerLost) {
					System.out.println("Dealer has gone over with" + dealer.getCardValue() + " pts, You have won!");
				} else {
					displayWinner(player.getCardValue(), dealer.getCardValue());
				}
			}

		} while (playAgain(kb));

	}

	private void displayWinner(int userValue, int dealerValue) {
		// TODO Auto-generated method stub
		if (userValue > dealerValue) {
			System.out.println("Player wins with " + userValue + " versus dealer " + dealerValue);
		} else if (userValue < dealerValue) {
			System.out.println("Dealer wins with " + dealerValue + " versus Player " + userValue);
		} else {
			System.out.println("Tie game.  Chips returned.");
		}
	}

//*******************************************************************************************
	private boolean checkForWinner(int value, Hand player) {
		if (value == 21) {
			System.out.println("21!" + player.getName() + "  has won!");
			return true;
		}

		return false;
	}

//*******************************************************************************************
	private boolean checkForLost(int value, Hand player) {
		if (value > 21) {
			System.out.println(value + " pts." + player.getName() + " has gone over!");

			return true;
		}

		return false;
	}

//*****************************GAME Procedures*********************************************
	private Player dealTwoCards(Deck deck) {
		Player player = new Player();
		deck.shuffle();
		List<Card> tempHand = new ArrayList<>();
		int userValue = 0;
		for (int i = 0; i < 2; i++) { // two cards each
			Card c = deck.dealCard();
			userValue += c.getValue();
			tempHand.add(c);

		}
		player.setCard(tempHand);
		player.setCardValue(userValue);
		return player;
	}

//*****************************GAME Procedures*********************************************
	private Dealer dealTwoCardsDealer(Deck deck) {
		Dealer dealer = new Dealer();
		deck.shuffle();
		List<Card> tempHand = new ArrayList<>();
		int userValue = 0;
		for (int i = 0; i < 2; i++) { // two cards each
			Card c = deck.dealCard();
			userValue += c.getValue();
			tempHand.add(c);

		}
		dealer.setCard(tempHand);
		dealer.setCardValue(userValue);
		return dealer;
	}

//*****************************GAME Procedures*********************************************
	private boolean getUserHit(Scanner kb) {
		// get score
		System.out.println("Stay:");
		System.out.println("Hit:");
		System.out.println("What would you like to do?:");
		String input = kb.next();
		boolean hit = false;
		switch (input) {
		case "stay":
		case "Stay":
		case "STAY":
		case "s":
			hit = false;
			break;
		case "Hit":
		case "hit":
		case "HIT":
		case "h":

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

	private String introduction(Scanner kb) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to BlackJack! ");
		System.out.print("Enter your name :");
		String input = kb.nextLine();
		return input;
	}
}