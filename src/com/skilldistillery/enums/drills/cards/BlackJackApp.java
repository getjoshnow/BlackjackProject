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
		do { // Enter BlackJack Game
			introduction();
		    Deck deck = new Deck();
//			
//				do { // Enter a set Game
//					//invite user to play give them money
//					
//					boolean quit;
//					do { // Enter Hand Game;
					dealTwoHandsofCards(deck);
					if (checkForWinorLost(value))
						{
//						winOrLose = checkForWinner(Player.getHand(), Dealer.getHand());
						boolean	hitOrFold = false;	
							do { // allows user to hit or fold until satisfied.
								hitOrFold = getUserHit(kb,deck, userValue);
								}while(!hitOrFold);
//
//						if(!winOrLose) {
//							boolean	dealWinOrLose = false;	
//							do { // allows user to hit or fold until satisfied.
//									dealerUserHit(deck);
//									winOrLose = checkForWinner(dealerHand);
//									displayCards();
//							   }while(!dealWinorLose);
//						}
//						displayWinner();
//					}while(!quit);
//					
				}while(playAgain(kb));
//	}

}
//*******************************************************************************************
private boolean checkForWinorLost(int value) {
	if (checkForWinner(value)) {
		System.out.println("you have won.");
		return true;
	}
	if (checkForLost(value))
		{System.out.println("you have lost.");
		return true;}
		
			
	return false;
		}
//*******************************************************************************************
private boolean checkForWinner(int value) {
if 	(value == 21) 
{return true;}
	
	return false;
}
//*******************************************************************************************
private boolean checkForLost(int value) {
	if 	(value > 21) 
	{return true;}
	
	return false;
}
//*****************************GAME Procedures*********************************************
private void dealTwoHandsofCards(Deck deck) {
		// TODO Auto-generated method stub


//    try {
//        int numCards = sc.nextInt();
//        if(numCards > 52) {
//          throw new InputMismatchException();
//        }
        deck.shuffle();
		List<Card> dealerHand = new ArrayList<>();
        List<Card> userHand = new ArrayList<>();
        int userValue = 0;
        int dealerValue = 0;
        for(int i = 0; i < 2; i++) { //two cards each
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
private boolean getUserHit(Scanner kb, Deck deck, int userValue) {
	//get score
	boolean exit = false;
	
	
	System.out.println("Stay:");
	System.out.println("Hit:");
	System.out.println("What would you like to do?:");
	String input = kb.next();
	switch(input) {
	case "stay":
	case "Stay":
	case "STAY":
		break;
	case "Hit":
	case "hit":
	case "HIT":
        Card c = deck.dealCard();
        userValue += c.getValue();
        userHand.add(c);
		break;
	}
	exit = checkForWinorLost(userValue);
	
	return exit;
}
/*/***************************************************************************************
private void displayCards() {
	
		System.out.println(Dealer.getHand());
		System.out.println(Hand.getHand());
		
	}
*/
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
/*/*****************************GAME Procedures*********************************************

	private void DealTwoHandsofCards() {
		player.hand = deck.remove;
		player.hand = deck.remove;
		dealer.hand = deck.remove;
		dealer.hand = deck.remove;
		
	}*/
	//*****************************GAME Procedures*********************************************

	private void introduction() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to BlackJack! ");
	}

}