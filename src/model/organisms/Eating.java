package model.organisms;

import java.util.ArrayList;

/**
 * Eating ability.
 */
public interface Eating {
  /**
   * Eat function.
   */
  boolean eat(Organism[][] world, ArrayList<Organism> organisms, String prey);
}
