package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class DrawingPanel extends JPanel implements ActionListener {
    // Shape-related fields
    private ArrayList<Shape> shapes;
    private Shape square;

    // Grid constants
    private static final int GRID_SIZE = 50;
    private static final int CELL_SIZE = 10;
    private static final double BLOCK_PROBABILITY = 0.2;
    private static final double OOZE_SPREAD_CHANCE = 0.2;
    
    // Game state
    private Cell[][] grid;
    private Timer oozeTimer;
    private Random random;
    
    // Available colors for ooze
    private static final Color[] OOZE_COLORS = {
        Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA
    };

    // Inner class for cell representation
    private class Cell {
        private Color color;
        private boolean isOozing;
        private boolean isBlocked;

        public Cell() {
            this.color = Color.WHITE;
            this.isOozing = false;
            this.isBlocked = false;
        }
    }

    public DrawingPanel() {
        super();
        shapes = new ArrayList<>();
        shapes.add(new Rectangle(0, 0, 20, 30, Color.red));
        square = new Square(0, 0, 100, Color.green);
        random = new Random();

        // Initialize the game grid
        initializeGrid();

        // Set up ooze timer
        oozeTimer = new Timer(30, e -> updateOoze());
        oozeTimer.start();

        // Set up mouse handling using MouseAdapter
        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
            }
        };
        
        addMouseListener(mouseHandler);
    }

    private void initializeGrid() {
        grid = new Cell[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = new Cell();
                if (random.nextDouble() < BLOCK_PROBABILITY) {
                    grid[i][j].isBlocked = true;
                    grid[i][j].color = Color.BLACK;
                }
            }
        }
    }

    private void handleMouseClick(MouseEvent e) {
        int gridX = e.getX() / CELL_SIZE;
        int gridY = e.getY() / CELL_SIZE;

        if (gridX >= 0 && gridX < GRID_SIZE && gridY >= 0 && gridY < GRID_SIZE) {
            Cell clickedCell = grid[gridX][gridY];
            if (!clickedCell.isBlocked && !clickedCell.isOozing) {
                clickedCell.isOozing = true;
                clickedCell.color = OOZE_COLORS[random.nextInt(OOZE_COLORS.length)];
            }
        }
    }

    private void updateOoze() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j].isOozing && random.nextDouble() < OOZE_SPREAD_CHANCE) {
                    spreadOoze(i, j);
                }
            }
        }
        repaint();
    }

    private void spreadOoze(int x, int y) {
        Color oozingColor = grid[x][y].color;
        
        // Check all adjacent cells (including diagonals)
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                
                // Check if within grid bounds
                if (newX >= 0 && newX < GRID_SIZE && newY >= 0 && newY < GRID_SIZE) {
                    Cell targetCell = grid[newX][newY];
                    // Spread to cells that are either free or have a different color
                    if (!targetCell.isBlocked && (!targetCell.isOozing || 
                        !targetCell.color.equals(oozingColor))) {
                        targetCell.color = oozingColor;
                        targetCell.isOozing = true;
                    }
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw shapes
        square.paint(g);
        for (Shape shape : shapes) {
            shape.paint(g);
        }
        
        // Draw grid
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                g.setColor(grid[i][j].color);
                g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update shape positions
        for (Shape shape : shapes) {
            shape.move();
        }
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
    }
}