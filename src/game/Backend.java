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
   * Initializes logical back-end.
   */
  public void initiate(JFrame frame, JMenuBar menu_bar, JButton start, JButton move, JButton auto,
                       JPanel world_panel) {
    //Move:
    setMoveListener(frame, move, world_panel);
    //Auto:
    setAutoListener(frame, auto, move, world_panel);
    //Start:
    setStartListener(frame, start, menu_bar, move, auto, world_panel);
    /* Updating view into world_panel. */
    world_controller.updateView(world_panel);
  }

  /**
   * Sets the actionListener on the start button.
   */
  private void setStartListener(JFrame frame, JButton start, JMenuBar menu_bar, JButton move, JButton auto,
                                JPanel world_panel) {
        /*
            Starts the game.
         */
    start.addActionListener(ActiveEvent -> {
      /* Removing start button. */
      menu_bar.remove(start);
      /* Adding move button to menu_bar. */
      menu_bar.add(move);
      /* Adding auto button to menu_bar. */
      menu_bar.add(auto);
      /* Setting world_panel to ContentPane. */
      frame.setContentPane(world_panel);
      /* Adding KeyListener to listen for enter click. */
      frame.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
          /* If the key is Enter */
          if (e.getKeyChar() == '\n') {
            move.setEnabled(false);
            /* Move all organisms. */
            organisms.move();
            /* Update view. */
            world_controller.updateView(world_panel);
            move.setEnabled(true);
          }
        }
      });
      /* Validate the frame. */
      frame.validate();
      /* Focus the frame. */
      frame.requestFocus();
    });
  }

  /**
   * Sets the actionListener on the move button.
   */
  private void setMoveListener(JFrame frame, JButton move, JPanel world_panel) {
        /*
            Moves all organisms.
         */
    move.addActionListener(actionEvent -> {
      move.setEnabled(false);
      /* Moving all organisms. */
      organisms.move();
      /* Updating view. */
      world_controller.updateView(world_panel);
      move.setEnabled(true);
      /* Focus the frame. */
      frame.requestFocus();
    });
  }

  /**
   * Sets the actionListener on the auto button.
   */
  private void setAutoListener(JFrame frame, JButton auto, JButton move, JPanel world_panel) {
    /* Automatic moving timer. */
    Timer auto_move = new Timer((int) (TIMER_SPEED * 1000), e -> {
      /* Moving all organisms. */
      organisms.move();
      /* Updating view. */
      world_controller.updateView(world_panel);
    });
        /*
            Moves all organisms automatically.
         */
    auto.addActionListener(e -> {
      /* If the button says Auto, */
      if (auto.getText().equals("Auto")) {
        /* Set the text to Stop. */
        auto.setText("Stop");
        /* Disable the move button. */
        move.setEnabled(false);
        /* Start auto moving timer. */
        auto_move.start();
      }
      /* If the button says Stop, */
      else {
        /* Stop auto moving timer. */
        auto_move.stop();
        /* Set the text back to Auto. */
        auto.setText("Auto");
        /* Enable the move button */
        move.setEnabled(true);
        /* Focus the frame. */
        frame.requestFocus();
      }
    });
  }
}