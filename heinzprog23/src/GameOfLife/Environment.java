package GameOfLife;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.*;

/**
 * Maintain the environment for a 2D cellular automaton.
 *
 * @author David J. Barnes
 * @version 2016.02.29
 */
public class Environment {
    // Default size for the environment.
    private static final int DEFAULT_ROWS = 50;
    private static final int DEFAULT_COLS = 50;
    private Color currentColorForDead = Color.red;
    private Color currentColorForAliveCells = Color.green;

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

    public void gleiter() {
        reset();
        setCellState(0, 1, Cell.ALIVE);
        setCellState(1, 2, Cell.ALIVE);
        setCellState(2, 0, Cell.ALIVE);
        setCellState(2, 1, Cell.ALIVE);
        setCellState(2, 2, Cell.ALIVE);
    }

    public void tuemmler() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        reset();
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

    public void oktagon() {
        int numRows = cells.length;
        int numCols = cells[0].length;
        reset();
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
        reset();
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
        reset();
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
        reset();
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
