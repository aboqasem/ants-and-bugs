package controller;

import model.World;
import model.organisms.Organism;
import view.WorldView;

import javax.swing.*;
import java.util.ArrayList;

/**
 * [MVC Pattern, Singleton Pattern] Single controller of the single world.
 */
public class WorldController {
  /**
   * Single object of the WorldController to be created once.
   */
  private static final WorldController world_controller = new WorldController();
  /**
   * The only object of World.
   */
  private final World world = World.getInstance();
  /**
   * The only object of WorldView.
   */
  private final WorldView world_view = WorldView.getInstance();

  /**
   * Private constructor to allow only one object instantiation.
   */
  private WorldController() {
  }

  /**
   * Returns the only object of WorldController.
   */
  public static WorldController getInstance() {
    return world_controller;
  }

  /**
   * Calls world_view's updateView.
   */
  public void updateView(JPanel world_container) {
    world_view.updateView(world.getWorld(), world_container);
  }

  /**
   * Calls world's getWorld.
   */
  public Organism[][] getWorld() {
    return world.getWorld();
  }

  /**
   * Calls world's updateWorld.
   */
  public void updateWorld(ArrayList<Organism> organisms) {
    world.updateWorld(organisms);
  }
}
