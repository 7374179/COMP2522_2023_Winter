package org.bcit.comp2522.lectures.ll04;

import java.util.ArrayList;

public class CompoundGraphic implements Graphic {
  ArrayList<Graphic> graphics;

  public CompoundGraphic() {
    this.graphics = new ArrayList<Graphic>();
  }

  public void add(Graphic g) {
    graphics.add(g);
  }

  public void remove(Graphic g) {
    graphics.remove(g);
  }

  public ArrayList<Graphic> getGraphics() {
    return graphics;
  }

  @Override
  public void draw(Sprite s, Window w) {
    for (Graphic c : graphics) {
      w.pushStyle();
      c.draw(s, w);
      w.popStyle();
    }
  }
}
