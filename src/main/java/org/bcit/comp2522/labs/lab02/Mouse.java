package org.bcit.comp2522.labs.lab02;

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
  private Window window;
  private Ball[] others;

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
    for (int i = 0; i < others.length; i++) {
      float dx = others[i].xpos - window.mouseX;
      float dy = others[i].ypos - window.mouseY;
      float distance = sqrt(dx * dx + dy * dy);
      float minDist = others[i].diameter / 2 + diameter / 2;
      if (distance < minDist) {
        float angle = atan2(dy, dx);
        float targetX = window.mouseX + cos(angle) * minDist;
        float targetY = window.mouseY + sin(angle) * minDist;
        float ax = (targetX - others[i].xpos) * window.spring;
        float ay = (targetY - others[i].ypos) * window.spring;


        others[i].setVx(others[i].getVx() + ax);
        others[i].setVy(others[i].getVy() + ay);


      }
    }
  }


  @Override
  public void move() {

  }

}

