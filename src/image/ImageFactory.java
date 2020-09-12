package image;

import javax.swing.*;

/**
 * [Factory Pattern]
 * Producer of images.
 */
public class ImageFactory {
  /**
   * Returns the ImageIcon instance.
   */
  public ImageIcon getImage(String type) {
    if (type.equals("Ant")) return AntImage.getInstance();
    else if (type.equals("Bug")) return BugImage.getInstance();
    return null;
  }
}