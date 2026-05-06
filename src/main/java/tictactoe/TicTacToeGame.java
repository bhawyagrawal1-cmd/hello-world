package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        initializeBoard(board);
        GameState gameState = tossToStart(random);

        printBoard(board);
        printGameState(gameState);
        int slot = readSlot(input);
        int[] indices = convertSlotToIndices(slot);
        boolean validMove = isValidMove(board, indices[0], indices[1]);
        System.out.println("Selected Slot: " + slot);
        System.out.println("Row: " + indices[0] + ", Column: " + indices[1]);
        System.out.println("Move Valid: " + validMove);
        input.close();
    }

    static void initializeBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = '-';
            }
        }
    }

    static void printBoard(char[][] board) {
        System.out.println("Tic-Tac-Toe Board:");

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column]);

                if (column < board[row].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    static GameState tossToStart(Random random) {
        boolean humanStarts = random.nextBoolean();

        String currentPlayer = humanStarts ? "Human" : "Computer";
        char humanSymbol = humanStarts ? 'X' : 'O';
        char computerSymbol = humanStarts ? 'O' : 'X';

        return new GameState(currentPlayer, humanSymbol, computerSymbol);
    }

    static void printGameState(GameState gameState) {
        System.out.println("Toss Result:");
        System.out.println("Human Symbol: " + gameState.humanSymbol);
        System.out.println("Computer Symbol: " + gameState.computerSymbol);
        System.out.println("First Turn: " + gameState.currentPlayer);
    }

    static int readSlot(Scanner input) {
        while (true) {
            System.out.print("Enter a slot number (1-9): ");
            int slot = input.nextInt();

            if (slot >= 1 && slot <= 9) {
                return slot;
            }

            System.out.println("Invalid slot. Please enter a number between 1 and 9.");
        }
    }

    static int[] convertSlotToIndices(int slot) {
        int row = (slot - 1) / 3;
        int column = (slot - 1) % 3;

        return new int[] {row, column};
    }

    static boolean isValidMove(char[][] board, int row, int column) {
        boolean isWithinBounds = row >= 0 && row < board.length
                && column >= 0 && column < board[row].length;

        if (!isWithinBounds) {
            return false;
        }

        return board[row][column] == '-';
    }

    static class GameState {
        String currentPlayer;
        char humanSymbol;
        char computerSymbol;

        GameState(String currentPlayer, char humanSymbol, char computerSymbol) {
            this.currentPlayer = currentPlayer;
            this.humanSymbol = humanSymbol;
            this.computerSymbol = computerSymbol;
        }
    }
}
