package org.bcit.comp2522.labs.lab03;

import java.awt.*;
import processing.core.PVector;

/**
 * A class that defines Enemy functions.
 *
 * @author Tae Hyung Lee and Taehyuk Chung
 * @version 2023, January 23rd
 */
public class Enemy extends Sprite {

  public Enemy(PVector position, PVector direction, float size, float speed,
               Color color, Window window) {
    super(position, direction, size, speed, color, window);
  }
}
