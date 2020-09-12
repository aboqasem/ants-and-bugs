package model.locations.directions;

import model.locations.Location;

/*
    [Factory Pattern, Singleton Pattern]
    Subclass of Directions, has the single object of StraightDirections.
 */
public class StraightDirections extends Directions {
  /* Single object of the StraightDirections to be created once. */
  private static final StraightDirections straight_directions = new StraightDirections();

  /*
      Initializes list of coordinates allowed for moving straight.
   */
  private StraightDirections() {
    this.add(new Location(0, -1));
    this.add(new Location(1, 0));
    this.add(new Location(0, 1));
    this.add(new Location(-1, 0));
  }

  /*
      Returns the only object of StraightDirections.
   */
  public static StraightDirections getInstance() {
    return straight_directions;
  }
}
