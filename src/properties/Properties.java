package properties;

import model.locations.directions.DirectionType;

import java.awt.*;
import java.io.File;

/**
 * (The static members are to ease changing properties, they can be hard coded
 * to reduce common coupling.) Base data class contains world and GUI
 * properties.
 */
public class Properties {

  /*
   * - - - - - - - - - - - - - - - - - - - - Ant - - - - - - - - - - - - - - - - -
   * - - - - - - -
   */
  /**
   * Direction data.
   */
  public static final DirectionType ANT_DIRECTION = DirectionType.STRAIGHT;
  /**
   * Starving & Breeding data.
   */
  public static final int ANT_BREED = 3;
  /**
   * RGB value for coloring organisms.
   */
  public static final int ANT_R = 0;
  public static final int ANT_G = 0;
  public static final int ANT_B = 0;
  /**
   * File name for images.
   */
  public static final File ANT_FILE = new File("src/Image/Ant.png");

  /*
   * - - - - - - - - - - - - - - - - - - - - Bug - - - - - - - - - - - - - - - - -
   * - - - - - - -
   */
  /**
   * Direction data.
   */
  public static final DirectionType BUG_DIRECTION = DirectionType.STRAIGHT;
  /**
   * Starving & Breeding data.
   */
  public static final int BUG_BREED = 8;
  public static final int BUG_STARVE = 3;
  /**
   * RGB value for coloring organisms.
   */
  public static final int BUG_R = 255;
  public static final int BUG_G = 0;
  public static final int BUG_B = 0;
  /**
   * File name for images.
   */
  public static final File BUG_FILE = new File("src/Image/Bug.png");

  /*
   * - - - - - - - - - - - - - - - - - - - World - - - - - - - - - - - - - - - - -
   * - - - - - -
   */
  /**
   * 2D world width and height.
   */
  public static final int WORLD_WIDTH = 20;
  /**
   * Auto timer speed in seconds.
   */
  public static final double TIMER_SPEED = 0.2;
  /*
   * - - - - - - - - - - - - - - - - - - - - GUI - - - - - - - - - - - - - - - - -
   * - - - - - - -
   */
  /**
   * MenuBar height.
   */
  public static final int MENU_HEIGHT = 25;
  /**
   * Each cell length in GUI.
   */
  public static final int CELL_LENGTH = 45;
  /**
   * Image size divider to divide JLabel size.
   */
  public static final double PREDATOR_SIZE = 1.5;
  public static final double PREY_SIZE = 2;
  /**
   * Button dimension.
   */
  public static final Dimension BUTTON_DIMENSION = new Dimension(75, MENU_HEIGHT - 7);
  /*
   * - - - - - - - - - - - - - - - - - - - General - - - - - - - - - - - - - - - -
   * - - - - - - -
   */
  /**
   * 2D world height (we want the world to be square-like).
   */
  public static final int WORLD_HEIGHT = WORLD_WIDTH;
  /**
   * Cell's dimension to apply on each JLabel.
   */
  public static final Dimension CELL_DIMENSION = new Dimension(CELL_LENGTH, CELL_LENGTH);
  /**
   * The frame ContentPane dimension.
   */
  public static final Dimension FRAME_DIMENSION = new Dimension(WORLD_WIDTH * CELL_DIMENSION.width,
      WORLD_HEIGHT * CELL_DIMENSION.height + MENU_HEIGHT);
  /**
   * The world container dimension.
   */
  public static final Dimension WORLD_DIMENSION = new Dimension(WORLD_WIDTH * CELL_DIMENSION.height,
      WORLD_HEIGHT * CELL_DIMENSION.height);
  /**
   * MenuBar dimension.
   */
  public static final Dimension MENU_DIMENSION = new Dimension(FRAME_DIMENSION.width, MENU_HEIGHT);
  /**
   * Total number of bugs.
   */
  public static int NUMBER_OF_BUGS = 5;
  /**
   * Total number of ants.
   */
  public static int NUMBER_OF_ANTS = 100;
  /**
   * Total number of organisms to start the game with.
   */
  public static final int NUMBER_OF_ORGANISMS = NUMBER_OF_ANTS + NUMBER_OF_BUGS;
}
