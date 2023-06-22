package GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.security.SecureRandom;
import java.util.*;

public class Environment {
    // Default size for the environment.
    private static final int DEFAULT_ROWS = 50;
    private static final int DEFAULT_COLS = 50;
    private Color currentColorForDead = Color.WHITE;
    private Color currentColorForAliveCells = Color.BLACK;

    // The grid of cells.
    private Cell[][] cells;
    // Visualization of the environment.
    private final EnvironmentView view;

    /**
     * Create an environment with the default size.
     */
    public Environment() {
        this(DEFAULT_ROWS, DEFAULT_COLS);
    }

    /**
     * Create an environment with the given size.
     *
     * @param numRows The number of rows.
     * @param numCols The number of cols;
     */
    public Environment(int numRows, int numCols) {
        setup(numRows, numCols);
        randomize();
        view = new EnvironmentView(this, numRows, numCols);
        view.showCells();
    }

    /**
     * Run the automaton for one step.
     */
    public void step() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        // Build a record of the next state of each cell.
        int[][] nextStates = new int[numRows][numCols];
        // Ask each cell to determine its next state.
        for (int row = 0; row < numRows; row++) {
            int[] rowOfStates = nextStates[row];
            for (int col = 0; col < numCols; col++) {
                rowOfStates[col] = cells[row][col].getNextState();
            }
        }
        // Update the cells' states.
        for (int row = 0; row < numRows; row++) {
            int[] rowOfStates = nextStates[row];
            for (int col = 0; col < numCols; col++) {
                setCellState(row, col, rowOfStates[col]);
            }
        }
    }

    /**
     * Reset the state of the automaton to all DEAD.
     */
    public void reset() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                setCellState(row, col, Cell.DEAD);
            }
        }
    }

    public void Blume(){
        setCellState(16 + 1, 26 + 2, Cell.ALIVE);
        setCellState(16 + 1, 25 + 2, Cell.ALIVE);
        setCellState(15 + 1, 26 + 2, Cell.ALIVE);
        setCellState(15 + 1, 27 + 2, Cell.ALIVE);
        setCellState(14 + 1, 26 + 2, Cell.ALIVE);
        setCellState(13 + 1, 27 + 2, Cell.ALIVE);
        setCellState(13 + 1, 28 + 2, Cell.ALIVE);
        setCellState(14 + 1, 28 + 2, Cell.ALIVE);
        setCellState(12 + 1, 28 + 2, Cell.ALIVE);
        setCellState(11 + 1, 27 + 2, Cell.ALIVE);
        setCellState(11 + 1, 26 + 2, Cell.ALIVE);
        setCellState(11 + 1, 25 + 2, Cell.ALIVE);
        setCellState(12 + 1, 26 + 2, Cell.ALIVE);
        setCellState(13 + 1, 25 + 2, Cell.ALIVE);
        setCellState(13 + 1, 24 + 2, Cell.ALIVE);
        setCellState(12 + 1, 24 + 2, Cell.ALIVE);
        setCellState(13 + 1, 23 + 2, Cell.ALIVE);
        setCellState(14 + 1, 23 + 2, Cell.ALIVE);
        setCellState(9 + 1, 25 + 2, Cell.ALIVE);
        setCellState(9 + 1, 26 + 2, Cell.ALIVE);
        setCellState(9 + 1, 27 + 2, Cell.ALIVE);
        setCellState(8 + 1, 26 + 2, Cell.ALIVE);
        setCellState(7 + 1, 27 + 2, Cell.ALIVE);
        setCellState(6 + 1, 28 + 2, Cell.ALIVE);
        setCellState(8 + 1, 28 + 2, Cell.ALIVE);
        setCellState(7 + 1, 28 + 2, Cell.ALIVE);
        setCellState(5 + 1, 27 + 2, Cell.ALIVE);
        setCellState(5 + 1, 26 + 2, Cell.ALIVE);
        setCellState(6 + 1, 26 + 2, Cell.ALIVE);
        setCellState(4 + 1, 26 + 2, Cell.ALIVE);
        setCellState(4 + 1, 25 + 2, Cell.ALIVE);
        setCellState(7 + 1, 25 + 2, Cell.ALIVE);
        setCellState(7 + 1, 24 + 2, Cell.ALIVE);
        setCellState(7 + 1, 23 + 2, Cell.ALIVE);
        setCellState(8 + 1, 24 + 2, Cell.ALIVE);
        setCellState(6 + 1, 23 + 2, Cell.ALIVE);
        setCellState(6 + 1, 30 + 2, Cell.ALIVE);
        setCellState(7 + 1, 30 + 2, Cell.ALIVE);
        setCellState(8 + 1, 30 + 2, Cell.ALIVE);
        setCellState(9 + 1, 31 + 2, Cell.ALIVE);
        setCellState(9 + 1, 32 + 2, Cell.ALIVE);
        setCellState(9 + 1, 33 + 2, Cell.ALIVE);
        setCellState(8 + 1, 32 + 2, Cell.ALIVE);
        setCellState(7 + 1, 31 + 2, Cell.ALIVE);
        setCellState(6 + 1, 32 + 2, Cell.ALIVE);
        setCellState(7 + 1, 33 + 2, Cell.ALIVE);
        setCellState(7 + 1, 34 + 2, Cell.ALIVE);
        setCellState(8 + 1, 34 + 2, Cell.ALIVE);
        setCellState(7 + 1, 35 + 2, Cell.ALIVE);
        setCellState(6 + 1, 35 + 2, Cell.ALIVE);
        setCellState(5 + 1, 31 + 2, Cell.ALIVE);
        setCellState(5 + 1, 32 + 2, Cell.ALIVE);
        setCellState(4 + 1, 32 + 2, Cell.ALIVE);
        setCellState(4 + 1, 33 + 2, Cell.ALIVE);
        setCellState(12 + 1, 30 + 2, Cell.ALIVE);
        setCellState(13 + 1, 30 + 2, Cell.ALIVE);
        setCellState(14 + 1, 30 + 2, Cell.ALIVE);
        setCellState(11 + 1, 31 + 2, Cell.ALIVE);
        setCellState(11 + 1, 33 + 2, Cell.ALIVE);
        setCellState(11 + 1, 32 + 2, Cell.ALIVE);
        setCellState(13 + 1, 31 + 2, Cell.ALIVE);
        setCellState(12 + 1, 32 + 2, Cell.ALIVE);
        setCellState(14 + 1, 32 + 2, Cell.ALIVE);
        setCellState(13 + 1, 33 + 2, Cell.ALIVE);
        setCellState(15 + 1, 31 + 2, Cell.ALIVE);
        setCellState(15 + 1, 32 + 2, Cell.ALIVE);
        setCellState(16 + 1, 32 + 2, Cell.ALIVE);
        setCellState(13 + 1, 34 + 2, Cell.ALIVE);
        setCellState(12 + 1, 34 + 2, Cell.ALIVE);
        setCellState(13 + 1, 35 + 2, Cell.ALIVE);
        setCellState(14 + 1, 35 + 2, Cell.ALIVE);
        setCellState(16 + 1, 33 + 2, Cell.ALIVE);
        setCellState(21 + 1, 30 + 2, Cell.ALIVE);
        setCellState(22 + 1, 30 + 2, Cell.ALIVE);
        setCellState(22 + 1, 31 + 2, Cell.ALIVE);
        setCellState(21 + 1, 31 + 2, Cell.ALIVE);
        setCellState(24 + 1, 30 + 2, Cell.ALIVE);
        setCellState(25 + 1, 30 + 2, Cell.ALIVE);
        setCellState(25 + 1, 31 + 2, Cell.ALIVE);
        setCellState(24 + 1, 31 + 2, Cell.ALIVE);
        setCellState(27 + 1, 30 + 2, Cell.ALIVE);
        setCellState(28 + 1, 30 + 2, Cell.ALIVE);
        setCellState(28 + 1, 31 + 2, Cell.ALIVE);
        setCellState(27 + 1, 31 + 2, Cell.ALIVE);
        setCellState(30 + 1, 30 + 2, Cell.ALIVE);
        setCellState(31 + 1, 30 + 2, Cell.ALIVE);
        setCellState(31 + 1, 31 + 2, Cell.ALIVE);
        setCellState(30 + 1, 31 + 2, Cell.ALIVE);
        setCellState(33 + 1, 30 + 2, Cell.ALIVE);
        setCellState(34 + 1, 30 + 2, Cell.ALIVE);
        setCellState(34 + 1, 31 + 2, Cell.ALIVE);
        setCellState(33 + 1, 31 + 2, Cell.ALIVE);
    }
   public void gleiter() {
        setCellState(0, 1, Cell.ALIVE);
        setCellState(1, 2, Cell.ALIVE);
        setCellState(2, 0, Cell.ALIVE);
        setCellState(2, 1, Cell.ALIVE);
        setCellState(2, 2, Cell.ALIVE);
    }

     public void tuemmler() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        setCellState((numRows / 2), (numCols / 2) + 2, Cell.ALIVE);
        setCellState((numRows / 2), (numCols / 2) + 3, Cell.ALIVE);
        setCellState((numRows / 2), (numCols / 2) + 5, Cell.ALIVE);
        setCellState((numRows / 2), (numCols / 2) + 6, Cell.ALIVE);
        setCellState((numRows / 2) + 1, (numCols / 2) + 1, Cell.ALIVE);
        setCellState((numRows / 2) + 1, (numCols / 2) + 2, Cell.ALIVE);
        setCellState((numRows / 2) + 1, (numCols / 2) + 6, Cell.ALIVE);
        setCellState((numRows / 2) + 1, (numCols / 2) + 7, Cell.ALIVE);
        setCellState((numRows / 2) + 2, (numCols / 2) + 2, Cell.ALIVE);
        setCellState((numRows / 2) + 2, (numCols / 2) + 3, Cell.ALIVE);
        setCellState((numRows / 2) + 2, (numCols / 2) + 5, Cell.ALIVE);
        setCellState((numRows / 2) + 2, (numCols / 2) + 6, Cell.ALIVE);
        setCellState((numRows / 2) + 3, (numCols / 2), Cell.ALIVE);
        setCellState((numRows / 2) + 3, (numCols / 2) + 2, Cell.ALIVE);
        setCellState((numRows / 2) + 3, (numCols / 2) + 6, Cell.ALIVE);
        setCellState((numRows / 2) + 3, (numCols / 2) + 8, Cell.ALIVE);
        setCellState((numRows / 2) + 4, (numCols / 2) + 1, Cell.ALIVE);
        setCellState((numRows / 2) + 4, (numCols / 2) + 7, Cell.ALIVE);
    }
    public void Danke() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        setCellState(12 + 1, 2 + 2, Cell.ALIVE);
        setCellState(12 + 1, 3 + 2, Cell.ALIVE);
        setCellState(13 + 1, 3 + 2, Cell.ALIVE);
        setCellState(13 + 1, 4 + 2, Cell.ALIVE);
        setCellState(14 + 1, 4 + 2, Cell.ALIVE);
        setCellState(14 + 1, 5 + 2, Cell.ALIVE);
        setCellState(15 + 1, 5 + 2, Cell.ALIVE);
        setCellState(16 + 1, 5 + 2, Cell.ALIVE);
        setCellState(16 + 1, 6 + 2, Cell.ALIVE);
        setCellState(11 + 1, 2 + 2, Cell.ALIVE);
        setCellState(10 + 1, 2 + 2, Cell.ALIVE);
        setCellState(10 + 1, 3 + 2, Cell.ALIVE);
        setCellState(10 + 1, 4 + 2, Cell.ALIVE);
        setCellState(9 + 1, 4 + 2, Cell.ALIVE);
        setCellState(9 + 1, 5 + 2, Cell.ALIVE);
        setCellState(9 + 1, 6 + 2, Cell.ALIVE);
        setCellState(9 + 1, 7 + 2, Cell.ALIVE);
        setCellState(9 + 1, 8 + 2, Cell.ALIVE);
        setCellState(10 + 1, 8 + 2, Cell.ALIVE);
        setCellState(10 + 1, 9 + 2, Cell.ALIVE);
        setCellState(11 + 1, 9 + 2, Cell.ALIVE);
        setCellState(11 + 1, 10 + 2, Cell.ALIVE);
        setCellState(12 + 1, 10 + 2, Cell.ALIVE);
        setCellState(13 + 1, 10 + 2, Cell.ALIVE);
        setCellState(14 + 1, 10 + 2, Cell.ALIVE);
        setCellState(14 + 1, 9 + 2, Cell.ALIVE);
        setCellState(15 + 1, 9 + 2, Cell.ALIVE);
        setCellState(15 + 1, 8 + 2, Cell.ALIVE);
        setCellState(15 + 1, 7 + 2, Cell.ALIVE);
        setCellState(12 + 1, 13 + 2, Cell.ALIVE);
        setCellState(11 + 1, 13 + 2, Cell.ALIVE);
        setCellState(10 + 1, 13 + 2, Cell.ALIVE);
        setCellState(10 + 1, 12 + 2, Cell.ALIVE);
        setCellState(9 + 1, 12 + 2, Cell.ALIVE);
        setCellState(8 + 1, 12 + 2, Cell.ALIVE);
        setCellState(7 + 1, 12 + 2, Cell.ALIVE);
        setCellState(5 + 1, 12 + 2, Cell.ALIVE);
        setCellState(6 + 1, 12 + 2, Cell.ALIVE);
        setCellState(6 + 1, 13 + 2, Cell.ALIVE);
        setCellState(6 + 1, 14 + 2, Cell.ALIVE);
        setCellState(6 + 1, 15 + 2, Cell.ALIVE);
        setCellState(7 + 1, 15 + 2, Cell.ALIVE);
        setCellState(7 + 1, 16 + 2, Cell.ALIVE);
        setCellState(7 + 1, 17 + 2, Cell.ALIVE);
        setCellState(8 + 1, 18 + 2, Cell.ALIVE);
        setCellState(8 + 1, 19 + 2, Cell.ALIVE);
        setCellState(9 + 1, 19 + 2, Cell.ALIVE);
        setCellState(9 + 1, 14 + 2, Cell.ALIVE);
        setCellState(9 + 1, 15 + 2, Cell.ALIVE);
        setCellState(9 + 1, 16 + 2, Cell.ALIVE);
        setCellState(9 + 1, 17 + 2, Cell.ALIVE);
        setCellState(8 + 1, 17 + 2, Cell.ALIVE);
        setCellState(7 + 1, 21 + 2, Cell.ALIVE);
        setCellState(6 + 1, 21 + 2, Cell.ALIVE);
        setCellState(6 + 1, 22 + 2, Cell.ALIVE);
        setCellState(5 + 1, 22 + 2, Cell.ALIVE);
        setCellState(4 + 1, 22 + 2, Cell.ALIVE);
        setCellState(3 + 1, 22 + 2, Cell.ALIVE);
        setCellState(3 + 1, 23 + 2, Cell.ALIVE);
        setCellState(4 + 1, 23 + 2, Cell.ALIVE);
        setCellState(5 + 1, 23 + 2, Cell.ALIVE);
        setCellState(6 + 1, 23 + 2, Cell.ALIVE);
        setCellState(7 + 1, 23 + 2, Cell.ALIVE);
        setCellState(8 + 1, 23 + 2, Cell.ALIVE);
        setCellState(8 + 1, 24 + 2, Cell.ALIVE);
        setCellState(8 + 1, 25 + 2, Cell.ALIVE);
        setCellState(7 + 1, 25 + 2, Cell.ALIVE);
        setCellState(7 + 1, 26 + 2, Cell.ALIVE);
        setCellState(6 + 1, 26 + 2, Cell.ALIVE);
        setCellState(6 + 1, 27 + 2, Cell.ALIVE);
        setCellState(5 + 1, 27 + 2, Cell.ALIVE);
        setCellState(5 + 1, 28 + 2, Cell.ALIVE);
        setCellState(4 + 1, 28 + 2, Cell.ALIVE);
        setCellState(4 + 1, 29 + 2, Cell.ALIVE);
        setCellState(5 + 1, 32 + 2, Cell.ALIVE);
        setCellState(5 + 1, 31 + 2, Cell.ALIVE);
        setCellState(6 + 1, 31 + 2, Cell.ALIVE);
        setCellState(7 + 1, 31 + 2, Cell.ALIVE);
        setCellState(8 + 1, 30 + 2, Cell.ALIVE);
        setCellState(9 + 1, 30 + 2, Cell.ALIVE);
        setCellState(10 + 1, 30 + 2, Cell.ALIVE);
        setCellState(8 + 1, 31 + 2, Cell.ALIVE);
        setCellState(8 + 1, 32 + 2, Cell.ALIVE);
        setCellState(7 + 1, 32 + 2, Cell.ALIVE);
        setCellState(7 + 1, 33 + 2, Cell.ALIVE);
        setCellState(6 + 1, 33 + 2, Cell.ALIVE);
        setCellState(6 + 1, 34 + 2, Cell.ALIVE);
        setCellState(6 + 1, 35 + 2, Cell.ALIVE);
        setCellState(6 + 1, 36 + 2, Cell.ALIVE);
        setCellState(8 + 1, 33 + 2, Cell.ALIVE);
        setCellState(9 + 1, 33 + 2, Cell.ALIVE);
        setCellState(10 + 1, 33 + 2, Cell.ALIVE);
        setCellState(10 + 1, 34 + 2, Cell.ALIVE);
        setCellState(11 + 1, 34 + 2, Cell.ALIVE);
        setCellState(11 + 1, 35 + 2, Cell.ALIVE);
        setCellState(12 + 1, 39 + 2, Cell.ALIVE);
        setCellState(11 + 1, 39 + 2, Cell.ALIVE);
        setCellState(10 + 1, 39 + 2, Cell.ALIVE);
        setCellState(10 + 1, 40 + 2, Cell.ALIVE);
        setCellState(9 + 1, 40 + 2, Cell.ALIVE);
        setCellState(8 + 1, 42 + 2, Cell.ALIVE);
        setCellState(8 + 1, 41 + 2, Cell.ALIVE);
        setCellState(9 + 1, 41 + 2, Cell.ALIVE);
        setCellState(9 + 1, 42 + 2, Cell.ALIVE);
        setCellState(10 + 1, 42 + 2, Cell.ALIVE);
        setCellState(10 + 1, 43 + 2, Cell.ALIVE);
        setCellState(11 + 1, 43 + 2, Cell.ALIVE);
        setCellState(12 + 1, 44 + 2, Cell.ALIVE);
        setCellState(11 + 1, 44 + 2, Cell.ALIVE);
        setCellState(11 + 1, 41 + 2, Cell.ALIVE);
        setCellState(12 + 1, 41 + 2, Cell.ALIVE);
        setCellState(13 + 1, 41 + 2, Cell.ALIVE);
        setCellState(13 + 1, 42 + 2, Cell.ALIVE);
        setCellState(12 + 1, 38 + 2, Cell.ALIVE);
        setCellState(13 + 1, 38 + 2, Cell.ALIVE);
        setCellState(13 + 1, 39 + 2, Cell.ALIVE);
        setCellState(14 + 1, 39 + 2, Cell.ALIVE);
        setCellState(14 + 1, 40 + 2, Cell.ALIVE);
        setCellState(15 + 1, 40 + 2, Cell.ALIVE);
    }
    public void Danke2() {
        setCellState(27 + 1, 27 + 2, Cell.ALIVE);
        setCellState(25 + 1, 13 + 2, Cell.ALIVE);
        setCellState(24 + 1, 13 + 2, Cell.ALIVE);
        setCellState(23 + 1, 13 + 2, Cell.ALIVE);
        setCellState(23 + 1, 14 + 2, Cell.ALIVE);
        setCellState(23 + 1, 15 + 2, Cell.ALIVE);
        setCellState(23 + 1, 16 + 2, Cell.ALIVE);
        setCellState(25 + 1, 16 + 2, Cell.ALIVE);
        setCellState(25 + 1, 17 + 2, Cell.ALIVE);
        setCellState(26 + 1, 17 + 2, Cell.ALIVE);
        setCellState(26 + 1, 23 + 2, Cell.ALIVE);
        setCellState(25 + 1, 23 + 2, Cell.ALIVE);
        setCellState(24 + 1, 23 + 2, Cell.ALIVE);
        setCellState(24 + 1, 24 + 2, Cell.ALIVE);
        setCellState(23 + 1, 24 + 2, Cell.ALIVE);
        setCellState(23 + 1, 25 + 2, Cell.ALIVE);
        setCellState(23 + 1, 26 + 2, Cell.ALIVE);
        setCellState(23 + 1, 27 + 2, Cell.ALIVE);
        setCellState(24 + 1, 27 + 2, Cell.ALIVE);
        setCellState(25 + 1, 27 + 2, Cell.ALIVE);
        setCellState(25 + 1, 28 + 2, Cell.ALIVE);
        setCellState(26 + 1, 28 + 2, Cell.ALIVE);
        setCellState(26 + 1, 27 + 2, Cell.ALIVE);
        setCellState(35 + 1, 16 + 2, Cell.ALIVE);
        setCellState(35 + 1, 17 + 2, Cell.ALIVE);
        setCellState(36 + 1, 17 + 2, Cell.ALIVE);
        setCellState(36 + 1, 18 + 2, Cell.ALIVE);
        setCellState(36 + 1, 19 + 2, Cell.ALIVE);
        setCellState(36 + 1, 20 + 2, Cell.ALIVE);
        setCellState(36 + 1, 21 + 2, Cell.ALIVE);
        setCellState(36 + 1, 22 + 2, Cell.ALIVE);
        setCellState(35 + 1, 22 + 2, Cell.ALIVE);
        setCellState(35 + 1, 23 + 2, Cell.ALIVE);
        setCellState(34 + 1, 23 + 2, Cell.ALIVE);
        setCellState(34 + 1, 24 + 2, Cell.ALIVE);
        setCellState(33 + 1, 24 + 2, Cell.ALIVE);
        setCellState(29 + 1, 19 + 2, Cell.ALIVE);
        setCellState(29 + 1, 18 + 2, Cell.ALIVE);
        setCellState(29 + 1, 17 + 2, Cell.ALIVE);
        setCellState(30 + 1, 16 + 2, Cell.ALIVE);
        setCellState(30 + 1, 17 + 2, Cell.ALIVE);
        setCellState(30 + 1, 18 + 2, Cell.ALIVE);
        setCellState(26 + 1, 13 + 2, Cell.ALIVE);
        setCellState(26 + 1, 14 + 2, Cell.ALIVE);
        setCellState(26 + 1, 15 + 2, Cell.ALIVE);
        setCellState(26 + 1, 16 + 2, Cell.ALIVE);
        setCellState(26 + 1, 24 + 2, Cell.ALIVE);
        setCellState(26 + 1, 25 + 2, Cell.ALIVE);
        setCellState(26 + 1, 26 + 2, Cell.ALIVE);
        setCellState(24 + 1, 16 + 2, Cell.ALIVE);
        setCellState(29 + 1, 11 + 2, Cell.ALIVE);
        setCellState(29 + 1, 10 + 2, Cell.ALIVE);
        setCellState(30 + 1, 10 + 2, Cell.ALIVE);
        setCellState(31 + 1, 10 + 2, Cell.ALIVE);
        setCellState(32 + 1, 10 + 2, Cell.ALIVE);
        setCellState(32 + 1, 11 + 2, Cell.ALIVE);
        setCellState(32 + 1, 12 + 2, Cell.ALIVE);
        setCellState(32 + 1, 13 + 2, Cell.ALIVE);
        setCellState(29 + 1, 29 + 2, Cell.ALIVE);
        setCellState(29 + 1, 30 + 2, Cell.ALIVE);
        setCellState(29 + 1, 31 + 2, Cell.ALIVE);
        setCellState(30 + 1, 31 + 2, Cell.ALIVE);
        setCellState(31 + 1, 31 + 2, Cell.ALIVE);
        setCellState(31 + 1, 30 + 2, Cell.ALIVE);
        setCellState(33 + 1, 6 + 2, Cell.ALIVE);
        setCellState(34 + 1, 6 + 2, Cell.ALIVE);
        setCellState(34 + 1, 7 + 2, Cell.ALIVE);
        setCellState(35 + 1, 7 + 2, Cell.ALIVE);
        setCellState(36 + 1, 7 + 2, Cell.ALIVE);
        setCellState(36 + 1, 8 + 2, Cell.ALIVE);
        setCellState(37 + 1, 8 + 2, Cell.ALIVE);
        setCellState(37 + 1, 9 + 2, Cell.ALIVE);
        setCellState(37 + 1, 10 + 2, Cell.ALIVE);
        setCellState(38 + 1, 10 + 2, Cell.ALIVE);
        setCellState(38 + 1, 11 + 2, Cell.ALIVE);
        setCellState(38 + 1, 12 + 2, Cell.ALIVE);
        setCellState(38 + 1, 13 + 2, Cell.ALIVE);
        setCellState(39 + 1, 13 + 2, Cell.ALIVE);
        setCellState(39 + 1, 14 + 2, Cell.ALIVE);
        setCellState(39 + 1, 15 + 2, Cell.ALIVE);
        setCellState(39 + 1, 16 + 2, Cell.ALIVE);
        setCellState(40 + 1, 16 + 2, Cell.ALIVE);
        setCellState(40 + 1, 17 + 2, Cell.ALIVE);
        setCellState(41 + 1, 17 + 2, Cell.ALIVE);
        setCellState(41 + 1, 18 + 2, Cell.ALIVE);
        setCellState(42 + 1, 18 + 2, Cell.ALIVE);
        setCellState(42 + 1, 19 + 2, Cell.ALIVE);
        setCellState(43 + 1, 19 + 2, Cell.ALIVE);
        setCellState(44 + 1, 19 + 2, Cell.ALIVE);
        setCellState(45 + 1, 19 + 2, Cell.ALIVE);
        setCellState(46 + 1, 19 + 2, Cell.ALIVE);
        setCellState(48 + 1, 19 + 2, Cell.ALIVE);
        setCellState(47 + 1, 19 + 2, Cell.ALIVE);
        setCellState(37 + 1, 34 + 2, Cell.ALIVE);
        setCellState(37 + 1, 33 + 2, Cell.ALIVE);
        setCellState(38 + 1, 33 + 2, Cell.ALIVE);
        setCellState(38 + 1, 32 + 2, Cell.ALIVE);
        setCellState(39 + 1, 32 + 2, Cell.ALIVE);
        setCellState(39 + 1, 31 + 2, Cell.ALIVE);
        setCellState(40 + 1, 31 + 2, Cell.ALIVE);
        setCellState(41 + 1, 31 + 2, Cell.ALIVE);
        setCellState(41 + 1, 30 + 2, Cell.ALIVE);
        setCellState(42 + 1, 30 + 2, Cell.ALIVE);
        setCellState(43 + 1, 30 + 2, Cell.ALIVE);
        setCellState(43 + 1, 29 + 2, Cell.ALIVE);
        setCellState(44 + 1, 29 + 2, Cell.ALIVE);
        setCellState(45 + 1, 29 + 2, Cell.ALIVE);
        setCellState(46 + 1, 29 + 2, Cell.ALIVE);
        setCellState(48 + 1, 29 + 2, Cell.ALIVE);
        setCellState(47 + 1, 29 + 2, Cell.ALIVE);
        setCellState(47 + 1, 28 + 2, Cell.ALIVE);
        setCellState(32 + 1, 6 + 2, Cell.ALIVE);
        setCellState(31 + 1, 6 + 2, Cell.ALIVE);
        setCellState(30 + 1, 6 + 2, Cell.ALIVE);
        setCellState(29 + 1, 6 + 2, Cell.ALIVE);
        setCellState(28 + 1, 6 + 2, Cell.ALIVE);
        setCellState(28 + 1, 7 + 2, Cell.ALIVE);
        setCellState(27 + 1, 7 + 2, Cell.ALIVE);
        setCellState(26 + 1, 7 + 2, Cell.ALIVE);
        setCellState(26 + 1, 8 + 2, Cell.ALIVE);
        setCellState(25 + 1, 8 + 2, Cell.ALIVE);
        setCellState(24 + 1, 8 + 2, Cell.ALIVE);
        setCellState(23 + 1, 8 + 2, Cell.ALIVE);
        setCellState(23 + 1, 9 + 2, Cell.ALIVE);
        setCellState(22 + 1, 9 + 2, Cell.ALIVE);
        setCellState(21 + 1, 9 + 2, Cell.ALIVE);
        setCellState(20 + 1, 9 + 2, Cell.ALIVE);
        setCellState(20 + 1, 10 + 2, Cell.ALIVE);
        setCellState(19 + 1, 10 + 2, Cell.ALIVE);
        setCellState(19 + 1, 11 + 2, Cell.ALIVE);
        setCellState(18 + 1, 11 + 2, Cell.ALIVE);
        setCellState(18 + 1, 12 + 2, Cell.ALIVE);
        setCellState(18 + 1, 13 + 2, Cell.ALIVE);
        setCellState(17 + 1, 13 + 2, Cell.ALIVE);
        setCellState(17 + 1, 17 + 2, Cell.ALIVE);
        setCellState(17 + 1, 18 + 2, Cell.ALIVE);
        setCellState(17 + 1, 19 + 2, Cell.ALIVE);
        setCellState(18 + 1, 19 + 2, Cell.ALIVE);
        setCellState(18 + 1, 18 + 2, Cell.ALIVE);
        setCellState(19 + 1, 18 + 2, Cell.ALIVE);
        setCellState(19 + 1, 17 + 2, Cell.ALIVE);
        setCellState(20 + 1, 17 + 2, Cell.ALIVE);
        setCellState(20 + 1, 16 + 2, Cell.ALIVE);
        setCellState(20 + 1, 15 + 2, Cell.ALIVE);
        setCellState(17 + 1, 15 + 2, Cell.ALIVE);
        setCellState(17 + 1, 16 + 2, Cell.ALIVE);
        setCellState(16 + 1, 16 + 2, Cell.ALIVE);
        setCellState(16 + 1, 17 + 2, Cell.ALIVE);
        setCellState(16 + 1, 18 + 2, Cell.ALIVE);
        setCellState(16 + 1, 19 + 2, Cell.ALIVE);
        setCellState(16 + 1, 21 + 2, Cell.ALIVE);
        setCellState(17 + 1, 22 + 2, Cell.ALIVE);
        setCellState(16 + 1, 24 + 2, Cell.ALIVE);
        setCellState(16 + 1, 25 + 2, Cell.ALIVE);
        setCellState(16 + 1, 26 + 2, Cell.ALIVE);
        setCellState(18 + 1, 26 + 2, Cell.ALIVE);
        setCellState(18 + 1, 25 + 2, Cell.ALIVE);
        setCellState(19 + 1, 25 + 2, Cell.ALIVE);
        setCellState(19 + 1, 24 + 2, Cell.ALIVE);
        setCellState(18 + 1, 24 + 2, Cell.ALIVE);
        setCellState(16 + 1, 28 + 2, Cell.ALIVE);
        setCellState(18 + 1, 28 + 2, Cell.ALIVE);
        setCellState(19 + 1, 28 + 2, Cell.ALIVE);
        setCellState(19 + 1, 27 + 2, Cell.ALIVE);
        setCellState(18 + 1, 27 + 2, Cell.ALIVE);
        setCellState(17 + 1, 28 + 2, Cell.ALIVE);
        setCellState(17 + 1, 29 + 2, Cell.ALIVE);
        setCellState(17 + 1, 30 + 2, Cell.ALIVE);
        setCellState(19 + 1, 30 + 2, Cell.ALIVE);
        setCellState(18 + 1, 30 + 2, Cell.ALIVE);
        setCellState(18 + 1, 32 + 2, Cell.ALIVE);
        setCellState(19 + 1, 32 + 2, Cell.ALIVE);
        setCellState(19 + 1, 35 + 2, Cell.ALIVE);
        setCellState(20 + 1, 36 + 2, Cell.ALIVE);
        setCellState(23 + 1, 36 + 2, Cell.ALIVE);
        setCellState(23 + 1, 37 + 2, Cell.ALIVE);
        setCellState(24 + 1, 37 + 2, Cell.ALIVE);
        setCellState(25 + 1, 37 + 2, Cell.ALIVE);
        setCellState(26 + 1, 37 + 2, Cell.ALIVE);
        setCellState(27 + 1, 37 + 2, Cell.ALIVE);
        setCellState(28 + 1, 37 + 2, Cell.ALIVE);
        setCellState(29 + 1, 37 + 2, Cell.ALIVE);
        setCellState(29 + 1, 38 + 2, Cell.ALIVE);
        setCellState(30 + 1, 38 + 2, Cell.ALIVE);
        setCellState(31 + 1, 38 + 2, Cell.ALIVE);
        setCellState(31 + 1, 37 + 2, Cell.ALIVE);
        setCellState(32 + 1, 37 + 2, Cell.ALIVE);
        setCellState(33 + 1, 37 + 2, Cell.ALIVE);
        setCellState(34 + 1, 37 + 2, Cell.ALIVE);
        setCellState(34 + 1, 36 + 2, Cell.ALIVE);
        setCellState(35 + 1, 36 + 2, Cell.ALIVE);
        setCellState(36 + 1, 36 + 2, Cell.ALIVE);
        setCellState(36 + 1, 35 + 2, Cell.ALIVE);
        setCellState(38 + 1, 35 + 2, Cell.ALIVE);
        setCellState(37 + 1, 35 + 2, Cell.ALIVE);
        setCellState(18 + 1, 34 + 2, Cell.ALIVE);
        setCellState(20 + 1, 32 + 2, Cell.ALIVE);
        setCellState(21 + 1, 32 + 2, Cell.ALIVE);
        setCellState(21 + 1, 33 + 2, Cell.ALIVE);
        setCellState(22 + 1, 35 + 2, Cell.ALIVE);
        setCellState(22 + 1, 36 + 2, Cell.ALIVE);
        setCellState(21 + 1, 36 + 2, Cell.ALIVE);
        setCellState(21 + 1, 37 + 2, Cell.ALIVE);
        setCellState(20 + 1, 37 + 2, Cell.ALIVE);
        setCellState(19 + 1, 36 + 2, Cell.ALIVE);
        setCellState(18 + 1, 36 + 2, Cell.ALIVE);
        setCellState(18 + 1, 35 + 2, Cell.ALIVE);
        setCellState(17 + 1, 35 + 2, Cell.ALIVE);
        setCellState(17 + 1, 34 + 2, Cell.ALIVE);
        setCellState(16 + 1, 34 + 2, Cell.ALIVE);
        setCellState(16 + 1, 33 + 2, Cell.ALIVE);
        setCellState(17 + 1, 31 + 2, Cell.ALIVE);
        setCellState(18 + 1, 31 + 2, Cell.ALIVE);
        setCellState(19 + 1, 31 + 2, Cell.ALIVE);
        setCellState(20 + 1, 31 + 2, Cell.ALIVE);
        setCellState(21 + 1, 31 + 2, Cell.ALIVE);
        setCellState(22 + 1, 31 + 2, Cell.ALIVE);
        setCellState(22 + 1, 32 + 2, Cell.ALIVE);
        setCellState(22 + 1, 33 + 2, Cell.ALIVE);
        setCellState(22 + 1, 34 + 2, Cell.ALIVE);
        setCellState(21 + 1, 34 + 2, Cell.ALIVE);
        setCellState(20 + 1, 34 + 2, Cell.ALIVE);
        setCellState(19 + 1, 34 + 2, Cell.ALIVE);
        setCellState(19 + 1, 33 + 2, Cell.ALIVE);
        setCellState(18 + 1, 33 + 2, Cell.ALIVE);
        setCellState(17 + 1, 33 + 2, Cell.ALIVE);
        setCellState(17 + 1, 32 + 2, Cell.ALIVE);
        setCellState(16 + 1, 32 + 2, Cell.ALIVE);
        setCellState(16 + 1, 31 + 2, Cell.ALIVE);
        setCellState(16 + 1, 30 + 2, Cell.ALIVE);
        setCellState(15 + 1, 30 + 2, Cell.ALIVE);
        setCellState(15 + 1, 29 + 2, Cell.ALIVE);
        setCellState(15 + 1, 28 + 2, Cell.ALIVE);
        setCellState(15 + 1, 25 + 2, Cell.ALIVE);
        setCellState(15 + 1, 24 + 2, Cell.ALIVE);
        setCellState(15 + 1, 23 + 2, Cell.ALIVE);
        setCellState(17 + 1, 24 + 2, Cell.ALIVE);
        setCellState(17 + 1, 25 + 2, Cell.ALIVE);
        setCellState(17 + 1, 26 + 2, Cell.ALIVE);
        setCellState(17 + 1, 27 + 2, Cell.ALIVE);
        setCellState(16 + 1, 27 + 2, Cell.ALIVE);
        setCellState(15 + 1, 27 + 2, Cell.ALIVE);
        setCellState(15 + 1, 26 + 2, Cell.ALIVE);
        setCellState(14 + 1, 26 + 2, Cell.ALIVE);
        setCellState(14 + 1, 25 + 2, Cell.ALIVE);
        setCellState(14 + 1, 24 + 2, Cell.ALIVE);
        setCellState(14 + 1, 23 + 2, Cell.ALIVE);
        setCellState(14 + 1, 22 + 2, Cell.ALIVE);
        setCellState(14 + 1, 21 + 2, Cell.ALIVE);
        setCellState(14 + 1, 20 + 2, Cell.ALIVE);
        setCellState(16 + 1, 20 + 2, Cell.ALIVE);
        setCellState(17 + 1, 20 + 2, Cell.ALIVE);
        setCellState(17 + 1, 21 + 2, Cell.ALIVE);
        setCellState(18 + 1, 21 + 2, Cell.ALIVE);
        setCellState(18 + 1, 22 + 2, Cell.ALIVE);
        setCellState(18 + 1, 23 + 2, Cell.ALIVE);
        setCellState(17 + 1, 23 + 2, Cell.ALIVE);
        setCellState(16 + 1, 23 + 2, Cell.ALIVE);
        setCellState(16 + 1, 22 + 2, Cell.ALIVE);
        setCellState(15 + 1, 22 + 2, Cell.ALIVE);
        setCellState(15 + 1, 21 + 2, Cell.ALIVE);
        setCellState(15 + 1, 20 + 2, Cell.ALIVE);
        setCellState(15 + 1, 19 + 2, Cell.ALIVE);
        setCellState(15 + 1, 18 + 2, Cell.ALIVE);
        setCellState(15 + 1, 17 + 2, Cell.ALIVE);
        setCellState(15 + 1, 16 + 2, Cell.ALIVE);
        setCellState(15 + 1, 15 + 2, Cell.ALIVE);
        setCellState(16 + 1, 15 + 2, Cell.ALIVE);
        setCellState(16 + 1, 14 + 2, Cell.ALIVE);
        setCellState(17 + 1, 14 + 2, Cell.ALIVE);
        setCellState(18 + 1, 14 + 2, Cell.ALIVE);
        setCellState(18 + 1, 15 + 2, Cell.ALIVE);
        setCellState(19 + 1, 15 + 2, Cell.ALIVE);
        setCellState(19 + 1, 16 + 2, Cell.ALIVE);
        setCellState(18 + 1, 16 + 2, Cell.ALIVE);
    }

    public void oktagon() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        setCellState((numRows / 2), (numCols / 2) + 1, Cell.ALIVE);
        setCellState((numRows / 2), (numCols / 2) + 2, Cell.ALIVE);
        setCellState((numRows / 2), (numCols / 2) + 3, Cell.ALIVE);
        setCellState((numRows / 2), (numCols / 2) + 4, Cell.ALIVE);
        setCellState((numRows / 2) + 1, (numCols / 2), Cell.ALIVE);
        setCellState((numRows / 2) + 1, (numCols / 2) + 2, Cell.ALIVE);
        setCellState((numRows / 2) + 1, (numCols / 2) + 3, Cell.ALIVE);
        setCellState((numRows / 2) + 1, (numCols / 2) + 5, Cell.ALIVE);
        setCellState((numRows / 2) + 2, (numCols / 2), Cell.ALIVE);
        setCellState((numRows / 2) + 2, (numCols / 2) + 1, Cell.ALIVE);
        setCellState((numRows / 2) + 2, (numCols / 2) + 4, Cell.ALIVE);
        setCellState((numRows / 2) + 2, (numCols / 2) + 5, Cell.ALIVE);
        setCellState((numRows / 2) + 3, (numCols / 2), Cell.ALIVE);
        setCellState((numRows / 2) + 3, (numCols / 2) + 1, Cell.ALIVE);
        setCellState((numRows / 2) + 3, (numCols / 2) + 4, Cell.ALIVE);
        setCellState((numRows / 2) + 3, (numCols / 2) + 5, Cell.ALIVE);
        setCellState((numRows / 2) + 4, (numCols / 2), Cell.ALIVE);
        setCellState((numRows / 2) + 4, (numCols / 2) + 2, Cell.ALIVE);
        setCellState((numRows / 2) + 4, (numCols / 2) + 3, Cell.ALIVE);
        setCellState((numRows / 2) + 4, (numCols / 2) + 5, Cell.ALIVE);
        setCellState((numRows / 2) + 5, (numCols / 2) + 1, Cell.ALIVE);
        setCellState((numRows / 2) + 5, (numCols / 2) + 2, Cell.ALIVE);
        setCellState((numRows / 2) + 5, (numCols / 2) + 3, Cell.ALIVE);
        setCellState((numRows / 2) + 5, (numCols / 2) + 4, Cell.ALIVE);
    }

    public void segler1() {
        int numRows = cells.length;
        setCellState((numRows / 2), 1, Cell.ALIVE);
        setCellState((numRows / 2), 2, Cell.ALIVE);
        setCellState((numRows / 2), 3, Cell.ALIVE);
        setCellState((numRows / 2), 4, Cell.ALIVE);
        setCellState((numRows / 2) + 1, 0, Cell.ALIVE);
        setCellState((numRows / 2) + 1, 4, Cell.ALIVE);
        setCellState((numRows / 2) + 2, 4, Cell.ALIVE);
        setCellState((numRows / 2) + 3, 0, Cell.ALIVE);
        setCellState((numRows / 2) + 3, 3, Cell.ALIVE);
    }

    public void segler2() {
        int numRows = cells.length;
        setCellState((numRows / 2), 1, Cell.ALIVE);
        setCellState((numRows / 2), 2, Cell.ALIVE);
        setCellState((numRows / 2), 3, Cell.ALIVE);
        setCellState((numRows / 2), 4, Cell.ALIVE);
        setCellState((numRows / 2), 5, Cell.ALIVE);
        setCellState((numRows / 2) + 1, 0, Cell.ALIVE);
        setCellState((numRows / 2) + 1, 5, Cell.ALIVE);
        setCellState((numRows / 2) + 2, 5, Cell.ALIVE);
        setCellState((numRows / 2) + 3, 0, Cell.ALIVE);
        setCellState((numRows / 2) + 3, 4, Cell.ALIVE);
        setCellState((numRows / 2) + 4, 2, Cell.ALIVE);
    }

    public void segler3() {
        int numRows = cells.length;
        setCellState((numRows / 2), 1, Cell.ALIVE);
        setCellState((numRows / 2), 2, Cell.ALIVE);
        setCellState((numRows / 2), 3, Cell.ALIVE);
        setCellState((numRows / 2), 4, Cell.ALIVE);
        setCellState((numRows / 2), 5, Cell.ALIVE);
        setCellState((numRows / 2), 6, Cell.ALIVE);
        setCellState((numRows / 2) + 1, 0, Cell.ALIVE);
        setCellState((numRows / 2) + 1, 6, Cell.ALIVE);
        setCellState((numRows / 2) + 2, 6, Cell.ALIVE);
        setCellState((numRows / 2) + 3, 0, Cell.ALIVE);
        setCellState((numRows / 2) + 3, 5, Cell.ALIVE);
        setCellState((numRows / 2) + 4, 2, Cell.ALIVE);
        setCellState((numRows / 2) + 4, 3, Cell.ALIVE);
    }

    /**
     * Generate a random setup.
     */
    public void randomize() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        SecureRandom rand = new SecureRandom();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                setCellState(row, col, rand.nextInt(Cell.NUM_STATES));
            }
        }
    }

    public void set() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (cells[row][col].getState() == Cell.ALIVE) {
                    setCellState(row, col, Cell.DEAD);
                } else {
                    setCellState(row, col, Cell.ALIVE);
                }
            }
        }
    }

    /**
     * Set the state of one cell.
     *
     * @param row   The cell's row.
     * @param col   The cell's col.
     * @param state The cell's state.
     */
    public void setCellState(int row, int col, int state) {
        cells[row][col].setState(state);
    }

    /**
     * Return the grid of cells.
     *
     * @return The grid of cells.
     */
    public Cell[][] getCells() {
        return cells;
    }

    public Color getCurrentColorForDead() {
        return currentColorForDead;
    }

    public void setCurrentColorForDead(Color currentColorForDead) {
        this.currentColorForDead = currentColorForDead;
    }

    public Color getCurrentColorForAliveCells() {
        return currentColorForAliveCells;
    }

    public void setCurrentColorForAliveCells(Color currentColorForAliveCells) {
        this.currentColorForAliveCells = currentColorForAliveCells;
    }

    /**
     * Setup a new environment of the given size.
     *
     * @param numRows The number of rows.
     * @param numCols The number of cols;
     */
    private void setup(int numRows, int numCols) {
        cells = new Cell[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Cell cell = new Cell();
                cells[row][col] = cell;
            }
        }
        setupNeighbors();
    }

    /**
     * Give to a cell a list of its neighbors.
     */
    private void setupNeighbors() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        // Allow for 8 neighbors plus the cell.
        ArrayList<Cell> neighbors = new ArrayList<>(9);
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Cell cell = cells[row][col];
                // This process will also include the cell.
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (row + dr < 0 || row + dr > numRows - 1 || col + dc < 0 || col + dc > numCols - 1) {
                            neighbors.add(new Cell());
                        } else {
                            int nr = (row + dr);
                            int nc = (col + dc);
                            neighbors.add(cells[nr][nc]);
                        }

                    }
                }
                // The neighbours should not include the cell at
                // (row,col) so remove it.
                neighbors.remove(cell);
                cell.setNeighbors(neighbors);
                neighbors.clear();
            }
        }
    }

}
