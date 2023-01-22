package org.bcit.comp2522.labs.lab03;

import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;

public class Wall extends Sprite {

  private Sprite sprite;

  public Wall(PVector position, PVector direction, float size, float speed, Color color, Window window) {
    super(position, direction, size, speed, color, window);

  }
//    @Override
//    public void bounce() {
//        this.direction.rotate(window.HALF_PI);
//    }
}
