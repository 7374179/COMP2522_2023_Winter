package org.bcit.comp2522.lectures.sl04;

import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;

public class Player extends Sprite {
  private long uid;

  static Player player;

  private Player(PVector position, PVector direction, float size, float speed, Color color, Window window) {
    super(position, direction, size, speed, color, window);
    this.uid = System.nanoTime();
  }

  public static Player getInstance(PVector position, PVector direction, float size, float speed, Color color, Window window) {
    if (player == null) {
      player = new Player(position, direction, size, speed, color, window);
      player.uid = System.nanoTime();
    }
    return player;
  }

  public static Player getInstance() {
    if(player == null){
      player.uid = System.nanoTime();
      return player;
    }
    return player;
  }

//  private Player(){
////    super();
//    player.getUid();
//  }
//  public static Player getInstance() {
//    if (player == null) {
//      player = new Player();
//    }
//    return player;
//  }


  public long getUid() {
    return uid;
  }

  public void move(KeyEvent event) {
    int keyCode = event.getKeyCode();
    switch( keyCode ) {
      case PApplet.LEFT:
        // handle left
        this.setDirection(this.getDirection().rotate(-Window.PI / 16));
        break;
      case PApplet.RIGHT:
        // handle right
        this.setDirection(this.getDirection().rotate(Window.PI / 16));
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + keyCode);
    }
  }
}
