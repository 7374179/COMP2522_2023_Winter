package org.bcit.comp2522.labs.lab02;

import static processing.core.PApplet.atan2;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;
import static processing.core.PApplet.sqrt;

public class Mouse extends Collidable {
  private float xpos;
  private float ypos;
  private final float diameter;
  private Window window;
  private Ball[] balls;

  public Mouse(float xin, float yin, float din, Ball[] bin, Window scene) {
    this.xpos = xin;
    this.ypos = yin;
    this.diameter = din;
    this.balls = bin;
    this.window = scene;
  }

  @Override
  public void draw() {
    window.ellipse(xpos, ypos, diameter, diameter);
  }

//  @Override
//  void move() {
//
//  }

  @Override
  public void collide() {
    for (Ball ball : balls) {
      float dx = ball.xpos - xpos;
      float dy = ball.ypos - ypos;
      float distance = sqrt(dx * dx + dy * dy);
      float minDist = ball.diameter / 2 + diameter / 2;
      if (distance < minDist) {
        float angle = atan2(dy, dx);
        float targetX = xpos + cos(angle) * minDist;
        float targetY = ypos + sin(angle) * minDist;
        float ax = (targetX - ball.xpos) * window.spring;
        float ay = (targetY - ball.ypos) * window.spring;

        ball.setVx(ball.getVx() - ax);
        ball.setVy(ball.getVy() - ay);
      }
    }
  }


  @Override
  public void move() {

  }

}

