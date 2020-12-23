package model.locations;

import java.util.Objects;

/**
 * Coordinates of X and Y for each organism.
 */
public class Location {
  /**
   * X coordinate.
   */
  public int x;
  /**
   * Y coordinate.
   */
  public int y;

  /**
   * Initializes coordinates.
   */
  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Overriding equals and hashCode to get correct comparison between Location
   * objects.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Location location = (Location) o;
    return x == location.x && y == location.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
