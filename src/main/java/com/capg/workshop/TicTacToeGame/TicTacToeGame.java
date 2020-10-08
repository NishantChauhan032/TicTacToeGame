package com.capg.workshop.TicTacToeGame;

import java.util.Scanner;

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);

	private static final char CHAR_X = 'X';
	private static final char CHAR_O = 'O';

	public static void main(String[] args) {

		createBoard();
		char playerChoice = sc.next().charAt(0);
		computerChoice(playerChoice);
		printBoard();
	}

	static char[] ticTacBoard;

	public static char[] createBoard() {
		ticTacBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			ticTacBoard[i] = ' ';
		}
		return ticTacBoard;
	}

	public static char computerChoice(char playerChoice) {
		char computerChoice;
		if (playerChoice == CHAR_X) {
			computerChoice = CHAR_O;
		} else {
			computerChoice = CHAR_O;
		}
		return computerChoice;
	}

	public static void printBoard() {
		System.out.println(" " + ticTacBoard[1] + " | " + ticTacBoard[2] + " | " + ticTacBoard[3]);
		System.out.println("-----------");
		System.out.println(" " + ticTacBoard[4] + " | " + ticTacBoard[5] + " | " + ticTacBoard[6]);
		System.out.println("-----------");
		System.out.println(" " + ticTacBoard[7] + " | " + ticTacBoard[8] + " | " + ticTacBoard[9]);
	}
}
