package org.bcit.comp2522.lecture.ll02;

import processing.core.PApplet;

import java.util.Random;

/**
 * Lab-02 starter code.
 * Runs the applet for the Lab-02 bouncing
 * balls starter code.
 * Based on code from Keith Peters demonstrating
 * multiple-object collision.
 *
 * @author paul_bucci
 *
 */
public class Window extends PApplet {

  /* number of balls to display on screen */
  int numCollidables = 12;
  /* error around edge of ball */
  float spring = 0.05f;
  /* acceleration downwards */
  float gravity = 0.03f;
  /* energy lost to other balls */
  float friction = -0.9f;
  /* contains all the balls on screen */
  Collidable[] collidables = new Collidable[numCollidables];

  /**
   * Called once at the beginning of the program.
   * Initializes all objects.
   */
  public void setup() {
    /* Create a new set of balls with random sizes. */
    Random rand = new Random();
    for (int i = 0; i < numCollidables; i++) {
//      if (rand.nextInt(-1, 1) < 0) {
      if (rand.nextInt(1) < 0) {
        collidables[i] = new Ball(
          random(width),
          random(height),
          random(30, 70),
          i,
          collidables,
          this
        );
      } else {
        collidables[i] = new Box(
          random(30, 70),
          random(30,70),
          random(width),
          random(height),
          i,
          collidables,
          this
        );
      }

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
    // TODO: add the Mouse collide, move, and draw here
    // hint: use mouseX and mouseY
    for (Collidable ball : collidables) {
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