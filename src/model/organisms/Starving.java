package model.organisms;

import java.util.ArrayList;

/**
 * Starving ability.
 */
public interface Starving {
  /**
   * Starve function.
   */
  void starve(ArrayList<Organism> organisms);
}