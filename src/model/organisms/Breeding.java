package model.organisms;

import java.util.ArrayList;

/**
 * Breeding ability.
 */
public interface Breeding {
  /**
   * Breed function.
   */
  void breed(Organism[][] world, ArrayList<Organism> organisms);
}
