package tictactoe.matialabs.com.tictactoe;

public class ProcessGame {
    /**
     * Checks if symbol has won (col -> row -> slants)
     *
     * @param symbol X or O - checks to see if symbol won
     * @return true for win, false for no win
     */
    private static int[][] board = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};

    public static void update2DGameState(int[] gameState) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = gameState[counter];
                System.out.print(gameState[counter] + " ");
                counter++;
            }
            System.out.println();
        }
    }


    public static boolean win(int symbol) {

        if (row(0, symbol) || row(1, symbol) || row(2, symbol) || col(0, symbol) || col(1, symbol) || col(2, symbol) || mainSlant(symbol) || secondSlant(symbol)) {
            return true;
        }
        return false;

    }


    /**
     * Checks for row win
     *
     * @param row    the row to check for three in a row
     * @param symbol the symbol to look for three in a row
     * @return Return true if three in a *row* is found
     */
    private static boolean row(int row, int symbol) {
        for (int j = 0; j < board[row].length; j++) {
            if (board[row][j] != symbol) {
                return false;
            }
        }
        return true;

    }


    /**
     * Checks for col win
     *
     * @param col    the row to check for three in a col
     * @param symbol the symbol to look for three in a col
     * @return Return true if three in a *col* is found
     */
    private static boolean col(int col, int symbol) {
        for (int j = 0; j < board.length; j++) {
            if (board[j][col] != symbol) {
                return false;
            }
        }
        return true;

    }

    /**
     * Checks for main Slant win
     *
     * @param symbol the symbol to look for three in a slant
     * @return Return true if three in a *slant* is found
     */
    private static boolean mainSlant(int symbol) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != symbol) {
                return false;
            }
        }
        return true;

    }

    /**
     * Checks for second slant win
     *
     * @param symbol the symbol to look for the three in a row
     * @return Return true if three in a *second slant* is found
     */
    private static boolean secondSlant(int symbol) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - i - 1] != symbol) {
                return false;
            }
        }
        return true;
    }
}

