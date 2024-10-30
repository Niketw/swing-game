package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import inputs.KeyboardInput;
import inputs.MouseInput;


public class GamePanel extends JPanel {
    private MouseInput mouseInputs;
    private Game game;


    public GamePanel(Game game) {
        mouseInputs = new MouseInput(this);
        this.game = game;

        setPanelSize();
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }


    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void updateGame() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.render(g);
    }

    public Game getGame() {
        return game;
    }
}