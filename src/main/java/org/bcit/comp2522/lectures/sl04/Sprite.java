package org.bcit.comp2522.lectures.sl04;

import processing.core.PVector;

import java.awt.*;

public class Sprite implements Comparable {
  protected PVector position;
  private PVector direction;
  private float size;
  private float speed;
  private Color color;
  protected Window window;


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

  public void setSize(float size) {
    this.size = size;
  }

  public void setDirection(PVector direction) {
    this.direction = direction;
  }

  /**
   * Compares this object with the specified object for order.  Returns a
   * negative integer, zero, or a positive integer as this object is less
   * than, equal to, or greater than the specified object.
   *
   * <p>The implementor must ensure {@link Integer#signum
   * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
   * all {@code x} and {@code y}.  (This implies that {@code
   * x.compareTo(y)} must throw an exception if and only if {@code
   * y.compareTo(x)} throws an exception.)
   *
   * <p>The implementor must also ensure that the relation is transitive:
   * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
   * {@code x.compareTo(z) > 0}.
   *
   * <p>Finally, the implementor must ensure that {@code
   * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
   * == signum(y.compareTo(z))}, for all {@code z}.
   *
   * @param o the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object
   * is less than, equal to, or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it
   *                              from being compared to this object.
   * @apiNote It is strongly recommended, but <i>not</i> strictly required that
   * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
   * class that implements the {@code Comparable} interface and violates
   * this condition should clearly indicate this fact.  The recommended
   * language is "Note: this class has a natural ordering that is
   * inconsistent with equals."
   */
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
