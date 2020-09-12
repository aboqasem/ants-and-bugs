package model;

import model.organisms.Organism;
import model.organisms.Organisms;

import java.util.ArrayList;

import static properties.Properties.WORLD_HEIGHT;
import static properties.Properties.WORLD_WIDTH;

/**
 * [MVC Pattern, Singleton Pattern]
 * Model of the single World.
 */
public class World {
  /**
   * Single object of the World to be created once.
   */
  private static final World world_instance = new World();
  /**
   * The array which will be used for processing movements of organisms.
   */
  private final Organism[][] world;

  /**
   * Initializes first random set of organisms into world.
   */
  private World() {
    /* Setting world into the given width and height. */
    world = new Organism[WORLD_HEIGHT][WORLD_WIDTH];
    /* Placing every organism. */
    updateWorld(Organisms.getInstance());
  }

  /**
   * Returns the only object of World.
   */
  public static World getInstance() {
    return world_instance;
  }

  /**
   * Returns world structure.
   */
  public Organism[][] getWorld() {
    return world;
  }

  /**
   * Updates the world array according the organisms list.
   */
  public void updateWorld(ArrayList<Organism> organisms) {
    /* Setting the whole world to null. */
    for (int y = 0; y < WORLD_HEIGHT; ++y) {
      for (int x = 0; x < WORLD_WIDTH; ++x) {
        world[y][x] = null;
      }
    }
    /* Setting every location in the world to its Organism. If no organism, it remains null. */
    for (Organism organism : organisms) {
      world[organism.getLocation().y][organism.getLocation().x] = organism;
    }
  }
}