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
    /* Setting LAF to cross-platform LAF. */
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) {
      System.err.println("Look and feel not set.");
    }
    /* MenuBar. */
    JMenuBar menu_bar = new JMenuBar();
    /* World container. */
    JPanel world_panel = new JPanel(new GridLayout(WORLD_WIDTH, WORLD_HEIGHT));
    /* Start button. */
    JButton start = new JButton("Start");
    /* Move button. */
    JButton move = new JButton("Move");
    /* Move button. */
    JButton auto = new JButton("Auto");
    /* Call initiations. */
    new Frontend().initiate(this, menu_bar, start, move, auto, world_panel);
    new Backend().initiate(this, menu_bar, start, move, auto, world_panel);
    /* Display the app. */
    setVisible(true);
  }
}