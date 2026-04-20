package tictactoe;

public class TicTacToeGame {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        initializeBoard(board);
        printBoard(board);
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
}
