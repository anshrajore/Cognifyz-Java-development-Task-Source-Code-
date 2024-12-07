//Level 2 Task 1 TicTacToe
import java.util.Scanner;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        boolean playAgain = true;

        while (playAgain) {
            initializeBoard(board);
            char currentPlayer = PLAYER_X;
            boolean gameWon = false;

            System.out.println("Welcome to Tic-Tac-Toe!");
            displayBoard(board);

            for (int moves = 0; moves < 9; moves++) {
                System.out.println("Player " + currentPlayer + "'s turn:");
                makeMove(scanner, board, currentPlayer);
                displayBoard(board);

                if (checkWin(board, currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                    break;
                }

                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }

            if (!gameWon) {
                System.out.println("It's a draw!");
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void displayBoard(char[][] board) {
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("---|---|---");
            }
        }
    }

    private static void makeMove(Scanner scanner, char[][] board, char player) {
        int row, col;
        while (true) {
            System.out.print("Enter row (1-3) and column (1-3): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
                board[row][col] = player;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
