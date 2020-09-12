package image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import static properties.Properties.CELL_LENGTH;

/**
 * [Factory Pattern]
 * Parent class of every Image.
 */
public abstract class Image extends ImageIcon {
  /**
   * Storing the edited image.
   */
  public Image(File file, int image_r, int image_g, int image_b, double divider) throws IOException {
    this.setImage(resizeColoredImage(file, image_r, image_g, image_b, divider).getImage());
  }

  /**
   * Returns resized image after coloring it.
   */
  private ImageIcon resizeColoredImage(File file, int image_r, int image_g, int image_b, double divider) throws IOException {
    /* The imageIcon to edit then return. */
    ImageIcon icon = new ImageIcon();
    /* Loading and coloring the image. */
    icon.setImage(colorImage(file, image_r, image_g, image_b));
    /* Creating a copy of the icon to resize it. */
    java.awt.Image image = icon.getImage();
    /* Resizing the image to the cell size divided by divider. */
    image = image.getScaledInstance((int) (CELL_LENGTH / divider), (int) (CELL_LENGTH / divider),
        java.awt.Image.SCALE_SMOOTH);
    /* Setting the icon to the resized image. */
    icon.setImage(image);
    return icon;
  }

  /**
   * Returns colored image.
   */
  private BufferedImage colorImage(File file, int image_r, int image_g, int image_b) throws IOException {
    /* Loading the image to color it. */
    BufferedImage image = ImageIO.read(file);
    /* Getting size of the image. */
    int width = image.getWidth();
    int height = image.getHeight();
    /* Raster to allow us editing pixels. */
    WritableRaster raster = image.getRaster();
        /*
            Iterating over every pixel and editing it, to get full colored image.
         */
    /* For every pixel in the image, */
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        /* In the current pixel, */
        int[] pixels = raster.getPixel(x, y, (int[]) null);
        /* Set the RGB value. */
        pixels[0] = image_r;
        pixels[1] = image_g;
        pixels[2] = image_b;
        /* Write the edited pixel in the current location. */
        raster.setPixel(x, y, pixels);
      }
    }
    return image;
  }
}