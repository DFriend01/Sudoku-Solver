# Sudoku Solver GUI
This repository contains source code that implements a sudoku solver GUI using the 
[Java Swing API](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html). 

![Image of GUI](/Images/intro_img.PNG)

##Setup

Clone this repository and create a new java project with the existing source files. Upon 
creating the project, you may see that JUnit cannot be accessed by your IDE. Do one
of the following:

1. Add the JUnit4 classpath to your project.
2. Delete the test folder inside the src folder.

Finally, run `SudokuGUI.main(String[] args)` to start the GUI.

##Usage

To solve a sudoku puzzle, enter your clues in the provided boxes. Clues must be 
integers between 1 and 9 inclusive, and the clue configuration must follow the
[sudoku rules](https://sudoku.com/how-to-play/sudoku-rules-for-complete-beginners/).

When the clue configuration is complete, click the **Solve** button to get the solution.

![Solve Button Image](/Images/solve_img.PNG)

If the clue configuration is correct, the solution will be displayed, and
the original clues are highlighted in red. To clear the boxes and solve
another sudoku puzzle, click the **Reset** button.

![Reset Button Image](/Images/reset_img.PNG)

If there is an input that is not an integer between 1 and 9, that box will be
highlighted in red when the **Solve** button is clicked.

![Error](/Images/error_img.PNG)

If there are inputs that are integers between 1 and 9, but the sudoku rules are
broken from the input, those boxes are highlighted in yellow when the **Solve**
button is clicked.

![Broken Rule Image](/Images/broken_rule_img.PNG)