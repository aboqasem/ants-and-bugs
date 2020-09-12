package game;

import javax.swing.*;
import java.awt.*;

import static properties.Properties.*;

/**
 * Front-end class.
 */
public class Frontend {

  /**
   * Initializes graphical front-end.
   */
  public void initiate(JFrame frame, JMenuBar menu_bar, JButton start, JButton move, JButton auto,
                       JPanel world_panel) {
    /* Setting Frame. */
    formFrame(frame, menu_bar);
    /* Setting MenuBar size and layout. */
    formMenuBar(menu_bar, start);
    /* Setting world_panel size. */
    formWorldPanel(world_panel);
    /* Setting start button size and font. */
    formButton(start);
    /* Setting move button font and size. */
    formButton(move);
    /* Setting auto button font and size. */
    formButton(auto);
  }

  /**
   * Forms the frame.
   */
  private void formFrame(JFrame frame, JMenuBar menu_bar) {
    /* Setting title. */
    frame.setTitle("Ants and Bugs");
    /* Setting close operation. */
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    /* Setting ContentPane size. */
    frame.getContentPane().setPreferredSize(FRAME_DIMENSION);
    /* Packing the frame into the ContentPane size. */
    frame.pack();
    /* Setting MenuBar to frame. */
    frame.setJMenuBar(menu_bar);
    /* Setting relativity of location of the frame on screen to none. */
    frame.setLocationRelativeTo(null);
    /* Setting resizability to false. */
    frame.setResizable(false);
    /* Setting background of the app. */
    formBackground(frame);
  }

  /**
   * Forms the MenuBar.
   */
  private void formMenuBar(JMenuBar menu_bar, JButton start) {
    menu_bar.setPreferredSize(MENU_DIMENSION);
    menu_bar.setLayout(new FlowLayout());
    /* Adding start button to menu_bar. */
    menu_bar.add(start);
  }

  /**
   * Forms the buttons.
   */
  private void formButton(JButton button) {
    button.setPreferredSize(BUTTON_DIMENSION);
    button.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
  }

  /**
   * Forms the world panel.
   */
  private void formWorldPanel(JPanel world_panel) {
    world_panel.setPreferredSize(WORLD_DIMENSION);
  }

  /**
   * Loads background image to frame ContentPane with size of world panel.
   */
  private void formBackground(JFrame frame) {
    /* Loading background image. */
    ImageIcon img = new ImageIcon("src/Image/Background.jpeg");
    /* Creating a copy of the icon to resize it. */
    Image image = img.getImage();
    /* Resizing the image to the world size. */
    image = image.getScaledInstance(WORLD_DIMENSION.width, WORLD_DIMENSION.height, Image.SCALE_SMOOTH);
    /* Setting the icon to the resized image. */
    img.setImage(image);
    /* Container for the image. */
    JLabel label = new JLabel(img);
    /* Setting the frame contentPane as this image container. */
    frame.setContentPane(label);
  }
}