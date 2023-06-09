package org.bcit.comp2522.lectures.sl04;

import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;
import java.util.ArrayList;

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
  ArrayList<Sprite> sprites;
  ArrayList<Sprite> enemies;
  Player player;
  int numEnemies = 10;
  int minSize = 10;
  int maxSize = 20;
  Timer timer;
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
    timer = Timer.getInstance();
    enemies = new ArrayList<Sprite>();
    sprites = new ArrayList<Sprite>();
    player = Player.getInstance(
      new PVector(this.width/2,this.height/2),
      new PVector(0,1),
      minSize + 5,
      2,
      new Color(0,255,0),
      this);

    for (int i = 0; i < numEnemies; i++) {
      enemies.add(new Enemy(
        new PVector(random(0, this.width), random(0, this.height)),
        new PVector(random(-1, 1), random(-1,1)),
        random(minSize, maxSize),
        random(0,2),
        new Color(255, 0, 0),
        this
      ));
    }
    sprites.addAll(enemies);
    sprites.add(player);
  }

  @Override
  public void keyPressed(KeyEvent event) {
    player.move(event);
  }

  /**
   * Called on every frame. Updates scene object
   * state and redraws the scene. Drawings appear
   * in order of function calls.
   */
  public void draw() {
    timer.time();
    background(0);
    for (Sprite sprite : sprites) {
      sprite.update();
      sprite.draw();
    }
    ArrayList<Sprite> toRemove = new ArrayList<Sprite>();
    for (Sprite enemy : enemies) {
      if (player.collided(enemy)) {
        if (player.compareTo(enemy) == -1) {
          init();
        }
        if (player.compareTo(enemy) == 1) {
          toRemove.add(enemy);
          player.setSize(player.getSize() + enemy.getSize());
        }
      }
    }
    for (Sprite enemy : toRemove) {
      this.remove(enemy);
    }

  }

  /**
   * Removes an enemy from all relevant ArrayLists.
   *
   * @param s
   */
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