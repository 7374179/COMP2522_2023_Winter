package org.bcit.comp2522.lectures.ll03;

import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;

public class Player extends Sprite{
  public Player(PVector position, PVector direction, float size, float speed, Color color, Window window) {
    super(position, direction, size, speed, color, window);
  }
  
  public void move(KeyEvent event) {
    int keyCode = event.getKeyCode();
    switch( keyCode ) {
      case PApplet.LEFT:
        // handle left
        this.setDirection(this.getDirection().rotate(-Window.PI / 16));
        break;
      case PApplet.RIGHT:
        // handle right
        this.setDirection(this.getDirection().rotate(Window.PI / 16));
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + keyCode);
    }
  }
}
