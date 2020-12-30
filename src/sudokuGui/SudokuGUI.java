package sudokuGui;

import solver.MalformedBoardException;
import solver.SudokuSolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGUI extends JFrame {
    private static final int NORMAL_BACKGROUND_WHITE = 0xFFFFFEFE;
    private static final int NORMAL_BACKGROUND_GRAY = 0xFFACAAAA;
    private static final int INVALID_INPUT_BACKGROUND = 0xFFFA4849;
    private static final int BROKEN_RULE_BACKGROUND = 0xFFF3F155;
    private static final int NORMAL_FOREGROUND = 0xFF000000;
    private static final int CLUE_FOREGROUND = 0xFFFA0708;
    private static final int BOARD_SIZE = 9;
    private static final int EMPTY_BOX = -1;
    private static final int INVALID_INPUT = 0;
    private static final int ASCII_1 = 49;
    private static final int ASCII_9 = 57;

    private boolean waitForReset;

    private JPanel mainPanel;
    private JButton SolveBtn;
    private JButton ResetBtn;
    private JTextPane statusField;
    private JTextField R0C0;
    private JTextField R0C1;
    private JTextField R0C2;
    private JTextField R0C3;
    private JTextField R0C4;
    private JTextField R0C5;
    private JTextField R0C6;
    private JTextField R0C7;
    private JTextField R0C8;
    private JTextField R1C0;
    private JTextField R1C1;
    private JTextField R1C2;
    private JTextField R1C3;
    private JTextField R1C4;
    private JTextField R1C5;
    private JTextField R1C6;
    private JTextField R1C7;
    private JTextField R1C8;
    private JTextField R2C0;
    private JTextField R2C1;
    private JTextField R2C2;
    private JTextField R2C3;
    private JTextField R2C4;
    private JTextField R2C5;
    private JTextField R2C6;
    private JTextField R2C7;
    private JTextField R2C8;
    private JTextField R3C0;
    private JTextField R3C1;
    private JTextField R3C2;
    private JTextField R3C3;
    private JTextField R3C4;
    private JTextField R3C5;
    private JTextField R3C6;
    private JTextField R3C7;
    private JTextField R3C8;
    private JTextField R4C0;
    private JTextField R4C1;
    private JTextField R4C2;
    private JTextField R4C3;
    private JTextField R4C4;
    private JTextField R4C5;
    private JTextField R4C6;
    private JTextField R4C7;
    private JTextField R4C8;
    private JTextField R5C0;
    private JTextField R5C1;
    private JTextField R5C2;
    private JTextField R5C3;
    private JTextField R5C4;
    private JTextField R5C5;
    private JTextField R5C6;
    private JTextField R5C7;
    private JTextField R5C8;
    private JTextField R6C0;
    private JTextField R6C1;
    private JTextField R6C2;
    private JTextField R6C3;
    private JTextField R6C4;
    private JTextField R6C5;
    private JTextField R6C6;
    private JTextField R6C7;
    private JTextField R6C8;
    private JTextField R7C0;
    private JTextField R7C1;
    private JTextField R7C2;
    private JTextField R7C3;
    private JTextField R7C4;
    private JTextField R7C5;
    private JTextField R7C6;
    private JTextField R7C7;
    private JTextField R7C8;
    private JTextField R8C0;
    private JTextField R8C1;
    private JTextField R8C2;
    private JTextField R8C3;
    private JTextField R8C4;
    private JTextField R8C5;
    private JTextField R8C6;
    private JTextField R8C7;
    private JTextField R8C8;
    private JTextField[][] textFields;

    public SudokuGUI(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        init();

        SolveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!waitForReset) {
                    SolveBtnAction();
                }
            }
        });

        ResetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResetBtnAction();
                waitForReset = false;
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new SudokuGUI("Sudoku Solver");
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This method initializes the Sudoku GUI fields and modifies
     * the GUI to display an opening message to the user.
     */
    private void init() {
        JTextField[][] textFields = new JTextField[BOARD_SIZE][BOARD_SIZE];
        this.waitForReset = false;

        textFields[0][0] = this.R0C0;
        textFields[0][1] = this.R0C1;
        textFields[0][2] = this.R0C2;
        textFields[0][3] = this.R0C3;
        textFields[0][4] = this.R0C4;
        textFields[0][5] = this.R0C5;
        textFields[0][6] = this.R0C6;
        textFields[0][7] = this.R0C7;
        textFields[0][8] = this.R0C8;
        textFields[1][0] = this.R1C0;
        textFields[1][1] = this.R1C1;
        textFields[1][2] = this.R1C2;
        textFields[1][3] = this.R1C3;
        textFields[1][4] = this.R1C4;
        textFields[1][5] = this.R1C5;
        textFields[1][6] = this.R1C6;
        textFields[1][7] = this.R1C7;
        textFields[1][8] = this.R1C8;
        textFields[2][0] = this.R2C0;
        textFields[2][1] = this.R2C1;
        textFields[2][2] = this.R2C2;
        textFields[2][3] = this.R2C3;
        textFields[2][4] = this.R2C4;
        textFields[2][5] = this.R2C5;
        textFields[2][6] = this.R2C6;
        textFields[2][7] = this.R2C7;
        textFields[2][8] = this.R2C8;
        textFields[3][0] = this.R3C0;
        textFields[3][1] = this.R3C1;
        textFields[3][2] = this.R3C2;
        textFields[3][3] = this.R3C3;
        textFields[3][4] = this.R3C4;
        textFields[3][5] = this.R3C5;
        textFields[3][6] = this.R3C6;
        textFields[3][7] = this.R3C7;
        textFields[3][8] = this.R3C8;
        textFields[4][0] = this.R4C0;
        textFields[4][1] = this.R4C1;
        textFields[4][2] = this.R4C2;
        textFields[4][3] = this.R4C3;
        textFields[4][4] = this.R4C4;
        textFields[4][5] = this.R4C5;
        textFields[4][6] = this.R4C6;
        textFields[4][7] = this.R4C7;
        textFields[4][8] = this.R4C8;
        textFields[5][0] = this.R5C0;
        textFields[5][1] = this.R5C1;
        textFields[5][2] = this.R5C2;
        textFields[5][3] = this.R5C3;
        textFields[5][4] = this.R5C4;
        textFields[5][5] = this.R5C5;
        textFields[5][6] = this.R5C6;
        textFields[5][7] = this.R5C7;
        textFields[5][8] = this.R5C8;
        textFields[6][0] = this.R6C0;
        textFields[6][1] = this.R6C1;
        textFields[6][2] = this.R6C2;
        textFields[6][3] = this.R6C3;
        textFields[6][4] = this.R6C4;
        textFields[6][5] = this.R6C5;
        textFields[6][6] = this.R6C6;
        textFields[6][7] = this.R6C7;
        textFields[6][8] = this.R6C8;
        textFields[7][0] = this.R7C0;
        textFields[7][1] = this.R7C1;
        textFields[7][2] = this.R7C2;
        textFields[7][3] = this.R7C3;
        textFields[7][4] = this.R7C4;
        textFields[7][5] = this.R7C5;
        textFields[7][6] = this.R7C6;
        textFields[7][7] = this.R7C7;
        textFields[7][8] = this.R7C8;
        textFields[8][0] = this.R8C0;
        textFields[8][1] = this.R8C1;
        textFields[8][2] = this.R8C2;
        textFields[8][3] = this.R8C3;
        textFields[8][4] = this.R8C4;
        textFields[8][5] = this.R8C5;
        textFields[8][6] = this.R8C6;
        textFields[8][7] = this.R8C7;
        textFields[8][8] = this.R8C8;

        this.textFields = textFields;
        setDefaultBackground();

        this.statusField.setText("Welcome to my Sudoku Solver! Please enter the clues for " +
                "the puzzle that you wish to solve. When you have entered your clues, simply click " +
                "the solve button!");
    }

    /**
     * This method checks a string input and determines if it
     * is an integer between 1 and 9, if it is empty, or if it
     * is not a valid input for a Sudoku board.
     *
     * @param input The string to be checked.
     *
     * @return If the string is empty, the integer -1 is returned.
     * If the string is an integer between 1 and 9, then the integer
     * contained in the string is returned. Otherwise, the string is
     * considered invalid, and the integer 0 is returned.
     */
    private int checkStringInput(String input) {
        boolean validLength, validInt;
        if (input.isEmpty()) {
            return EMPTY_BOX;
        }

        validLength = (input.length() == 1);
        validInt = (input.charAt(0) >= ASCII_1) && (input.charAt(0) <= ASCII_9);

        if (validLength && validInt) {
            return Character.getNumericValue(input.charAt(0));
        } else {
            return INVALID_INPUT;
        }
    }

    /**
     * This method is the handler for the Solve button's action listener.
     * If the user inputs a valid board configuration, then the solution
     * is displayed on the GUI. Otherwise the user gets a warning message
     * and is asked to change their input.
     */
    private void SolveBtnAction() {
        int[][] inputBoard = new int[BOARD_SIZE][BOARD_SIZE];
        int[][] solution;

        setDefaultBackground();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                inputBoard[i][j] = checkStringInput(textFields[i][j].getText());
            }
        }

        try {
            solution = SudokuSolver.solve(inputBoard);
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (inputBoard[i][j] != EMPTY_BOX) {
                        textFields[i][j].setForeground(new Color(CLUE_FOREGROUND));
                    }
                    textFields[i][j].setText(String.valueOf(solution[i][j]));
                    textFields[i][j].setEditable(false);
                }
            }
            waitForReset = true;
            statusField.setText("Your puzzle has been solved! The above shows the solution. To solve " +
                    "another puzzle, please click the Reset button and re-enter your clues.");
        } catch (MalformedBoardException mbe) {
            if(setInvalidBackground(inputBoard)) {
                statusField.setText("It seems something went wrong with your input clues. Please " +
                        "make sure that all inputs are integer values between 1 and 9 inclusive, and " +
                        "that the input configuration follows the Sudoku rules. Inputs highlighted in " +
                        "red are inputs that are not between 1 and 9. Inputs highlighted in yellow are inputs " +
                        "that are between 1 and 9, but break the Sudoku rules.");
            } else {
                statusField.setText("There is no solution to this clue configuration. Please " +
                        "click the reset button and enter another clue configuration.");
            }
        }
    }

    /**
     * This method is the handler for the Reset button's action listener.
     * The input board is reset to its initial state so the user can input
     * another board configuration.
     */
    private void ResetBtnAction() {
        setDefaultBackground();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                textFields[i][j].setText("");
                textFields[i][j].setForeground(new Color(NORMAL_FOREGROUND));
                textFields[i][j].setEditable(true);
            }
        }
        statusField.setText("Enter your clues and click the solve button " +
                "to solve your next puzzle.");
    }

    /**
     * This method sets the default background for the Sudoku board.
     */
    private void setDefaultBackground() {
        int currentBlock;
        int rowUpperBound, colUpperBound;

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                rowUpperBound = row - (row % 3) + 2;
                colUpperBound = col - (col % 3) + 2;
                currentBlock = ((rowUpperBound + 1) / 3 - 1) + (colUpperBound + 1);

                if (currentBlock % 2 == 0) {
                    textFields[row][col].setBackground(new Color(NORMAL_BACKGROUND_GRAY));
                } else {
                    textFields[row][col].setBackground(new Color(NORMAL_BACKGROUND_WHITE));
                }
            }
        }
    }

    /**
     * This method modifies the background colour that corresponds to
     * invalid inputs and/or invalid input configurations that break
     * the Sudoku rules.
     *
     * Modifies: The JTextFields representing the squares of a
     * Sudoku board.
     *
     * @param board The input board to be checked for invalid inputs.
     *
     * @return Returns true if any of the JTextField backgrounds are changed,
     * and false if none of the backgrounds were changed.
     */
    private boolean setInvalidBackground(int[][] board) {
        int testNum;
        int rowUpperBound, rowLowerBound;
        int colUpperBound, colLowerBound;
        boolean isEdited = false;

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == INVALID_INPUT) {
                    textFields[row][col].setBackground(new Color(INVALID_INPUT_BACKGROUND));
                    isEdited = true;
                } else if (board[row][col] != EMPTY_BOX) {
                    testNum = board[row][col];
                    rowUpperBound = row - (row % 3) + 2;
                    rowLowerBound = rowUpperBound - 2;
                    colUpperBound = col - (col % 3) + 2;
                    colLowerBound = colUpperBound - 2;

                    for (int i = rowLowerBound; i <= rowUpperBound; i++) {
                        for (int j = colLowerBound; j <= colUpperBound; j++) {
                            if ((i != row) || (j != col)) {
                                if (board[i][j] == testNum) {
                                    textFields[row][col].setBackground(new Color(BROKEN_RULE_BACKGROUND));
                                    textFields[i][j].setBackground(new Color(BROKEN_RULE_BACKGROUND));
                                    isEdited = true;
                                }
                            }
                        }
                    }
                    for (int i = 0; i < BOARD_SIZE; i++) {
                        if (i != row) {
                            if (board[i][col] == testNum) {
                                textFields[row][col].setBackground(new Color(BROKEN_RULE_BACKGROUND));
                                textFields[i][col].setBackground(new Color(BROKEN_RULE_BACKGROUND));
                                isEdited = true;
                            }
                        }
                    }
                    for (int j = 0; j < BOARD_SIZE; j++) {
                        if (j != col) {
                            if (board[row][j] == testNum) {
                                textFields[row][col].setBackground(new Color(BROKEN_RULE_BACKGROUND));
                                textFields[row][j].setBackground(new Color(BROKEN_RULE_BACKGROUND));
                                isEdited = true;
                            }
                        }
                    }
                }
            }
        }
        return isEdited;
    }
}
