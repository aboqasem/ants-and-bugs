package game;

import javax.swing.*;
import java.awt.*;

import static properties.Properties.*;

/**
 * Front-end class.
 */
public class Frontend {

  /**
   * Initializes presentation layer.
   */
  public void initiate(JFrame frame, JMenuBar menu_bar, JButton start, JButton move, JButton auto, JPanel world_panel) {
    setUpFrame(frame, menu_bar);
    setUpMenuBar(menu_bar, start);
    setUpWorldPanel(world_panel);
    setUpButton(start);
    setUpButton(move);
    setUpButton(auto);
  }

  /**
   * Forms the frame.
   */
  private void setUpFrame(JFrame frame, JMenuBar menu_bar) {
    frame.setTitle("Ants and Bugs");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setPreferredSize(FRAME_DIMENSION);
    frame.pack();
    frame.setJMenuBar(menu_bar);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    setUpBackground(frame);
  }

  /**
   * Forms the MenuBar.
   */
  private void setUpMenuBar(JMenuBar menu_bar, JButton start) {
    menu_bar.setPreferredSize(MENU_DIMENSION);
    menu_bar.setLayout(new FlowLayout());
    menu_bar.add(start);
  }

  /**
   * Forms the buttons.
   */
  private void setUpButton(JButton button) {
    button.setPreferredSize(BUTTON_DIMENSION);
    button.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
  }

  /**
   * Forms the world panel.
   */
  private void setUpWorldPanel(JPanel world_panel) {
    world_panel.setPreferredSize(WORLD_DIMENSION);
  }

  /**
   * Loads background image to frame ContentPane with size of world panel.
   */
  private void setUpBackground(JFrame frame) {
    ImageIcon imageIcon = new ImageIcon("src/image/Background.jpeg");
    /* Creating a copy of the icon to resize it. */
    Image image = imageIcon.getImage();
    /* Resizing the image to the world size. */
    image = image.getScaledInstance(WORLD_DIMENSION.width, WORLD_DIMENSION.height, Image.SCALE_SMOOTH);
    imageIcon.setImage(image);
    JLabel label = new JLabel(imageIcon);
    frame.setContentPane(label);
  }
}
