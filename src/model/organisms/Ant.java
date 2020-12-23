package model.organisms;

import controller.WorldController;
import model.locations.Location;
import model.locations.directions.DirectionsFactory;

import java.util.ArrayList;

import static properties.Properties.*;
import static rules.MovementRules.allowedMove;
import static rules.MovementRules.inWorldCoordinates;

/**
 * [Factory Pattern] Subclass of organism.
 */
public class Ant extends Organism implements Breeding {

  /*
   * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
   * - - - - - - - - -
   */

  /**
   * Initializes every ant with its information.
   */
  public Ant(Location location) {
    /* Calling parent constructor to set object's location. */
    super(location);
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    type = "Ant";
    color = "rgb(" + ANT_R + "," + ANT_G + "," + ANT_B + ")";
    breeds = true;
    breed_counter = ANT_BREED;
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /* Setting direction type. */
    var directions_factory = new DirectionsFactory();
    directions = directions_factory.getDirections(ANT_DIRECTION);
  }

  /*
   * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
   * - - - - - - - - -
   */

  /**
   * Movement function.
   */
  @Override
  public void move(Organism[][] world, ArrayList<Organism> organisms) {
    /* Short names of next location. */
    int next_x, next_y;
    /* Shuffling directions to step in a random way. */
    directions.shuffle();

    /*
     * Iterating over directions and checking for empty cells to go to. Applying our
     * edits on a copy of Organisms to not mess up the iteration on the available
     * Organisms.
     */
    for (Location direction_to_go : directions) {
      next_x = location.x + direction_to_go.x;
      next_y = location.y + direction_to_go.y;
      /* If inside world and the cell to move to is empty, */
      if (inWorldCoordinates(next_x, next_y) && allowedMove(world, next_x, next_y, "")) {
        /* Change the location of the current ant to the new location. */
        location.x = next_x;
        location.y = next_y;
        /* When moved, breed counter will decrease. */
        --breed_counter;
        /* Update the world with the new place of the current ant. */
        WorldController.getInstance().updateWorld(organisms);
        /* When time to breed, */
        if (breed_counter == 0) {
          /* Breed. */
          breed(world, organisms);
        }
        /* Update the world with the edited ArrayList. */
        WorldController.getInstance().updateWorld(organisms);
        return;
      }
    }
  }

  /*
   * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
   * - - - - - - - - -
   */

  /**
   * Breed function.
   */
  @Override
  public void breed(Organism[][] world, ArrayList<Organism> organisms) {
    /* Short names of next location. */
    int next_x, next_y;
    /* An Organism factory to produce the ant. */
    OrganismFactory organism_factory = new OrganismFactory();
    /* Iterate over directions to check for possible place to breed. */
    for (Location place_to_breed : directions) {
      next_x = location.x + place_to_breed.x;
      next_y = location.y + place_to_breed.y;
      /* If inside world and the cell to breed in is empty, */
      if (inWorldCoordinates(next_x, next_y) && allowedMove(world, next_x, next_y, "")) {
        /*
         * Add an ant beside ants inside the ArrayList to keep priority for each
         * Organism.
         */
        organisms.add(NUMBER_OF_BUGS + NUMBER_OF_ANTS,
            organism_factory.getOrganism(OrganismType.ANT, new Location(next_x, next_y)));
        /* Increase number of ants. */
        ++NUMBER_OF_ANTS;
        break;
      }
    }
    /* Reset breed_counter to the default breed after breeding. */
    breed_counter = ANT_BREED;
  }
  /*
   * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
   * - - - - - - - - -
   */
}
