package tictactoe;

import java.util.Random;

public class TicTacToeGame {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Random random = new Random();

        initializeBoard(board);
        GameState gameState = tossToStart(random);

        printBoard(board);
        printGameState(gameState);
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
