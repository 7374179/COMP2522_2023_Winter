package org.bcit.comp2522.labs.lab03;

import processing.core.*;

import processing.core.PVector;

import java.awt.*;

public class Wall extends PApplet {

  private final Window window;
  private PVector position;
  private PVector direction;
  private float size;
  private float speed;
  private Color color;

  public Wall(Window window, PVector position, PVector direction, float size, float speed, Color color) {
    this.window = window;
    this.position = position;

    this.direction = direction;
    this.size = size;
    this.speed = speed;
    this.color = color;
  }



  public void draw() {
    window.rect();
  }


  public void collide() {

  }



}



