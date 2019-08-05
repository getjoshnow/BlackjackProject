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
		boolean userWin =false;
		boolean dealWinOrLose = false;
		boolean dealerWon = false;
		int value = 0;
		boolean quit;
		boolean dealerLost = false;
		Deck deck = new Deck();

		List<Card> userHand = new ArrayList<>();
		List<Card> dealerHand = new ArrayList<>();
		Player player = new Player();
		Dealer dealer = new Dealer();
		player.setName(introduction(kb));
		dealer.setName("Casino Dealer");

		do {
		deck.shuffle();
		int userValue = 0;
		int dealerValue = 0;
			dealerHand.clear();
			userHand.clear();
		for (int i = 0; i < 2; i++) { // two cards each
			Card c = deck.dealCard();
			userValue += c.getValue();
			userHand.add(c);
			c = deck.dealCard();
			dealerValue += c.getValue();
			dealerHand.add(c);
		}
		System.out.println(player.getName()+" is dealt:");
		Dealing.printHandAndValue(userHand, userValue);
		System.out.println("Dealer is dealt:");
		Dealing.printHandAndValue(dealerHand, dealerValue);
		userWin = checkForWinner(userValue, player);
		dealerWon = checkForWinner(dealerValue, dealer);
		

			if (!userWin && !dealerWon) {
				do { // allows user to hit or fold until satisfied.
					hitOrStay = getUserHit(kb);
					if (hitOrStay) {
						Card c = deck.dealCard();
						System.out.println("You are dealt: " + c);
						userValue += c.getValue();
						userHand.add(c);
					}

					System.out.println("Value is " + userValue);
					userWin = checkForWinner(userValue, dealer);
					userLost = checkForLost(userValue, dealer);
				} while (hitOrStay && !userLost && !userWin);
			}

			if (!userLost && !userWin && !dealerWon) {
			
			while (dealerValue < 17 );
				{
					Card c = deck.dealCard();
					dealerValue += c.getValue();
					System.out.println("Dealer Hits:" + c.getValue());
					dealerHand.add(c);
					dealerLost = checkForLost(dealerValue, dealer);
					dealerWon = checkForWinner(dealerValue,dealer);
				}
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
	private boolean checkForWinner(int value, Hand player) {
		if (value == 21) {
			System.out.println("21!" + player.getName() +"  has won!");
			return true;
		}

		return false;
	}

//*******************************************************************************************
	private boolean checkForLost(int value, Hand player) {
		if (value > 21) {
			System.out.println(value+" pts."+ player.getName() +" has gone over!");

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