package org.bcit.comp2522.lectures.ll10;
import processing.core.PApplet;
import processing.core.PImage;

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
  Event e;

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
    EventListener dataDownloader = new DataDownloader();
    e = new Event(dataDownloader);
    frameRate(10);
  }

  @Override
  public void draw() {
    // Do expensive thing
    e.trigger();

    // Do the rest of your work, e.g., run the UI
    ellipse(mouseX, mouseY, 10, 10);
    PImage pic = loadImage("image.jpg");
    image(pic, 0, 0);
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