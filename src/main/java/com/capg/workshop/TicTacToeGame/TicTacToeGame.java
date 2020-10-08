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
		int index = sc.nextInt();
		playerMove(index, playerChoice);
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
	// UC4
		public static int selectIndex(int index) {
			while (!(index > 0 && index < 10)) {
				System.out.println("Enter proper index value between 1 to 9");
				index = sc.nextInt();
			}

			return index;
		}

		public static int checkForFreeSpace(int index) {
			index = selectIndex(index);
			while (ticTacBoard[index] != ' ') {
				System.out.println("Sorry,Position is already filled,Enter new position.");
				index = sc.nextInt();
			}
			return index;
		}

		// UC5
		public static void playerMove(int index, char choice) {
			index = checkForFreeSpace(index);
			ticTacBoard[index] = choice;
		}
	}

