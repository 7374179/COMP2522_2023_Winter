package org.bcit.comp2522.lectures.ll04;

import java.awt.Color;

public class Circle implements Graphic {
  Color color;

  public Circle(Color color) {
    this.color = color;
  }

  @Override
  public void draw(Sprite s, Window w) {
    w.fill(color.getRed(), color.getBlue(), color.getGreen());
    w.ellipse(s.getPosition().x, s.getPosition().y, s.getSize(), s.getSize());
  }
}
