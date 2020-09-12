package model.organisms;

import controller.WorldController;
import model.locations.Location;
import model.locations.directions.DirectionsFactory;

import java.util.ArrayList;

import static properties.Properties.*;
import static rules.MovementRules.allowedMove;
import static rules.MovementRules.inWorldCoordinates;

/**
 * [Factory Pattern]
 * Subclass of organism.
 */
public class Bug extends Organism implements Breeding, Starving, Eating {

  /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

  /**
   * Initializes every bug with its information.
   */
  public Bug(Location location) {
    /* Calling parent constructor to set object's location. */
    super(location);
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    type = "Bug";
    color = "rgb(" + BUG_R + "," + BUG_G + "," + BUG_B + ")";
    breeds = true;
    breed_counter = BUG_BREED;
    starves = true;
    starve_counter = BUG_STARVE;
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /* Setting direction type. */
    var directions_factory = new DirectionsFactory();
    directions = directions_factory.getDirections(BUG_DIRECTION);
  }

  /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

  /**
   * Movement function.
   */
  @Override
  public void move(Organism[][] world, ArrayList<Organism> organisms) {
    /* Short names of next location. */
    int next_x, next_y;
    /* Shuffling directions to go in a random way. */
    directions.shuffle();
        
        /*
            Iterating over directions and checking for prey cells to go to.
            Applying our edits on a copy of Organisms to not mess up the iteration on
            the available Organisms.
            Priority to iterate looking for preys then for empty place.
         */
    if (eat(world, organisms, "Ant")) return;
        
        /*
            Iterating over directions and checking for empty cells to go to after
            checking for preys.
            Applying our edits on a copy of Organisms to not mess up the iteration on
            the available Organisms.
         */
    for (Location direction_to_go : directions) {
      next_x = location.x + direction_to_go.x;
      next_y = location.y + direction_to_go.y;
      /* If inside world and the cell to move to is empty, */
      if (inWorldCoordinates(next_x, next_y) && allowedMove(world, next_x, next_y, "")) {
        /* Change the location of the current bug to the new location. */
        location.x = next_x;
        location.y = next_y;
        /* When moved, starve counter will decrease. */
        --starve_counter;
        /* When moved, breed counter will decrease. */
        --breed_counter;
        /* When time to starve, */
        if (starve_counter == 0) {
          starve(organisms);
        }
        /* If it survives and time to breed, */
        else if (breed_counter == 0) {
          /* Breed. */
          breed(world, organisms);
        }
        /* Update the world with the edited ArrayList. */
        WorldController.getInstance().updateWorld(organisms);
        return;
      }
    }
  }

  /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

  /**
   * Eat function.
   */
  @Override
  public boolean eat(Organism[][] world, ArrayList<Organism> organisms, String prey) {
    /* Short names of next location. */
    int next_x, next_y;

    for (Location direction_to_go : directions) {
      next_x = location.x + direction_to_go.x;
      next_y = location.y + direction_to_go.y;
      /* If inside world and the cell to move to contains an ant, */
      if (inWorldCoordinates(next_x, next_y) && allowedMove(world, next_x, next_y, prey)) {
        /* Remove the found ant from the ArrayList. */
        organisms.remove(world[next_y][next_x]);
        /* Decrease number of ants. */
        --NUMBER_OF_ANTS;
        /* Change the location of the current bug to the new location. */
        location.x = next_x;
        location.y = next_y;
        /* Reset starve to the default starve after eating. */
        starve_counter = BUG_STARVE;
        /* When moved, breed counter will decrease. */
        --breed_counter;
        /* Update the world with the new place of the current bug. */
        WorldController.getInstance().updateWorld(organisms);
        /* When time to breed, */
        if (breed_counter == 0) {
          /* Breed. */
          breed(world, organisms);
        }
        /* Update the world with the edited ArrayList. */
        WorldController.getInstance().updateWorld(organisms);
        return true;
      }
    }
    return false;
  }

  /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

  /**
   * Breed function.
   */
  @Override
  public void breed(Organism[][] world, ArrayList<Organism> organisms) {
    /* Short names of next location. */
    int next_x, next_y;
    /* An Organism factory to produce the bug. */
    OrganismFactory organism_factory = new OrganismFactory();
    /* Iterate over directions to check for possible place to breed. */
    for (Location place_to_breed : directions) {
      next_x = location.x + place_to_breed.x;
      next_y = location.y + place_to_breed.y;
      /* If inside world and the cell to breed in is empty, */
      if (inWorldCoordinates(next_x, next_y) && allowedMove(world, next_x, next_y, "")) {
        /* Add a bug beside bugs inside the ArrayList to keep priority for each Organism. */
        organisms.add(NUMBER_OF_BUGS, organism_factory.getOrganism(OrganismType.BUG, new Location(next_x,
            next_y)));
        /* Increase number of bugs. */
        ++NUMBER_OF_BUGS;
        break;
      }
    }
    /* Reset breed_counter to the default breed after breeding. */
    breed_counter = BUG_BREED;
  }

  /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

  /**
   * Starve function.
   */
  @Override
  public void starve(ArrayList<Organism> organisms) {
    /* Remove the current bug. */
    organisms.remove(this);
    /* Decrease number of bugs. */
    --NUMBER_OF_BUGS;
  }
  /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
}