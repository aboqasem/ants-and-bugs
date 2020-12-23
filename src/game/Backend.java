package game;

import controller.WorldController;
import model.organisms.Organisms;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static properties.Properties.TIMER_SPEED;

/**
 * Back-end class.
 */
public class Backend {
  /**
   * Organisms object.
   */
  private final Organisms organisms = Organisms.getInstance();
  /**
   * WorldController object.
   */
  private final WorldController world_controller = WorldController.getInstance();

  /**
   * Initializes logical layer.
   */
  public void initiate(JFrame frame, JMenuBar menu_bar, JButton start, JButton move, JButton auto, JPanel world_panel) {
    setMoveActionListener(frame, move, world_panel);
    setAutoActionListener(frame, auto, move, world_panel);
    setStartActionListener(frame, start, menu_bar, move, auto, world_panel);
    /* Update world_panel with the current state. */
    world_controller.updateView(world_panel);
  }

  /**
   * Sets the actionListener of the start button.
   */
  private void setStartActionListener(JFrame frame, JButton start, JMenuBar menu_bar, JButton move, JButton auto,
      JPanel world_panel) {
    /*
     * Starts the game.
     */
    start.addActionListener(e -> {
      /* Removing start button. (No longer will be used) */
      menu_bar.remove(start);
      menu_bar.add(move);
      menu_bar.add(auto);
      /* Update ContentPane with world_panel. */
      frame.setContentPane(world_panel);
      /* Adding KeyListener to listen for ENTER key event. */
      frame.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent ke) {
          if (ke.getKeyChar() == '\n') {
            move.setEnabled(false);
            organisms.move();
            world_controller.updateView(world_panel);
            move.setEnabled(true);
          }
        }
      });
      frame.validate();
      frame.requestFocus();
    });
  }

  /**
   * Sets the actionListener of the move button.
   */
  private void setMoveActionListener(JFrame frame, JButton move, JPanel world_panel) {
    /*
     * Moves all organisms.
     */
    move.addActionListener(e -> {
      move.setEnabled(false);
      organisms.move();
      world_controller.updateView(world_panel);
      move.setEnabled(true);
      frame.requestFocus();
    });
  }

  /**
   * Sets the actionListener of the auto button.
   */
  private void setAutoActionListener(JFrame frame, JButton auto, JButton move, JPanel world_panel) {
    Timer auto_move = new Timer((int) (TIMER_SPEED * 1000), e -> {
      organisms.move();
      world_controller.updateView(world_panel);
    });
    /*
     * Moves all organisms automatically.
     */
    auto.addActionListener(e -> {
      if (auto.getText().equals("Auto")) {
        auto.setText("Stop");
        move.setEnabled(false);
        auto_move.start();
      } else {
        auto_move.stop();
        auto.setText("Auto");
        move.setEnabled(true);
        frame.requestFocus();
      }
    });
  }
}
