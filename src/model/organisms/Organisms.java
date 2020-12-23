package model.organisms;

import controller.WorldController;
import model.locations.RandomLocations;

import java.util.ArrayList;

import static properties.Properties.NUMBER_OF_ANTS;
import static properties.Properties.NUMBER_OF_BUGS;

/**
 * [Singleton Pattern] Container of organisms.
 */
public class Organisms extends ArrayList<Organism> {
  /**
   * Single object of the Organisms to be created once.
   */
  private static final Organisms organisms = new Organisms();

  /**
   * Initializes first set of organism with locations.
   */
  private Organisms() {
    /* Producer of organisms. */
    OrganismFactory organism_factory = new OrganismFactory();
    /* Single instance of random locations. */
    RandomLocations random_locations = RandomLocations.getInstance();
    for (int i = 0; i < NUMBER_OF_BUGS; ++i) {
      /*
       * Using factory class to produce bugs.
       */
      this.add(organism_factory.getOrganism(OrganismType.BUG, random_locations.getArray()[i]));
    }
    for (int i = 0; i < NUMBER_OF_ANTS; ++i) {
      /*
       * Using factory class to produce ants.
       */
      this.add(organism_factory.getOrganism(OrganismType.ANT, random_locations.getArray()[i + NUMBER_OF_BUGS]));
    }
  }

  /**
   * Returns the only object of Organisms.
   */
  public static Organisms getInstance() {
    return organisms;
  }

  /**
   * Calls movement for every organism.
   */
  public void move() {
    /* Copy of Organisms to do edits on. */
    ArrayList<Organism> copy_of_organisms = new ArrayList<>(this);
    for (Organism organism : this) {
      /*
       * Polymorphic call of move in Organism.
       */
      organism.move(WorldController.getInstance().getWorld(), copy_of_organisms);
    }
    /* Clearing the unedited Organisms then adding the edited list. */
    this.clear();
    this.addAll(copy_of_organisms);
  }
}
