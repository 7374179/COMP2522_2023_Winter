package org.bcit.comp2522.lecture.ll02;

import java.util.Objects;

/**
 * Class for a Ball to be displayed onscreen.
 */
public class Ball extends Collidable {
  private final float diameter;

  Ball(float xin, float yin, float din, int idin, Collidable[] oin, Window scene) {
    super(xin, yin, idin, oin, scene);
    this.diameter = din;
  }

  @Override
  public boolean equals(Object o) {
    Ball ball = (Ball) o;
    return Float.compare(ball.diameter, diameter) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diameter);
  }

  @Override
  public String toString() {
    return "Ball{" +
      "xpos=" + xpos +
      ", ypos=" + ypos +
      ", diameter=" + diameter +
      '}';
  }

  /**
   * Draws a circle onscreen at x, y, circle.
   *
   * @param x position of centre of circle
   * @param y position of centre of circle
   * @param diameter width of circle
   */
  public void drawCircle(float x, float y, float diameter) {
    window.ellipse(x, y, diameter, diameter);
  }

  /**
   * Draws the Ball.
   */
  public void draw() {
    this.drawCircle(this.xpos, this.ypos, this.diameter);
  }


  public float getDiameter() {
    return diameter;
  }


  @Override
  public float getSize() {
    return this.diameter;
  }

}