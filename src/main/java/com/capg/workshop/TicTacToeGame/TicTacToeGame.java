package com.capg.workshop.TicTacToeGame;

import java.util.Scanner;

enum FirstPlay {
	PLAYER, COMPUTER;
}

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);

	private static final char CHAR_X = 'X';
	private static final char CHAR_O = 'O';
	private static final int TAILS = 0;

	public static void main(String[] args) {

		createBoard();
		System.out.println("Please select your choice(X/O):");
		char playerChoice = sc.next().charAt(0);
		char computerChoice = computerChoice(playerChoice);
		String player = getWhoPlaysFirst();
		System.out.println("First Chance given to: " + player);
		String gameStatus = checkGameStatus(ticTacToeBoard,playerChoice);
		String showFinalResult = "Lets Play The Game!";
		while (gameStatus.equals("CHANGE")) {
			if (player.equals("PLAYER")) {
				System.out.println("Please select a position(1-9): ");
				int index = sc.nextInt();
				playerMove(index, playerChoice);
				gameStatus = checkGameStatus(ticTacToeBoard,playerChoice);
				if (gameStatus.equals("WIN")) {
					showFinalResult = "Player Won the match!";
				} else if (gameStatus.equals("TIE")) {
					showFinalResult = "Match Tied!Better Luck Next Time..";
				} else {
					player = "COMPUTER";
				}
				showBoard();
			} else {
				System.out.println("Computer played. Look for your next move! ");
				int index = checkComputerChance(computerChoice,playerChoice);
				playerMove(index, computerChoice);
				gameStatus = checkGameStatus(ticTacToeBoard,computerChoice);
				if (gameStatus.equals("WIN")) {
					showFinalResult = "Computer Won The Match!";
				} else if (gameStatus.equals("TIE")) {
					showFinalResult = "Match Tied!Better Luck Next Time";
				} else {
					player = "PLAYER";
				}
				showBoard();
			}
		}
		System.out.println("MATCH RESULT : " + showFinalResult);
	}

	static char[] ticTacToeBoard;

	/**
	 * UC1
	 * 
	 * @return
	 */
	public static char[] createBoard() {
		ticTacToeBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			ticTacToeBoard[i] = ' ';
		}
		return ticTacToeBoard;
	}

	/**
	 * UC2
	 * 
	 * @param playerChoice
	 * @return
	 */
	public static char computerChoice(char playerChoice) {
		char computerChoice;
		if (playerChoice == CHAR_X) {
			computerChoice = CHAR_O;
		} else {
			computerChoice = CHAR_O;
		}
		return computerChoice;
	}

	/**
	 * UC3
	 * 
	 */
	public static void showBoard() {
		System.out.println(" " + ticTacToeBoard[1] + " | " + ticTacToeBoard[2] + " | " + ticTacToeBoard[3]);
		System.out.println("-----------");
		System.out.println(" " + ticTacToeBoard[4] + " | " + ticTacToeBoard[5] + " | " + ticTacToeBoard[6]);
		System.out.println("-----------");
		System.out.println(" " + ticTacToeBoard[7] + " | " + ticTacToeBoard[8] + " | " + ticTacToeBoard[9]);
	}

	/**
	 * UC4
	 * 
	 * @param index
	 * @return
	 */
	public static int selectIndex(int index) {
		while (!(index > 0 && index < 10)) {
			System.out.println("Enter proper index value between 1 to 9");
			index = sc.nextInt();
		}

		return index;
	}

	public static int checkForFreeSpace(int index) {
		index = selectIndex(index);
		while (ticTacToeBoard[index] != ' ') {
			System.out.println("Sorry,Position is already filled,Enter new position.");
			index = sc.nextInt();
		}
		return index;
	}

	/**
	 * UC5
	 * 
	 * @param index
	 * @param choice
	 */
	public static void playerMove(int index, char choice) {
		index = checkForFreeSpace(index);
		ticTacToeBoard[index] = choice;
	}

	/**
	 * UC6
	 * 
	 * @return
	 */
	private static String getWhoPlaysFirst() {
		int toss = (int) Math.floor((Math.random() * 10) % 2);
		if (toss == TAILS) {
			return FirstPlay.COMPUTER.toString();
		} else {
			return FirstPlay.PLAYER.toString();
		}
	}

	// UC7
	public static boolean checkForTie() {
		boolean isTie = true;
		for (int i = 1; i < 10; i++) {
			if (ticTacToeBoard[i] == ' ') {
				isTie = false;
			}
		}
		return isTie;
	}

	public static String checkGameStatus(char[] ticTacToeBoard,char choice) {
		String gameStatus;
		if ((ticTacToeBoard[1] == choice && ticTacToeBoard[2] == choice && ticTacToeBoard[3] == choice)
				|| (ticTacToeBoard[4] == choice && ticTacToeBoard[5] == choice && ticTacToeBoard[6] == choice)
				|| (ticTacToeBoard[7] == choice && ticTacToeBoard[8] == choice && ticTacToeBoard[9] == choice)
				|| (ticTacToeBoard[1] == choice && ticTacToeBoard[4] == choice && ticTacToeBoard[7] == choice)
				|| (ticTacToeBoard[2] == choice && ticTacToeBoard[5] == choice && ticTacToeBoard[8] == choice)
				|| (ticTacToeBoard[3] == choice && ticTacToeBoard[6] == choice && ticTacToeBoard[9] == choice)
				|| (ticTacToeBoard[1] == choice && ticTacToeBoard[5] == choice && ticTacToeBoard[9] == choice)
				|| (ticTacToeBoard[3] == choice && ticTacToeBoard[5] == choice && ticTacToeBoard[7] == choice)) {
			gameStatus = "WIN";
		} else if (checkForTie()) {
			gameStatus = "TIE";
		} else {
			gameStatus = "CHANGE";
		}
		return gameStatus;
	}
	/**UC8 && UC9 && UC10
	 * @param choiceOfComputer
	 * @param choiceOfPlayer
	 * @return
	 */
	public static int checkComputerChance(char choiceOfComputer, char choiceOfPlayer) {
		char[] ticTacToeBoardCopy = new char[10];
		for (int i = 0; i < 10; i++) {
			ticTacToeBoardCopy[i] = ticTacToeBoard[i];
		}
		int checkIndex = 0;
		for (int i = 0; i < 10; i++) {
			if (ticTacToeBoardCopy[i] == ' ') {
				ticTacToeBoardCopy[i] = choiceOfComputer;
				String checkStatus = checkGameStatus(ticTacToeBoardCopy,choiceOfComputer);
				if (checkStatus.contains("WIN")) {
					checkIndex = i;
					break;
				}else {
					ticTacToeBoardCopy[i] = choiceOfPlayer;
					checkStatus = checkGameStatus(ticTacToeBoardCopy,choiceOfPlayer);
					if (checkStatus.contains("WIN")) {
						checkIndex = i;
					}
				}
				ticTacToeBoardCopy[i] = ' ';
			}
		}
		if (checkIndex == 0) {
            if (ticTacToeBoardCopy[1] == ' ') {
                checkIndex = 1;
            } else if (ticTacToeBoardCopy[3] == ' ') {
                checkIndex = 3;
            } else if (ticTacToeBoardCopy[7] == ' ') {
                checkIndex = 7;
            } else if (ticTacToeBoardCopy[9] == ' ') {
                checkIndex = 9;
            } else {
                for (int j = 1; j < 10; j++) { 
                    if (ticTacToeBoardCopy[j] == ' ') {
                        checkIndex = j;
                        break;
                    }
                }
            }
        }
        return checkIndex;
    }
}


