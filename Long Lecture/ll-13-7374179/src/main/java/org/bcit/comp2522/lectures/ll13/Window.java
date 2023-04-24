package org.bcit.comp2522.lectures.ll13;

import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.Scanner;

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
  StateManager sm;

  /**
   * Called once at the beginning of the program.
   */
  public void settings() {
    size(640, 360);
  }


  /**
   * Called once at the beginning of the program.
   * Initializes all objects.
   */
  public void setup() {
    this.init();
  }

  public void init() {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter username");
    String userName = myObj.nextLine();  // Read user input
    System.out.println("Enter color in #000000 format");
    System.out.println("Enter hex color");
    String hex = myObj.nextLine();
    sm = new StateManager(this, userName.strip(), hex.strip());
  }

  @Override
  public void keyPressed(KeyEvent event) {
    int keyCode = event.getKeyCode();
    sm.handleKeyPress(keyCode);
  }

  /**
   * Called on every frame. Updates scene object
   * state and redraws the scene. Drawings appear
   * in order of function calls.
   */
  public void draw() {
    background(0);
    sm.push();
    sm.pull();
    sm.draw();
  }


  /**
   * Main function.
   *
   * @param passedArgs arguments from command line
   */
  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"eatBubbles"};
    Window eatBubbles = new Window();
    PApplet.runSketch(appletArgs, eatBubbles);
  }
}