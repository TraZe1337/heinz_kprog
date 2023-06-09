package GameOfLife;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;

public class Cell{
    // The possible states.
    public static final int ALIVE = 0, DEAD = 1;
    // The number of possible states.
    public static final int NUM_STATES = 2;
    Color currentColor = Color.GREEN;
    // The cell's state.
    private int state;
    // The cell's neighbors.
    private Cell[] neighbors;

    /**
     * Set the initial state to be DEAD.
     */
    public Cell() {
        this(DEAD);
    }

    /**
     * Set the initial state.
     *
     * @param initialState The initial state
     */
    public Cell(int initialState) {
        state = initialState;
        neighbors = new Cell[0];
    }

    /**
     * Method to get the next State.
     *
     * @return The next state.
     */
    public int getNextState() {
        int aliveCount = 0;
        for (Cell n : neighbors) {
            if (n.getState() == ALIVE) {
                aliveCount++;
            }
        }
        if (state == DEAD) {
            if (aliveCount == 3) {
                return ALIVE;
            }
        }
        if (state == ALIVE) {
            if (aliveCount < 2 || aliveCount > 3) {
                return DEAD;
            } else {
                return ALIVE;
            }
        }
        return DEAD;
    }

    /**
     * Receive the list of neighboring cells and take
     * a copy.
     *
     * @param neighborList Neighboring cells.
     */
    public void setNeighbors(ArrayList<Cell> neighborList) {
        neighbors = new Cell[neighborList.size()];
        neighborList.toArray(neighbors);
    }

    /**
     * Get the state of this cell.
     *
     * @return The state.
     */
    public int getState() {
        return state;
    }

    /**
     * Set the state of this cell.
     *
     * @param state;
     */
    public void setState(int state) {
        this.state = state;
    }
    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color colorForDeadCell, Color colorForAliveCell) {
        if(state == 0){
            this.currentColor = colorForAliveCell;
        }else {
            this.currentColor = colorForDeadCell;
        }

    }
}


