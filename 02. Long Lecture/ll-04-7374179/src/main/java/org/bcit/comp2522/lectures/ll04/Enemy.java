package org.bcit.comp2522.lectures.ll04;

import processing.core.PVector;

import java.awt.*;

public class Enemy extends Sprite{
  public Enemy(PVector position, PVector direction, float size, float speed, Color color, Window window) {
    super(position, direction, size, speed, color, window);
  }
}
