package org.bcit.comp2522.labs.lab03;

import java.awt.*;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

/**
 * A class that defines common moving functions.
 *
 * @author Tae Hyung Lee and Taehyuk Chung
 * @version 2023, January 23rd
 */
public class Player extends Sprite {
  public Player(PVector position, PVector direction, float size,
                float speed, Color color, Window window) {
    super(position, direction, size, speed, color, window);
  }

  /**
   * sets the keyboard input.
   *
   * @param event as a variable of KeyEvent
   */
  public void move(KeyEvent event) {
    int keyCode = event.getKeyCode();
    switch (keyCode) {
      case PApplet.LEFT ->
        // handle left
          this.setDirection(this.getDirection().rotate(-Window.PI / 16));
      case PApplet.RIGHT ->
        // handle right
          this.setDirection(this.getDirection().rotate(Window.PI / 16));
      default -> throw new IllegalStateException("Unexpected value: " + keyCode);
    }
  }
}