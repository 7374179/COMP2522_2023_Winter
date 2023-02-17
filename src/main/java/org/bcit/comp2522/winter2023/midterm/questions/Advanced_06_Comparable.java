package org.bcit.comp2522.winter2023.midterm.questions;

public class Advanced_06_Comparable {
  // Advanced Question 06 (20 points, 2 TODOs)
  // Idea: tests your ability to follow interface requirements.

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Advanced_06_myClass. Name them something
  // useful, other than "myClass", that is just an example.

  private float x, y, z;
  public Advanced_06_Comparable(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  // TODO 1: Implement an equals method that checks each the class
  // attribute x, y, z against the incoming object. Equality should be only
  // between classes that are the same.

  // TODO 2: Make this class implement Comparable. Implement all of the
  // methods that the interface demands. Compare with regards to absolute
  // distance to the origin, i.e., <0,0,0>. You can use the Euclidean metric,
  // i.e., a^2 + b^2 + c^2 = d^2. Ensure that equality in the equals
  // method is the same as in compareTo.

  // TODO 3: Create a main method that demonstrates EACH of the Comparable
  // conditions, including the exceptions.
}
