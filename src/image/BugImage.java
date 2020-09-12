package image;

import java.io.File;
import java.io.IOException;

import static properties.Properties.*;

/**
 * [Factory Pattern, Singleton Pattern]
 * Subclass of Image, has the single object of BugImage.
 */
public class BugImage extends Image {
  /**
   * Single object of the class to be created once.
   */
  private static BugImage bug_image;

  /* Initializing the object and loading the image into it. */
  static {
    try {
      bug_image = new BugImage(BUG_FILE, BUG_R, BUG_G, BUG_B, PREDATOR_SIZE);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Calls the parent constructor.
   */
  private BugImage(File file, int image_r, int image_g, int image_b, double divider) throws IOException {
    super(file, image_r, image_g, image_b, divider);
  }

  /**
   * Returns the only object of BugImage.
   */
  public static BugImage getInstance() {
    return bug_image;
  }
}
