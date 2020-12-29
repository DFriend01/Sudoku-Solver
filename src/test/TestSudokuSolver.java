package test;

import solver.MalformedBoardException;
import solver.SudokuSolver;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSudokuSolver {

    @Test(expected = MalformedBoardException.class)
    public void testException1() throws MalformedBoardException {
        int[][] testBoard = {
                {-1, -1, -1},
                {6, 8, -1},
                {-1, -1, 3},
                {-1, 4, -1},
                {-1, -1, -1},
                {-1, 9, -1},
                {4, -1, 9},
                {1, 6, 2},
                {5, -1, -1}};

        int[][] solution = SudokuSolver.solve(testBoard);
    }

    @Test(expected = MalformedBoardException.class)
    public void testException2() throws MalformedBoardException {
        int[][] testBoard = {
                {-1, -1, -1, 6, -1, -1, 1, -1, 7},
                {6, 8, -1, 9, 5, 1, 3, -1, -1},
                {-1, -1, 3, -1, -1, 2, 5, 6, 8},
                {-1, 4, -1, 8, 1, -1, -1, 2, -1}};

        int[][] solution = SudokuSolver.solve(testBoard);
    }

    @Test(expected = MalformedBoardException.class)
    public void testException3() throws MalformedBoardException {
        int[][] testBoard = {
                {6, -1, -1, 6, -1, -1, 1, -1, 7},
                {6, 8, -1, 9, 5, 1, 3, -1, -1},
                {-1, -1, 3, -1, -1, 2, 5, 6, 8},
                {-1, 4, -1, 8, 1, -1, -1, 2, -1},
                {-1, -1, -1, -1, -1, -1, 8, 5, -1},
                {-1, 9, -1, -1, 6, 5, -1, 7, 3},
                {4, -1, 9, -1, -1, 3, -1, 8, 5},
                {1, 6, 2, -1, -1, 9, -1, 3, -1},
                {5, -1, -1, 7, -1, 6, -1, -1, -1}};

        int[][] solution = SudokuSolver.solve(testBoard);
    }

    @Test(expected = MalformedBoardException.class)
    public void testException4() throws MalformedBoardException {
        int[][] testBoard = {
                {-1, -1, -1, 6, -1, -1, 1, -1, 7},
                {6, 8, -1, 9, 5, 1, 3, -1, -1},
                {-1, -1, 3, -1, -1, 2, 5, 6, 8},
                {-1, 4, -1, 8, 1, -1, -1, 2, -1},
                {-1, -1, -1, -1, -1, -1, 8, 5, -1},
                {-1, 9, -1, -1, 6, 5, -1, 7, 3},
                {4, -1, 9, -1, -1, 3, -1, 8, 5},
                {1, 6, 2, -1, -1, 9, -1, 3, -1},
                {5, -1, -1, 7, 9, 6, -1, -1, -1}};

        int[][] solution = SudokuSolver.solve(testBoard);
    }

    @Test
    public void testSolver1() throws MalformedBoardException {
        int[][] testBoard = {
                {-1, -1, -1, 6, -1, -1, 1, -1, 7},
                {6, 8, -1, 9, 5, 1, 3, -1, -1},
                {-1, -1, 3, -1, -1, 2, 5, 6, 8},
                {-1, 4, -1, 8, 1, -1, -1, 2, -1},
                {-1, -1, -1, -1, -1, -1, 8, 5, -1},
                {-1, 9, -1, -1, 6, 5, -1, 7, 3},
                {4, -1, 9, -1, -1, 3, -1, 8, 5},
                {1, 6, 2, -1, -1, 9, -1, 3, -1},
                {5, -1, -1, 7, -1, 6, -1, -1, -1}};

        int[][] solution = {
                {2, 5, 4, 6, 3, 8, 1, 9, 7},
                {6, 8, 7, 9, 5, 1, 3, 4, 2},
                {9, 1, 3, 4, 7, 2, 5, 6, 8},
                {3, 4, 5, 8, 1, 7, 9, 2, 6},
                {7, 2, 6, 3, 9, 4, 8, 5, 1},
                {8, 9, 1, 2, 6, 5, 4, 7, 3},
                {4, 7, 9, 1, 2, 3, 6, 8, 5},
                {1, 6, 2, 5, 8, 9, 7, 3, 4},
                {5, 3, 8, 7, 4, 6, 2, 1, 9}};

        assertArrayEquals(solution, SudokuSolver.solve(testBoard));
    }

    @Test
    public void testSolver2() throws MalformedBoardException {
        int[][] testBoard = {
                {2, 5, 4, 6, 3, 8, 1, 9, 7},
                {6, 8, 7, 9, 5, 1, 3, 4, 2},
                {9, 1, 3, 4, 7, 2, 5, 6, 8},
                {3, 4, 5, 8, 1, 7, 9, 2, 6},
                {7, 2, 6, 3, 9, 4, 8, 5, 1},
                {8, 9, 1, 2, 6, 5, 4, 7, 3},
                {4, 7, 9, 1, 2, 3, 6, 8, 5},
                {1, 6, 2, 5, 8, 9, 7, 3, 4},
                {5, 3, 8, 7, 4, 6, 2, 1, 9}};

        assertArrayEquals(testBoard, SudokuSolver.solve(testBoard));
    }

    @Test
    public void testSolver3() throws MalformedBoardException {
        int[][] testBoard = {
                {8, -1, -1, -1, -1, -1, -1, 5, -1},
                {-1, -1, -1, 4, -1, -1, -1, 7, -1},
                {6, -1, 3, 5, -1, 2, 4, 1, 9},
                {-1, -1, -1, -1, 7, -1, 5, 2, 4},
                {-1, -1, -1, 6, -1, 4, -1, -1, -1},
                {-1, -1, 7, -1, 5, 9, -1, -1, -1},
                {-1, 2, 6, -1, -1, 1, -1, -1, -1},
                {-1, 8, -1, -1, -1, -1, 2, 9, 6},
                {7, -1, 9, -1, -1, -1, -1, -1, -1}
        };

        int[][] solution = {
                {8, 9, 4, 3, 1, 7, 6, 5, 2},
                {1, 5, 2, 4, 9, 6, 8, 7, 3},
                {6, 7, 3, 5, 8, 2, 4, 1, 9},
                {9, 6, 8, 1, 7, 3, 5, 2, 4},
                {3, 1, 5, 6, 2, 4, 9, 8, 7},
                {2, 4, 7, 8, 5, 9, 3, 6, 1},
                {5, 2, 6, 9, 4, 1, 7, 3, 8},
                {4, 8, 1, 7, 3, 5, 2, 9, 6},
                {7, 3, 9, 2, 6, 8, 1, 4, 5}
        };

        assertArrayEquals(solution, SudokuSolver.solve(testBoard));
    }
}
