package solver;

public class SudokuSolver {

    private static final int BOARD_SIZE = 9;
    private static final int EMPTY_SPOT_FLAG = -1;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    /**
     * This method takes a 2D array of integers that represents an initially
     * unsolved Sudoku board with clues. The input board is used to solve
     * the Sudoku puzzle and a 2D array of integers representing the solution
     * is returned.
     *
     * @param board A 2D array of integers representing the input Sudoku board
     * to be solved. The input board must be 9x9, and the clues that are contained
     * in the input board must follow Sudoku rules; all integers must be between
     * 1 and 9 inclusive. Empty spots must be represented using the integer -1.
     *
     * @return A 2D array of integers representing the solution to the
     * input Sudoku board.
     *
     * @throws MalformedBoardException This exception is thrown if the
     * input board does not have a valid board configuration.
     */
    public static int[][] solve(int[][] board) throws MalformedBoardException {
        checkInputBoard(board);
        int[][] modifiedBoard = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                modifiedBoard[i][j] = board[i][j];
            }
        }
        searchSolution(modifiedBoard, 0, 0);
        return modifiedBoard;
    }

    /**
     * This is a recursive helper method for the solve method. This
     * method modifies the input "board" until a solution is determined
     * by the rules of Sudoku.
     *
     * @param board      The board to be modified and checked for solutions.
     * @param currentRow The current row of the board being operated on.
     * @param currentCol The current column of the board being operated on.
     * @return Returns true if a solution has been found, and false otherwise.
     */
    private static boolean searchSolution(int[][] board, int currentRow, int currentCol) {
        int row = currentRow;
        int col = currentCol;
        int nextRow, nextCol;

        while ((row < BOARD_SIZE) && (board[row][col] != EMPTY_SPOT_FLAG)) {
            if (col < BOARD_SIZE - 1) {
                col++;
            } else {
                row++;
                col = 0;
            }
        }

        if (col < BOARD_SIZE - 1) {
            nextRow = row;
            nextCol = col + 1;
        } else {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (row < BOARD_SIZE) {
            for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
                if (isValidBoardConfig(board, row, col, i)) {
                    board[row][col] = i;

                    if (searchSolution(board, nextRow, nextCol)) {
                        return true;
                    } else {
                        board[row][col] = EMPTY_SPOT_FLAG;
                    }
                }
            }
            return false;
        }
        return true;
    }

    /**
     * This method tests if an integer value "testNum" creates a valid
     * board configuration when testNum is placed at board[currentRow][currentCol].
     *
     * @param board      The board to be checked.
     * @param currentRow The current row where the check is done.
     * @param currentCol The current column where the check is done.
     * @param testNum    An integer value between 1 and 9 inclusive that
     *                   is tested for a valid board configuration.
     *
     * @return Returns true if the inserted value "testNum" makes a
     * valid board configuration following the Sudoku Rules, and false
     * otherwise.
     */
    private static boolean isValidBoardConfig(int[][] board, int currentRow, int currentCol, int testNum) {
        int rowUpperBound = currentRow - (currentRow % 3) + 2;
        int rowLowerBound = rowUpperBound - 2;
        int colUpperBound = currentCol - (currentCol % 3) + 2;
        int colLowerBound = colUpperBound - 2;

        for (int i = rowLowerBound; i <= rowUpperBound; i++) {
            for (int j = colLowerBound; j <= colUpperBound; j++) {
                if ((i != currentRow) || (j != currentCol)) {
                    if (board[i][j] == testNum) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i != currentRow) {
                if (board[i][currentCol] == testNum) {
                    return false;
                }
            }
        }
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (j != currentCol) {
                if (board[currentRow][j] == testNum) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method checks if an input board is valid. A valid input
     * board must be an integer 2D array that is 9x9. All filled
     * spots must contain an integer between 1 and 9; empty spots
     * are represented using the integer -1. Finally, the configuration
     * of clues must follow the Sudoku rules.
     *
     * @param board A 2D array of integers to be checked for a valid
     *              clue configuration.
     *
     * @throws MalformedBoardException This exception is thrown when the
     *                                 input board does not have a valid configuration.
     */
    private static void checkInputBoard(int[][] board) throws MalformedBoardException {
        boolean validBoardConfig;
        boolean validInteger;
        boolean isEmptySpot;

        if ((board.length != BOARD_SIZE) || (board[0].length != BOARD_SIZE)) {
            throw new MalformedBoardException();
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                validBoardConfig = (board[i][j] != EMPTY_SPOT_FLAG) && (isValidBoardConfig(board, i, j, board[i][j]));
                validInteger = (board[i][j] == EMPTY_SPOT_FLAG) || ((board[i][j] >= 1) && (board[i][j] <= 9));
                isEmptySpot = (board[i][j] == EMPTY_SPOT_FLAG);

                if (!(validBoardConfig || isEmptySpot) || !validInteger) {
                    throw new MalformedBoardException();
                }
            }
        }
    }
}
