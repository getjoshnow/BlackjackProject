package com.skilldistillery.enums.drills.cards;

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
			
				do { // Enter a set Game
					//invite user to play give them money
					//Shuffle deck
					
					do { // Enter Hand Game;
					dealTwoHandsofCards();
					displayCards();
					winOrLose = checkForWinner(userHand, dealerHand);
						do { // allows user to hit or fold until satisfied.
							boolean	hitOrFold = false;	
							getUserHit(kb);
							displayCards();
							winOrLose = checkForWinner(userHand);
						}while(!hitOrFold);

						if(!winOrLose) {
							do { // allows user to hit or fold until satisfied.
									boolean	dealWinOrLose = false;	
									dealerUserHit();
									displayCards();
									winOrLose = checkForWinner(dealerHand);
							   }while(!dealWinorLose);
						}
						displayWinner();
					}while(!quit);
					
				}while(!playAgain());
	}
	}private void introduction() {
	// TODO Auto-generated method stub
	
}
	}}					
//*****************************GAME Procedures*********************************************

	private void DealTwoHandsofCards() {
		// TODO Auto-generated method stub

	}

	private void introduction() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to BlackJack! ");
	}
}