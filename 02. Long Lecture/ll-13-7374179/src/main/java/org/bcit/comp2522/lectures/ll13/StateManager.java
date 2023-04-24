package org.bcit.comp2522.lectures.ll13;

import java.awt.*;

public class StateManager {
  GameState gs;
  MongoDB mdb;
  final Window w;
  float speed = 25;

  StateManager(Window w, String myName, String hex) {
    this.w = w;
    Color c = Color.decode(hex);
    this.gs = new GameState(new Player(0,0, c, myName));
    this.mdb = new MongoDB("test", "1234");
  }

  public void push() {
    mdb.put(gs);
  }

  public void setGs(GameState gs) {
    this.gs = gs;
  }

  public void pull() {
     this.gs = mdb.get(gs);
  }

  public void draw() {
    gs.draw(w);
  }

  public void handleKeyPress(int keyCode) {
    if (keyCode == w.LEFT) {
      gs.me.x -= speed;
      System.out.println("Moved left.");
    }
    if (keyCode == w.RIGHT) {
      gs.me.x += speed;
    }
    if (keyCode == w.UP) {
      gs.me.y -= speed;
    }
    if (keyCode == w.DOWN) {
      gs.me.y += speed;
    }
    System.out.format("P1.x: %f, P1.y: %f\n", gs.me.x, gs.me.y);
  }
}
