package org.bcit.comp2522.labs.lab02;

import java.util.Arrays;
import java.util.Objects;

import static processing.core.PApplet.atan2;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;
import static processing.core.PApplet.sqrt;

/**
 * Class for a Ball to be displayed onscreen.
 */
public class Ball extends Mouse {
  private float xpos;
  private float ypos;
  private final float diameter;
  private float vx = 0;
  private float vy = 0;
  private final int id;
  private Ball[] others;
  private Window window;

  Ball(float xin, float yin, float din, int idin, Ball[] oin, Window scene) {
    this.xpos = xin;
    this.ypos = yin;
    this.diameter = din;
    this.id = idin;
    this.others = oin;
    this.window = scene;
  }

  public float getVx() {
    return vx;
  }

  public void setVx(float vx) {
    this.vx = vx;
  }

  public float getVy() {
    return vy;
  }

  public void setVy(float vy) {
    this.vy = vy;
  }

  /**
   * Draws a circle onscreen at x, y, circle.
   *
   * @param x        position of centre of circle
   * @param y        position of centre of circle
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

  /**
   * Calculates collisions between all balls.
   */
  public void collide() {
    for (int i = id + 1; i < others.length; i++) {
      float dx = others[i].xpos - xpos;
      float dy = others[i].ypos - ypos;
      float distance = sqrt(dx * dx + dy * dy);
      float minDist = others[i].diameter / 2 + diameter / 2;
      if (distance < minDist) {
        float angle = atan2(dy, dx);
        float targetX = xpos + cos(angle) * minDist;
        float targetY = ypos + sin(angle) * minDist;
        float ax = (targetX - others[i].xpos) * window.spring;
        float ay = (targetY - others[i].ypos) * window.spring;

        setVx(vx -= ax);
        setVy(vy -= ay);

        others[i].setVx(others[i].getVx() + ax);
        others[i].setVy(others[i].getVy() + ay);


      }
    }
  }

  /**
   * Calculate new positions for this ball.
   */
  public void move() {
    vy += window.gravity;
    xpos += vx;
    ypos += vy;
    if (xpos + diameter / 2 > window.width) {
      xpos = window.width - diameter / 2;
      vx *= window.friction;
    } else if (xpos - diameter / 2 < 0) {
      xpos = diameter / 2;
      vx *= window.friction;
    }
    if (ypos + diameter / 2 > window.height) {
      ypos = window.height - diameter / 2;
      vy *= window.friction;
    } else if (ypos - diameter / 2 < 0) {
      ypos = diameter / 2;
      vy *= window.friction;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Ball) {
      if (this.diameter == ((Ball) obj).diameter) {
        return true;
      }

      return false;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(xpos, ypos, diameter, vx, vy, id, window);
    result = 31 * result + Arrays.hashCode(others);
    return result;
  }

  @Override
  public String toString() {
    return "Ball{" +
            "xpos=" + xpos +
            ", ypos=" + ypos +
            ", diameter=" + diameter +
            ", vx=" + vx +
            ", vy=" + vy +
            ", id=" + id +
            ", others=" + Arrays.toString(others) +
            ", window=" + window +
            '}';
  }
}



