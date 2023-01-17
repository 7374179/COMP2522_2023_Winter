package org.bcit.comp2522.labs.lab03;

import processing.core.PVector;

import java.awt.*;
import java.util.Objects;

public class Sprite implements Comparable <Sprite> {
  private final org.bcit.comp2522.labs.lab03.Window window;
  private PVector position;
  private PVector direction;
  private float size;
  private float speed;
  private Color color;


  public Sprite(PVector position, PVector direction, float size, float speed, Color color, Window window) {
    this.position = position;
    this.direction = direction;
    this.size = size;
    this.speed = speed;
    this.window = window;
    this.color = color;
  }

  public void bounce() {
    if (this.position.x <= 0 ||
            this.position.x >= window.width ||
            this.position.y <= 0 ||
            this.position.y >= window.height) {
      this.direction.rotate(window.HALF_PI);
    }
  }

  public PVector getDirection() {
    return direction.copy();
  }

  public PVector getPosition() {
    return position.copy();
  }

  public void update() {
    this.bounce();
    this.position = this.getPosition().add(this.direction.copy().mult(speed));
  }

  public float getSize() {
    return size;
  }

  public static boolean collided(Sprite a, Sprite b) {
    float distance = PVector.dist(a.getPosition(), b.getPosition());
    if (distance <= (a.getSize() + b.getSize())) {
      return true;
    }
    return false;
  }

  public void draw() {
    window.pushStyle();
    window.fill(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    window.ellipse(this.position.x, this.position.y, size, size);
    window.popStyle();
  }

  public void setDirection(PVector direction) {
    this.direction = direction;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Sprite sprite = (Sprite) o;
    return Float.compare(sprite.size, size) == 0 && Float.compare(sprite.speed, speed) == 0 && Objects.equals(position, sprite.position) && Objects.equals(direction, sprite.direction) && Objects.equals(color, sprite.color) && Objects.equals(window, sprite.window);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, direction, size, speed, color, window);
  }


  @Override
  public int compareTo(Sprite o) {
    if ((int) this.size == (int) ((Sprite) o).getSize()) {
      return 0;
    } else if ((int) this.size > (int) ((Sprite) o).getSize()) {
      return 1;
    } else {
      return -1;
    }
  }
}
