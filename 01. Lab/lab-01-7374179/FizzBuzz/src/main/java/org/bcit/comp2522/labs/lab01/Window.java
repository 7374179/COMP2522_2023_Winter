package org.bcit.comp2522.labs.lab01;

import processing.core.PApplet;

/**
 * Runs the class by using PApplet.
 *
 * @author Taehyuk Chung, set D
 * @version 2023
 */

public class Window extends PApplet {

  /**
   * Sets the size of a drawing board.
   */
  public void settings() {
    size(900, 900);
  }

  /**
   * Draws a car by using geometric primitives.
   */
  public void draw() {
    quad(380, 600, 380, 440, 300, 440, 180, 600);

    rect(400, 400, 400, 200, 0, 0, 10, 0);
    rect(295, 460, 70, 50);
    rect(300, 340, 500, 50, 20, 20, 0, 20);

    circle(300, 600, 100);
    circle(650, 600, 100);

    triangle(260, 630, 300, 550, 340, 630);
    triangle(260, 570, 300, 650, 340, 570);
    triangle(610, 630, 650, 550, 690, 630);
    triangle(610, 570, 650, 650, 690, 570);
  }

  /**
   * Prints drawings on the drawing board.
   *
   * @param args unused
   */
  public static void main(String[] args) {
    String[] processingArgs = {"window"};
    Window window = new Window();
    PApplet.runSketch(processingArgs, window);
  }
}
