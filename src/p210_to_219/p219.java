package p210_to_219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Salesforce.
 * <p>
 * Connect 4 is a game where opponents take turns dropping red or black discs into a 7 x 6 vertically suspended grid.
 * The game ends either when one player creates a line of four consecutive discs of their color (horizontally, vertically, or diagonally),
 * or when there are no more spots left in the grid.
 * <p>
 * Design and implement Connect 4.
 */

public class p219 {

    private HashMap<Integer, String> players = new HashMap<>();
    private int[][] board = new int[6][7]; //Rows cols
    private boolean gameOver = false;
    private int turn = 0;
    private int winner = 0;

    public p219() throws IOException {
        players.put(1, "red");
        players.put(2, "black");
        printBoard();
        gameLoop();
    }

    private void gameLoop() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        while (!gameOver) {
            String input = reader.readLine();
            if (input.toLowerCase().equals("quit")) {
                gameOver = true;
                System.out.println("Game Over - Shutting down");
                break;
            }
            int row;
            try {
                row = Integer.parseInt(input);
                if (row > 7 || row < 1 || !checkLegalMove(row - 1)) {
                    throw new Exception("Illegal move");
                }
                play(turn % 2 + 1, row - 1);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    private void play(int playerNbr, int row) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][row] == 0) {
                board[i][row] = playerNbr;
                turn++;
                break;
            }
        }
        gameOver = checkWinningCondition();
        printBoard();
        if (gameOver) {
            System.out.println("GameOver, winner is " + players.get(winner));
        }

    }

    private boolean checkWinningCondition() {
        //TODO these methods could be geniusly combined into one for efficency and less rows of code, but more braintime
        return checkVerticalWin() || checkHorizontalWin() || checkSlopeWin();
    }

    //slopes must start on row 1 2 or 3 to be able to win right
    //slopes must start in middle or before respectively sides
    private boolean checkSlopeWin() {
        int same_in_row_right_to_left = 0;
        int same_in_row_left_to_right = 0;
        int last_nbr_right_eft = 0;
        int last_nbr_left_right = 0;

        for (int offset = 0; offset < board[0].length - 3; offset++) {
            for (int row = 0; row < board.length - 3; row++) {
                for (int col = 0; col < board[0].length - 3; col++) {
                    //left to right
                    int nbrLR = board[row + col][col + offset];
                    if (nbrLR == 0)
                        same_in_row_left_to_right = 0;
                    else {
                        if (nbrLR == last_nbr_left_right) {
                            same_in_row_left_to_right++;
                        } else {
                            same_in_row_left_to_right = 1;
                        }
                        last_nbr_left_right = nbrLR;
                    }
                    if (same_in_row_left_to_right >= 4) {
                        winner = last_nbr_left_right;
                        return true;
                    }
                    //right to left
                    int nbrRL = board[row + col][6-col-offset];
                    if (nbrRL == 0)
                        same_in_row_right_to_left = 0;
                    else {
                        if (nbrRL == last_nbr_right_eft) {
                            same_in_row_right_to_left++;
                        } else {
                            same_in_row_right_to_left = 1;
                        }
                        last_nbr_right_eft = nbrRL;
                    }
                    if (same_in_row_right_to_left >= 4) {
                        winner = last_nbr_right_eft;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkHorizontalWin() {
        int same_in_row = 0;
        int last_nbr = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int nbr = board[i][j];
                if (nbr == 0) {
                    same_in_row = 0;
                } else {
                    if (nbr == last_nbr) {
                        same_in_row++;
                    } else {
                        same_in_row = 1;
                    }
                    last_nbr = nbr;
                }
                if (same_in_row >= 4) {
                    winner = last_nbr;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin() {
        int same_in_row = 0;
        int last_nbr = 0;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                int nbr = board[j][i];
                if (nbr == 0) {
                    same_in_row = 0;
                } else {
                    if (nbr == last_nbr) {
                        same_in_row++;
                    } else {
                        same_in_row = 1;
                    }
                    last_nbr = nbr;
                }
                if (same_in_row >= 4) {
                    winner = last_nbr;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLegalMove(int col) {
        if (board[5][col] == 0) {
            return true;
        }
        return false;
    }

    private void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[6 - row - 1][col] + " ");
            }
            System.out.println();
        }
        if (!gameOver)
            System.out.println(players.get(turn % 2 + 1) + "'s turn");
    }

}
