package model.locations.directions;

import model.locations.Location;

import java.util.ArrayList;
import java.util.Collections;

/*
    [Factory Pattern]
    Parent class of every direction.
 */
public abstract class Directions extends ArrayList<Location> {
  /*
      Shuffles the array to get random indices.
   */
  public void shuffle() {
    Collections.shuffle(this);
  }
}