package org.bcit.comp2522.labs.lab03;

import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;

public class Wall extends Sprite {

  private Sprite sprite;

  public Wall(PVector position, PVector direction, float size, float speed, Color color, Window window, Sprite sprites) {
    super(position, direction, size, speed, color, window);

  }
}
