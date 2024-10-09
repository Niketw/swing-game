package main;

import inputs.KeyboardInput;
import inputs.MouseInput;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInput mouseInput;

    private float dx = 300.0f, dy = 200.0f;
    private float xDir = 1.0f, yDir = 1.0f;
    private Color color = new Color(100, 100, 100);
    private Random random = new Random();

    public GamePanel() {
        random = new Random();
        mouseInput = new MouseInput(this);
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }

    public void changeDx(int val) {
        this.dx += val;
    }

    public void changeDy(int val) {
        this.dy += val;
    }

    public void setPosition(int x, int y) {
        this.dx = x;
        this.dy = y;
    }

    private Color randomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r, g, b);
    }

    private void updateRectangle() {
        dx += xDir;
        if (dx > 800 || dx < 0) {
            xDir *= -1;
            color = randomColor();
        }

        dy += yDir;
        if (dy > 600 || dy < 0) {
            yDir *= -1;
            color = randomColor();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateRectangle();
        g.setColor(color);
        g.fillRect((int) dx, (int) dy, 200, 50);
    }
}
