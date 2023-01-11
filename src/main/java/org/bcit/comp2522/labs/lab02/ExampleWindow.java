package org.bcit.comp2522.labs.lab02;

import processing.core.PApplet;

/**
 * Example Window class that draws balls inside the window.
 *
 * @author Tae Hyung Lee and Taehyuk Chung
 * @version 17.0.4.1
 */
public class ExampleWindow extends PApplet {

  public void settings() {
    size(500, 500);
  }

  public void draw() {
    ellipse(mouseX, mouseY, 50, 50);
  }

  public void mousePressed() {
    background(64);
  }

  /**
   * main method.
   *
   * @param args unused
   */
  public static void main(String[] args) {
    String[] processingArgs = {"processingWindow"};
    ExampleWindow processingWindow = new ExampleWindow();
    PApplet.runSketch(processingArgs, processingWindow);
  }
}