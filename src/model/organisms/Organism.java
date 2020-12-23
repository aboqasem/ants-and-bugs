package model.organisms;

import model.locations.Location;
import model.locations.directions.Directions;

import java.util.ArrayList;
import java.util.Objects;

/**
 * [Factory Pattern] Parent class of every organism.
 */
public abstract class Organism {
  /**
   * Location of the organism.
   */
  protected final Location location;
  /**
   * Type of the organism.
   */
  protected String type = "";
  /**
   * Color for game GUI.
   */
  protected String color = "";
  /**
   * If this organism breeds.
   */
  protected boolean breeds = false;
  /**
   * If this organism starves.
   */
  protected boolean starves = false;
  /**
   * Number of steps until breeding.
   */
  protected int breed_counter;
  /**
   * Number of steps until dying.
   */
  protected int starve_counter;
  /**
   * Directions allowed.
   */
  protected Directions directions;

  /**
   * Initializes every organism with a location.
   */
  public Organism(Location location) {
    this.location = location;
  }

  /**
   * Movement function.
   */
  public abstract void move(Organism[][] world, ArrayList<Organism> organisms);

  /**
   * Returns organism type.
   */
  public String getType() {
    return type;
  }

  /**
   * Returns organism location.
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Overrides toString to give description of the current organism.
   */
  @Override
  public String toString() {
    if (breeds && starves)
      return "<html><font color=" + color + ">This " + type.toLowerCase() + " will breed in " + breed_counter + ", and "
          + "will" + " starve " + "in " + starve_counter + ".</font></html>";
    else if (breeds)
      return "<html><font color=" + color + ">This " + type.toLowerCase() + " will breed in " + breed_counter
          + ".</font" + "></html>";
    else
      return "<html><font color=" + color + ">" + type + ".</font></html>";
  }

  /**
   * Overriding equals and hashCode to get correct comparison between Organism
   * objects.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Organism organism = (Organism) o;
    return location.equals(organism.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location);
  }
}
