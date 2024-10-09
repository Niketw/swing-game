package main;

import inputs.KeyboardInput;
import inputs.MouseInput;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {
    private MouseInput mouseInput;
    private int dx = 300, dy = 200;

    public GamePanel() {
        mouseInput = new MouseInput(this);
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }

    public void changeDx(int val) {
        this.dx += val;
        repaint();
    }

    public void changeDy(int val) {
        this.dy += val;
        repaint();
    }

    public void setPosition(int x, int y) {
        this.dx = x;
        this.dy = y;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(dx, dy, 200, 50);
    }
}
