package org.bcit.comp2522.labs.lab03;

import java.awt.*;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;


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
  ArrayList<Sprite> sprites;
  ArrayList<Sprite> enemies;
  //  Sprite player;
  Player player;

  int numEnemies = 10;
  int minSize = 10;
  int maxSize = 20;

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

  /**
   * sets the initialized values.
   */
  public void init() {
    enemies = new ArrayList<>();
    sprites = new ArrayList<>();
    player = new Player(new PVector((float)this.width / 2, (float)this.height / 2),
        new PVector(0, 1),
        minSize + 5,
        2,
        new Color(0, 255, 0),
        this);

    for (int i = 0; i < numEnemies; i++) {
      enemies.add(new Sprite(
          new PVector(random(0, this.width), random(0, this.height)),
          new PVector(random(-1, 1), random(-1, 1)),
          random(minSize, maxSize),
          random(0, 2),
          new Color(255, 0, 0),
          this
      ));
    }
    sprites.addAll(enemies);
    sprites.add(player);
  }

  public void keyPressed(KeyEvent event) {
    player.move(event);
  }

  /**
   * Called on every frame. Updates scene object
   * state and redraws the scene. Drawings appear
   * in order of function calls.
   */
  public void draw() {
    background(0);
    Wall wall = new Wall(new PVector(300, 100), new PVector(0, 0),
        20, 0, new Color(255, 255, 255), this);
    for (Sprite sprite : sprites) {

      wall.draw();

      if (sprite.collided(wall)) {
        sprite.bounceOff();
      }
      sprite.update();
      sprite.draw();
    }


    ArrayList<Sprite> toRemove = new ArrayList<>();
    for (Sprite enemy : enemies) {


      if (player.collided(enemy)) {

        if (player.compareTo(enemy) < 0) {
          init();
        }
        if (player.compareTo(enemy) > 0) {
          toRemove.add(enemy);
        }
      }
    }

    for (Sprite enemy : toRemove) {
      // TODO: implement compareTo and equals to make this work

      this.remove(enemy);
      player.setSize(player.getSize() + enemy.getSize());

    }

  }

  public void remove(Sprite s) {
    enemies.remove(s);
    sprites.remove(s);
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