package org.bcit.comp2522.labs.lab03;

import java.awt.*;
import processing.core.PVector;

/**
 * A class that defines Wall functions.
 *
 * @author Tae Hyung Lee and Taehyuk Chung
 * @version 2023, January 23rd
 */
public class Wall extends Sprite {

  public Wall(PVector position, PVector direction, float size, float speed,
              Color color, Window window) {
    super(position, direction, size, speed, color, window);
  }
}
