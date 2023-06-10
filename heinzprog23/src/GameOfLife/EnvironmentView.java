package GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A GUI for the environment, with runtime controls.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class EnvironmentView extends JFrame {


    public static void main(String[] args) {
        Environment environment = new Environment();
        //TODO: counter in title rein - Samil //done
        //TODO: Thread -> mehrere Instanzen - Samil // done
        //TODO: Farben ändern (ROT/Grün) - Stefan // done
        //TODO: Titel ändern - Stefan // done
        //TODO: Run -> Laufen - Stefan // done
        //TODO: Zellen Tot zu lebendig machen mit Klick - Stefan
        //TODO: Modus Setzen: Zellenstatus switchen - Stefan // done
        //TODO: Modus Malen: sollen alle Zellen bei Überstreichen mit der Maus lebendig werden. - Filippo
        //TODO: Pop-up: Farben ändern - Tarik
        //TODO: Muster (Gleiter, ...) - Stefan
    }

    // The longest delay for the animation, in milliseconds.
    private static final int LONGEST_DELAY = 1000;
    // Colors for the different cell states.
    private static final Color[] colors = {
            new Color(252, 10, 10), // Alive
            new Color(23, 227, 0), // Dead
            new Color(252, 10, 10),  // Dying
    };
    private static int windowcounter = 0;
    private GridView view;
    private final Environment env;
    private boolean running;
    private int delay;

    private JMenu[] menus = {new JMenu("Modus"), new JMenu("Geschwindigkeit"), new JMenu("Fenster"), new JMenu("Figuren")};
    private JMenuItem[] items = {
            new JMenuItem("Laufen"), new JMenuItem("Pause"),
            new JMenuItem("Reset"), new JMenuItem("Random"),
            new JMenuItem("Schneller"), new JMenuItem("Langsamer"),
            new JMenuItem("Clone"), new JMenuItem("Gleiter"),
            new JMenuItem("Tümmler"), new JMenuItem("Oktagon"),
            new JMenuItem("Segler1"), new JMenuItem("Segler2"),
            new JMenuItem("Segler3"),
    };

    ActionListener al = new ActionListener() { // AL als anonyme Klasse
        public void actionPerformed(ActionEvent e) { // ... fuer alle MenuItems
        }
    };

    /**
     * Constructor for objects of class EnvironmentView
     *
     * @param env
     */
    public EnvironmentView(Environment env, int rows, int cols) {
        super("Game of Life");
        windowcounter++;
        setTitle("Game of Life - Fenster " + windowcounter);
        setupMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(20, 20);
        this.env = env;
        this.running = false;
        setDelay(50);
        setupControls();
        setupGrid(rows, cols);
        pack();
        setVisible(true);
    }

    /**
     * Setup a new environment of the given size.
     *
     * @param rows The number of rows.
     * @param cols The number of cols;
     */
    private void setupGrid(int rows, int cols) {
        Container contents = getContentPane();
        view = new GridView(rows, cols);
        contents.add(view, BorderLayout.CENTER);
    }

    private void setupMenu() {
        for (int i = 0; i < items.length; i++) {
            menus[(i < 4) ? 0 : (i < 6) ? 1 : (i < 7) ? 2 : (i < 13) ? 3 : 4].add(items[i]); // if Teil -> (i<4), ? -> true Teil, : -> false Teil
        }
        JMenuBar mb = new JMenuBar();
        for (int i = 0; i < menus.length; i++)
            mb.add(menus[i]); //
        setJMenuBar(mb);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
    }

    /**
     * Show the states of the cells.
     */
    public void showCells() {
        Cell[][] cells = env.getCells();
        if (!isVisible()) {
            setVisible(true);
        }

        view.preparePaint();
        for (int row = 0; row < cells.length; row++) {
            Cell[] cellRow = cells[row];
            int numCols = cellRow.length;
            for (int col = 0; col < numCols; col++) {
                int state = cellRow[col].getState();
                view.drawMark(col, row, colors[state]);
            }
        }

        view.repaint();
    }

    /**
     * Set up the animation controls.
     */
    private void setupControls() {
        // Continuous running.
        items[0].addActionListener(e -> {
            if (!running) {
                running = true;
                try {
                    new Runner().execute();
                } catch (Exception ex) {
                }
            }
        });

        // Single stepping.
        final JButton step = new JButton("Step");
        step.addActionListener(e -> {
            running = false;
            env.step();
            showCells();
        });

        //neues Fenster
        items[6].addActionListener(e -> {
            Environment clone = new Environment();
        });


        // Pause the animation.
        items[1].addActionListener(e -> running = false);

        // Reset of the environment
        items[2].addActionListener(e -> {
            running = false;
            env.reset();
            showCells();
        });

        // Randomize the environment.
        items[3].addActionListener(e -> {
            running = false;
            env.randomize();
            showCells();
        });

        // Switch Cells environment.
        final JButton setzen = new JButton("Setzen");
        setzen.addActionListener(e -> {
            running = false;
            env.set();
            showCells();
        });

        Container contents = getContentPane();
        // More Speed
        items[4].addActionListener(e -> {
            delay -= 100;
        });

        //Less Speed
        items[5].addActionListener(e -> {
            delay += 100;
        });

        // Place the button controls.
        JPanel controls = new JPanel();
        controls.add(step);
        controls.add(setzen);


        contents.add(controls, BorderLayout.SOUTH);
    }


    /**
     * Set the animation delay.
     *
     * @param speedPercentage (100-speedPercentage) as a percentage of the LONGEST_DELAY.
     */
    private void setDelay(int speedPercentage) {
        delay = (int) ((100.0 - speedPercentage) * LONGEST_DELAY / 100);
    }

    /**
     * Provide stepping of the animation.
     */
    private class Runner extends SwingWorker<Boolean, Void> {
        @Override
        /**
         * Repeatedly single-step the environment as long
         * as the animation is running.
         */
        public Boolean doInBackground() {
            while (running) {
                env.step();
                showCells();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                }
            }
            return true;
        }
    }


    /**
     * Provide a graphical view of a rectangular grid.
     */
    @SuppressWarnings("serial")
    private class GridView extends JPanel {
        private final int GRID_VIEW_SCALING_FACTOR = 10;

        private final int gridWidth, gridHeight;
        private int xScale, yScale;
        private Dimension size;
        private Graphics g;
        private Image fieldImage;

        /**
         * Create a new GridView component.
         */
        public GridView(int height, int width) {
            gridHeight = height;
            gridWidth = width;
            size = new Dimension(0, 0);
        }

        /**
         * Tell the GUI manager how big we would like to be.
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                    gridHeight * GRID_VIEW_SCALING_FACTOR);
        }

        /**
         * Prepare for a new round of painting. Since the component
         * may be resized, compute the scaling factor again.
         */
        public void preparePaint() {
            if (!size.equals(getSize())) {
                size = getSize();
                fieldImage = view.createImage(size.width, size.height);
                g = fieldImage.getGraphics();

                xScale = size.width / gridWidth;
                if (xScale < 1) {
                    xScale = GRID_VIEW_SCALING_FACTOR;
                }
                yScale = size.height / gridHeight;
                if (yScale < 1) {
                    yScale = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }

        /**
         * Paint on grid location on this field in a given color.
         */
        public void drawMark(int x, int y, Color color) {
            g.setColor(color);
            g.fillRect(x * xScale, y * yScale, xScale - 1, yScale - 1);
        }

        /**
         * The field view component needs to be redisplayed. Copy the
         * internal image to screen.
         */
        @Override
        public void paintComponent(Graphics g) {
            if (fieldImage != null) {
                Dimension currentSize = getSize();
                if (size.equals(currentSize)) {
                    g.drawImage(fieldImage, 0, 0, null);
                } else {
                    // Rescale the previous image.
                    g.drawImage(fieldImage, 0, 0, currentSize.width, currentSize.height, null);
                }
            }
        }
    }
}
