package rules;

import model.organisms.Organism;

import static properties.Properties.WORLD_HEIGHT;
import static properties.Properties.WORLD_WIDTH;

/**
 * Class to store rules to be used.
 */
public class MovementRules {

  /**
   * Checks if given coordinates are inside the world.
   */
  public static boolean inWorldCoordinates(int x, int y) {
    return x >= 0 && x < WORLD_WIDTH && y >= 0 && y < WORLD_HEIGHT;
  }

  /**
   * Checks if an allowed move.
   */
  public static boolean allowedMove(Organism[][] world, int x, int y, String prey) {
    if (prey.isBlank()) return world[y][x] == null;
    else if (!prey.isBlank()) return world[y][x] != null && world[y][x].getType().equals(prey);
    return false;
  }
}