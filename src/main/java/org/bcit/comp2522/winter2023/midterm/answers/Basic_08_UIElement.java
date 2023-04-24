package org.bcit.comp2522.winter2023.midterm.answers;

import java.util.ArrayList;

public class Basic_08_UIElement {
  // Basic Question 04 (5 points, 2 TODOs)
  // Idea: tests your ability to create and use interfaces

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Basic_08_myClass. Name them something useful,
  // other than "myClass", that is just an example.

  // TODO 1: Fill in the code that we would expect for this class given
  // the UML diagram included in /img/single.class.png
  public float x;
  public float y;
  public float width;
  public float height;
  public ArrayList<Basic_08_UIElement> elements;

  public void draw() {

  }

  public void move(float x, float y) {
    this.x += x;
    this.y += y;
  }

  public void add(Basic_08_UIElement uie) {
    elements.add(uie);
  }

  public void remove(Basic_08_UIElement uie) {
    elements.remove(uie);
  }

}
