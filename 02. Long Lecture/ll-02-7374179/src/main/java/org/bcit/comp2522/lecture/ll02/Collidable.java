package org.bcit.comp2522.lecture.ll02;

import static processing.core.PApplet.*;
import static processing.core.PApplet.sin;

public abstract class Collidable {
  protected float xpos;
  protected float ypos;
  protected float vx = 0;
  protected float vy = 0;
  protected final int id;
  protected Collidable[] others;
  protected Window window;

  public Collidable(float xin, float yin, int idin, Collidable[] oin, Window scene) {
    this.xpos = xin;
    this.ypos = yin;
    this.id = idin;
    this.others = oin;
    this.window = scene;
  }

  public float getXpos() {
    return xpos;
  }

  public void setXpos(float xpos) {
    this.xpos = xpos;
  }

  public float getYpos() {
    return ypos;
  }

  public void setYpos(float ypos) {
    this.ypos = ypos;
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

  public void move() {
    vy += window.gravity;
    xpos += vx;
    ypos += vy;
    if (xpos + getSize() / 2 > window.width) {
      xpos = window.width - getSize() / 2;
      vx *= window.friction;
    } else if (xpos - getSize() / 2 < 0) {
      xpos = getSize() / 2;
      vx *= window.friction;
    }
    if (ypos + getSize() / 2 > window.height) {
      ypos = window.height - getSize() / 2;
      vy *= window.friction;
    } else if (ypos - getSize() / 2 < 0) {
      ypos = getSize() / 2;
      vy *= window.friction;
    }
  }

  /**
   * Calculates collisions between all balls.
   */
  public void collide() {
    for (int i = id + 1; i < others.length; i++) {
      float dx = others[i].getXpos() - xpos;
      float dy = others[i].getYpos() - ypos;
      float distance = sqrt(dx * dx + dy * dy);
      float minDist = others[i].getSize() / 2 + getSize() / 2;
      if (distance < minDist) {
        float angle = atan2(dy, dx);
        float targetX = xpos + cos(angle) * minDist;
        float targetY = ypos + sin(angle) * minDist;
        float ax = (targetX - others[i].getXpos()) * window.spring;
        float ay = (targetY - others[i].getYpos()) * window.spring;
        vx -= ax;
        vy -= ay;
        others[i].setVx(others[i].getVx() + ax);
        others[i].setVy(others[i].getVy() + ay);
      }
    }
  }
  public abstract void draw();
  public abstract float getSize();



}
