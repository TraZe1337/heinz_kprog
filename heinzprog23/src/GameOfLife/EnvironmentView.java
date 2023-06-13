package GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        //TODO: Pop-up: Farben ändern - Tarik // done
        //TODO: Muster (Gleiter, ...) - Stefan // done
    }

    // The longest delay for the animation, in milliseconds.
    private static final int LONGEST_DELAY = 1000;
    // Colors for the different cell states.
    private static final Color[] colors = {
            Color.green,
            Color.red,
            Color.black,
            Color.blue,
            Color.cyan,
            Color.magenta,
            Color.yellow,
            Color.white,
            Color.gray,
            Color.orange,
            Color.pink,
    };
    private static int windowcounter = 0;
    private GridView view;
    private final Environment env;
    private boolean running;
    private int delay;

    private JMenu[] menus = {new JMenu("Modus"), new JMenu("Geschwindigkeit"), new JMenu("Fenster"), new JMenu("Figuren"), new JMenu("Alive"), new JMenu("Dead")};
    private JMenuItem[] items = {
            new JMenuItem("Laufen"), new JMenuItem("Pause"),
            new JMenuItem("Reset"), new JMenuItem("Random"),
            new JMenuItem("Step"), new JMenuItem("Setzen"),
            new JMenuItem("Schneller"), new JMenuItem("Langsamer"),
            new JMenuItem("Clone"), new JMenuItem("Gleiter"),
            new JMenuItem("Tümmler"), new JMenuItem("Oktagon"),
            new JMenuItem("Segler1"), new JMenuItem("Segler2"),
            new JMenuItem("Segler3"), new JMenuItem("Rot"), // 15
            new JMenuItem("Grün"), new JMenuItem("Schwarz"), // 16 / 17
            new JMenuItem("Blau"), new JMenuItem("Cyan"),   //  18/ 19
            new JMenuItem("Magenta"), new JMenuItem("Gelb"),    //  20/ 21
            new JMenuItem("Weiß"), new JMenuItem("Grau"),   // 22 / 23
            new JMenuItem("Orange"), new JMenuItem("Pink"), // 24 / 25
            new JMenuItem("Rot"), //26
            new JMenuItem("Grün"), new JMenuItem("Schwarz"), // 27 / 28
            new JMenuItem("Blau"), new JMenuItem("Cyan"),   //  29/ 30
            new JMenuItem("Magenta"), new JMenuItem("Gelb"),    //  31/ 32
            new JMenuItem("Weiß"), new JMenuItem("Grau"),   // 33 / 34
            new JMenuItem("Orange"), new JMenuItem("Pink"), //35 / 36
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

        setupGrid(rows, cols);
        setupControls();
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
            menus[(i < 6) ? 0 : (i < 8) ? 1 : (i < 9) ? 2 : (i < 15) ? 3 : (i < 26) ? 4 : 5].add(items[i]); // if Teil -> (i<4), ? -> true Teil, : -> false Teil
        }
        JMenuBar mb = new JMenuBar();
        for (int i = 0; i < menus.length; i++) mb.add(menus[i]); //
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
                cellRow[col].setCurrentColor(env.getCurrentColorForDead(), env.getCurrentColorForAliveCells());
                view.drawMark(col, row, cellRow[col].getCurrentColor());
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
        items[4].addActionListener(e -> {
            running = false;
            env.step();
            showCells();
        });

        //neues Fenster
        items[8].addActionListener(e -> {
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
        items[5].addActionListener(e -> {
            running = false;
            env.set();
            showCells();
        });


        // More Speed
        items[6].addActionListener(e -> {
            delay -= 100;
        });

        //Less Speed
        items[7].addActionListener(e -> {
            delay += 100;
        });

        //Figur: Gleiter
        items[9].addActionListener(e -> {
            running = false;
            env.gleiter();
            showCells();
        });

        //Figur: Tümmler
        items[10].addActionListener(e -> {
            running = false;
            env.tuemmler();
            showCells();
        });

        //Figur: Oktagon
        items[11].addActionListener(e -> {
            running = false;
            env.oktagon();
            showCells();
        });

        //Figur: Segler1
        items[12].addActionListener(e -> {
            running = false;
            env.segler1();
            showCells();
        });

        //Figur: Segler2
        items[13].addActionListener(e -> {
            running = false;
            env.segler2();
            showCells();
        });

        //Figur: Segler3
        items[14].addActionListener(e -> {
            running = false;
            env.segler3();
            showCells();
        });
        //Farbe: rot
        items[15].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.red);
            showCells();
        });
        //Farbe: Schwarz
        items[17].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.black);
            showCells();
        });
        //Farbe: grün
        items[16].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.green);
            showCells();
        });
        //Farbe: blau
        items[18].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.blue);
            showCells();
        });
        //Farbe: cyan
        items[19].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.cyan);
            showCells();
        });
        //Farbe: magenta
        items[20].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.magenta);
            showCells();
        });
        //Farbe: gelb
        items[21].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.yellow);
            showCells();
        });
        //Farbe: weiß
        items[22].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.white);
            showCells();
        });
        //Farbe: grau
        items[23].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.gray);
            showCells();
        });
        //Farbe: orange
        items[24].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.orange);
            showCells();
        });
        //Farbe: pink
        items[25].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.pink);
            showCells();
        });
        //Farbe: rot
        items[26].addActionListener(e -> {
            env.setCurrentColorForDead(Color.red);
            showCells();
        });
        //Farbe: grün
        items[27].addActionListener(e -> {
            env.setCurrentColorForDead(Color.green);
            showCells();
        });
        //Farbe: schwarz
        items[28].addActionListener(e -> {
            env.setCurrentColorForDead(Color.black);
            showCells();
        });
        //Farbe: blau
        items[29].addActionListener(e -> {
            env.setCurrentColorForDead(Color.blue);
            showCells();
        });
        //Farbe: cyan
        items[30].addActionListener(e -> {
            env.setCurrentColorForAliveCells(Color.cyan);
            showCells();
        });
        //Farbe: magenta
        items[31].addActionListener(e -> {
            env.setCurrentColorForDead(Color.magenta);
            showCells();
        });//Farbe: gelb
        items[32].addActionListener(e -> {
            env.setCurrentColorForDead(Color.yellow);
            showCells();
        });//Farbe: weiß
        items[33].addActionListener(e -> {
            env.setCurrentColorForDead(Color.white);
            showCells();
        });//Farbe: grau
        items[34].addActionListener(e -> {
            env.setCurrentColorForDead(Color.gray);
            showCells();
        });//Farbe: orange
        items[35].addActionListener(e -> {
            env.setCurrentColorForDead(Color.orange);
            showCells();
        });
        //Farbe: pink
        items[36].addActionListener(e -> {
            env.setCurrentColorForDead(Color.pink);
            showCells();
        });
        // Mouse click on a cell.
        view.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("working");
            }
        });

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
