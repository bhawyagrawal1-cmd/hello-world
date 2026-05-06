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

        printGameState(gameState);
        runGameLoop(board, gameState, input, random);
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

    static void placeMove(char[][] board, int row, int column, char symbol) {
        board[row][column] = symbol;
    }

    static int makeComputerMove(char[][] board, char computerSymbol, Random random) {
        while (true) {
            int slot = random.nextInt(9) + 1;
            int[] indices = convertSlotToIndices(slot);

            if (isValidMove(board, indices[0], indices[1])) {
                placeMove(board, indices[0], indices[1], computerSymbol);
                return slot;
            }
        }
    }

    static void runGameLoop(char[][] board, GameState gameState, Scanner input, Random random) {
        while (true) {
            printBoard(board);

            char currentSymbol = getCurrentSymbol(gameState);

            if ("Human".equals(gameState.currentPlayer)) {
                int slot = readSlot(input);
                int[] indices = convertSlotToIndices(slot);

                if (!isValidMove(board, indices[0], indices[1])) {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }

                placeMove(board, indices[0], indices[1], currentSymbol);
                System.out.println("Selected Slot: " + slot);
            } else {
                int slot = makeComputerMove(board, currentSymbol, random);
                int[] indices = convertSlotToIndices(slot);
                System.out.println("Computer Selected Slot: " + slot);
                System.out.println("Computer Row: " + indices[0] + ", Column: " + indices[1]);
            }

            if (hasWinner(board, currentSymbol)) {
                printBoard(board);
                System.out.println(gameState.currentPlayer + " wins!");
                break;
            }

            if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("The game is a draw.");
                break;
            }

            switchTurn(gameState);
        }
    }

    static char getCurrentSymbol(GameState gameState) {
        if ("Human".equals(gameState.currentPlayer)) {
            return gameState.humanSymbol;
        }

        return gameState.computerSymbol;
    }

    static void switchTurn(GameState gameState) {
        if ("Human".equals(gameState.currentPlayer)) {
            gameState.currentPlayer = "Computer";
        } else {
            gameState.currentPlayer = "Human";
        }
    }

    static boolean hasWinner(char[][] board, char symbol) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol) {
                return true;
            }
        }

        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column] == symbol && board[1][column] == symbol && board[2][column] == symbol) {
                return true;
            }
        }

        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
                || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == '-') {
                    return false;
                }
            }
        }

        return true;
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
