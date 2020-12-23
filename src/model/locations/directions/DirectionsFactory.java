package model.locations.directions;

/*
    [Factory Pattern]
    Producer of Directions.
 */
public class DirectionsFactory {
  /*
   * Produces directions using type.
   */
  public Directions getDirections(DirectionType type) {
    if (type.equals(DirectionType.STRAIGHT))
      return StraightDirections.getInstance();
    return null;
  }
}
