package model.locations;

import java.util.HashSet;
import java.util.Random;

import static properties.Properties.*;

/**
 * [Singleton Pattern] Initial set of unique random locations to set them into
 * each organism.
 */
public class RandomLocations {
  /**
   * Single object of the class to be created once.
   */
  private static final RandomLocations random_locations = new RandomLocations();
  /**
   * Array to store the locations.
   */
  private final Location[] array;

  /**
   * Creates the locations and converting them into the Locations array.
   */
  private RandomLocations() {
    /* Hash set to store unique random locations. */
    var set = new HashSet<Location>();
    /* Random numbers generator. */
    var rand = new Random();

    /*
     * While locations are less than the organism total number, continue creating
     * other locations.
     */
    while (set.size() < NUMBER_OF_ORGANISMS) {
      int x = rand.nextInt(WORLD_WIDTH);
      int y = rand.nextInt(WORLD_HEIGHT);
      set.add(new Location(x, y));
    }
    /* Convert the hash set into the locations array. */
    array = new Location[set.size()];
    set.toArray(array);
  }

  /**
   * Returns the only object of RandomLocations.
   */
  public static RandomLocations getInstance() {
    return random_locations;
  }

  /**
   * Returns the array of locations.
   */
  public Location[] getArray() {
    return array;
  }
}
