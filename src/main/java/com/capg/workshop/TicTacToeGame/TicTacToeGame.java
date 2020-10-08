package com.capg.workshop.TicTacToeGame;

import java.util.Scanner;

public class TicTacToeGame {
   static Scanner sc = new Scanner(System.in);
	
	
	
	public static char[] createBoard() {
		char[] ticTacToeBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			ticTacToeBoard[i] = ' ';
		}
		return ticTacToeBoard;
	}
}

