package org.bcit.comp2522.labs.lab03;

import processing.core.PVector;

import java.awt.*;
import java.util.Objects;

public class Sprite implements Comparable  {
  protected final Window window;
  protected PVector position;
  protected PVector direction;
  protected float size;
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
    if (this.position.x <= 0||
            this.position.x >= window.width ||
            this.position.y <= 0 ||
            this.position.y >= window.height) {
      this.direction.rotate(window.HALF_PI);
    }
  }

  public void bounceoff(){
    this.direction.rotate(window.HALF_PI);  }



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

  public void setSize(float size){
    this.size = size;
  }

  public boolean collided(Sprite other) {
    float distance = PVector.dist(this.getPosition(), other.getPosition());
    if (distance <= (this.getSize() + other.getSize())) {
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
  public int compareTo(Object o) {
    if (o == null) {
      throw new NullPointerException();
    }
    if (o instanceof Sprite) {
      Sprite s = (Sprite) o;
      if (s.size < this.size) {
        return 1;
      }
      if (s.size == this.size) {
        return 0;
      }
      if (s.size > this.size) {
        return -1;
      }
    }
    throw new ClassCastException();
  }


}
