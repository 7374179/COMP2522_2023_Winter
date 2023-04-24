package ca.bcit.comp2522.labs.lab02;

import static processing.core.PApplet.atan2;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;
import static processing.core.PApplet.sqrt;

/**
 * mouse class that allows mouse cursor to collide the balls inside window.
 *
 * @author Tae Hyung Lee and Taehyuk Chung
 * @version 17.0.4.1
 */
public class Mouse extends Collidable {
  private final float diameter = 30;
  private final Window window;
  private final Ball[] others;

  /**
   * constructor for Mouse class.
   *
   * @param others as an instance of Ball array.
   * @param window as an instance of Window class.
   */
  public Mouse(Ball[] others, Window window) {
    this.others = others;
    this.window = window;
  }

  @Override
  public void draw() {
    window.ellipse(window.mouseX, window.mouseY, diameter, diameter);
  }

  @Override
  public void collide() {
    for (Ball other : others) {
      float dx = other.xpos - window.mouseX;
      float dy = other.ypos - window.mouseY;
      float distance = sqrt(dx * dx + dy * dy);
      float minDist = other.diameter / 2 + diameter / 2;
      if (distance < minDist) {
        float angle = atan2(dy, dx);
        float targetX = window.mouseX + cos(angle) * minDist;
        float targetY = window.mouseY + sin(angle) * minDist;
        float ax = (targetX - other.xpos) * window.spring;
        float ay = (targetY - other.ypos) * window.spring;

        other.setVx(other.getVx() + ax);
        other.setVy(other.getVy() + ay);
      }
    }
  }

  @Override
  public void move() {
  }
}

