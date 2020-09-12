package image;

import java.io.File;
import java.io.IOException;

import static properties.Properties.*;

/**
 * [Factory Pattern, Singleton Pattern]
 * Subclass of Image, has the single object of AntImage.
 */
public class AntImage extends Image {
  /**
   * Single object of the class to be created once.
   */
  private static AntImage ant_image;

  /* Initializing the object and loading the image into it. */
  static {
    try {
      ant_image = new AntImage(ANT_FILE, ANT_R, ANT_G, ANT_B, PREY_SIZE);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Calls the parent constructor.
   */
  private AntImage(File file, int image_r, int image_g, int image_b, double divider) throws IOException {
    super(file, image_r, image_g, image_b, divider);
  }

  /**
   * Returns the only object of AntImage.
   */
  public static AntImage getInstance() {
    return ant_image;
  }
}