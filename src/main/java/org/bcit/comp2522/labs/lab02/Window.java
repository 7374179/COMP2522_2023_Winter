package org.bcit.comp2522.labs.lab02;

import processing.core.PApplet;

/**
 * Lab-02 starter code.
 * Runs the applet for the Lab-02 bouncing
 * balls starter code.
 * Based on code from Keith Peters demonstrating
 * multiple-object collision.
 *
 * @author paul_bucci
 */
public class Window extends PApplet {

  /* number of balls to display on screen */
  int numBalls = 12;
  /* error around edge of ball */
  float spring = 0.05f;
  /* acceleration downwards */
  float gravity = 0.03f;
  /* energy lost to other balls */
  float friction = -0.9f;
  /* contains all the balls on screen */
  Ball[] balls = new Ball[numBalls];


  /**
   * Called once at the beginning of the program.
   * Initializes all objects.
   */
  public void setup() {
    /* Create a new set of balls with random sizes. */
    for (int i = 0; i < numBalls; i++) {
      balls[i] = new Ball(
              random(width),
              random(height),
              random(30, 70),
              i,
              balls,
              this
      );
    }
    noStroke();
    fill(255, 204);
  }

  /**
   * Called on every frame. Updates scene object
   * state and redraws the scene. Drawings appear
   * in order of function calls.
   */
  public void draw() {
    background(0);

    Mouse m = new Mouse(balls, this);

    m.move();
    m.draw();
    m.collide();
    // hint: use mouseX and mouseY
    for (Ball ball : balls) {
      ball.collide();
      ball.move();
      ball.draw();
    }
  }

  /**
   * Called once at the beginning of the program.
   */
  public void settings() {
    size(640, 360);
  }

  /**
   * Main function.
   *
   * @param passedArgs arguments from command line
   */
  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"bouncyBubbles"};
    Window bouncyBubbles = new Window();
    PApplet.runSketch(appletArgs, bouncyBubbles);
  }
}
