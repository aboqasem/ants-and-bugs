package model.organisms;

import model.locations.Location;

/**
 * [Factory Pattern]
 * Producer of organisms.
 */
public class OrganismFactory {
  /**
   * Produces organisms using type.
   */
  public Organism getOrganism(OrganismType type, Location location) {
    if (type.equals(OrganismType.ANT)) return new Ant(location);
    else if (type.equals(OrganismType.BUG)) return new Bug(location);
    return null;
  }
}
