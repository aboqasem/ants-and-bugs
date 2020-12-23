package view;

import image.ImageFactory;
import model.organisms.Organism;

import javax.swing.*;
import java.awt.*;

import static properties.Properties.*;

/**
 * [MVC Pattern, Singleton Pattern] Single view of the single World.
 */
public class WorldView {
  /**
   * Single object of the WorldView to be created once.
   */
  private static final WorldView world_view = new WorldView();
  /**
   * JLabels to store them into the container panel in GUI.
   */
  private final JLabel[][] world = new JLabel[WORLD_HEIGHT][WORLD_WIDTH];
  /**
   * Image factory to produce Image instances to get image_icon.
   */
  private final ImageFactory image_factory = new ImageFactory();

  /**
   * Private constructor to allow only one object instantiation.
   */
  private WorldView() {
  }

  /**
   * Returns the only object of WorldView.
   */
  public static WorldView getInstance() {
    return world_view;
  }

  /**
   * Updates the GUI panel with new organism indices.
   */
  public void updateView(Organism[][] organisms, JPanel world_container) {
    /* Removes everything from the world_container. */
    world_container.removeAll();

    /*
     * Sets the new labels according to organisms in their location.
     */
    for (int y = 0; y < WORLD_HEIGHT; ++y) {
      for (int x = 0; x < WORLD_WIDTH; ++x) {
        world[y][x] = new JLabel();
        /* Setting size. */
        world[y][x].setPreferredSize(CELL_DIMENSION);
        /* Setting icon alignment to center. */
        world[y][x].setHorizontalAlignment(JLabel.CENTER);
        /* Setting border. */
        world[y][x].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        /* If there is an organism, */
        if (organisms[y][x] != null) {
          /* Set image. */
          world[y][x].setIcon(image_factory.getImage(organisms[y][x].getType()));
          /* Set tooltip. */
          world[y][x].setToolTipText(organisms[y][x].toString());
        }
        /* Add the label. */
        world_container.add(world[y][x]);
      }
    }
    /* Update UI. */
    world_container.updateUI();
  }
}
