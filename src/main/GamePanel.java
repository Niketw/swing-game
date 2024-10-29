package main;

import inputs.KeyboardInput;
import inputs.MouseInput;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private MouseInput mouseInput;
    private float dx = 100, dy = 100;
    private BufferedImage img, subImg;

    public GamePanel() {
        mouseInput = new MouseInput(this);

        importImage();

        setPanelSize();
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            assert is != null;
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int i = 0, j = 0;

        subImg = img.getSubimage(i * 64, j * 40, 64, 40);

        g.drawImage(subImg, (int)dx, (int)dy, 64 * 3, 40 * 3,  null);
    }

    public void changeDy(int val) {
        this.dy += val;
    }

    public void changeDx(int val) {
        this.dx += val;
    }

    public void setPosition(int x, int y) {
        this.dx = x;
        this.dy = y;
    }
}
