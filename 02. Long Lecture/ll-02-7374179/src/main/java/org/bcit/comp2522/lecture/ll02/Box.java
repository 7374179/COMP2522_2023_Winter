package org.bcit.comp2522.lecture.ll02;

public class Box extends Collidable {

  private final float width;
  private final float height;

  public Box(float win, float hin, float xin, float yin, int idin, Collidable[] oin, Window scene) {
    super(xin, yin, idin, oin, scene);
    this.width = win;
    this.height = hin;
  }

  @Override
  public void draw() {
    window.rect(xpos, ypos, width, height);
  }

  @Override
  public float getSize() {
    return Math.max(width, height);
  }
}
