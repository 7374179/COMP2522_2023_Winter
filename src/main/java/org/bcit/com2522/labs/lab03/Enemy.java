package org.bcit.com2522.labs.lab03;

import org.bcit.com2522.labs.lab03.Sprite;
import org.bcit.com2522.labs.lab03.Window;
import processing.core.PVector;

import java.awt.*;

public class Enemy extends Sprite {

  public Enemy(PVector position, PVector direction, float size, float speed, Color color, Window window) {
    super(position, direction, size, speed, color, window);
  }
}
