package game;

import javax.swing.*;
import java.awt.*;

import static properties.Properties.WORLD_HEIGHT;
import static properties.Properties.WORLD_WIDTH;

/**
 * Initiates game.
 */
public class Game extends JFrame {

  /**
   * Initiates front-end and back-end.
   */
  public void initiate() {
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) {
      System.err.println("Look and feel not set.");
    }
    JMenuBar menu_bar = new JMenuBar();
    JPanel world_panel = new JPanel(new GridLayout(WORLD_WIDTH, WORLD_HEIGHT));
    JButton start = new JButton("Start");
    JButton move = new JButton("Move");
    JButton auto = new JButton("Auto");
    /* Initiating layers. */
    new Frontend().initiate(this, menu_bar, start, move, auto, world_panel);
    new Backend().initiate(this, menu_bar, start, move, auto, world_panel);
    /* Display the app. */
    setVisible(true);
  }
}
