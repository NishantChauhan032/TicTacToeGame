package com.capg.workshop.TicTacToeGame;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);
	private static final char CHAR_X='X';
	private static final char CHAR_O='O';

	public static char[] createBoard() {
		char[] ticTacToeBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			ticTacToeBoard[i] = ' ';
		}
		return ticTacToeBoard;
	}
	public static char playerChoice(char playerChoice) {
		char computerChoice;
		if(playerChoice == CHAR_X ) {
			System.out.println("User Choice : X && Computer : O");
			computerChoice = CHAR_O;
		}else {
			System.out.println("User Choice : X && Computer : O");
			computerChoice = CHAR_X;	
		}
		return computerChoice;
	}

	public static void main(String[] args) {
		createBoard();
		System.out.println("Enter your choice 'X' or 'O'"); 
		playerChoice(sc.next().charAt(0));
	}
}
