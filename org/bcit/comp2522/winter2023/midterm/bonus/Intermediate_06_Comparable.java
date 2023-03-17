package org.bcit.comp2522.winter2023.midterm.bonus;

public class Intermediate_06_Comparable implements Comparable<Intermediate_06_Comparable> {
  // Intermediate Question 06 (10 points, 2 TODOs)
  // Idea: tests your ability to follow interface requirements.

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Intermediate_06_myClass. Name them something
  // useful, other than "myClass", that is just an example.

  private float x;
  public Intermediate_06_Comparable(float x) {
    this.x = x;
  }

  // TODO 1: Implement an equals method that checks each the class
  // attribute x against the incoming object. Equality should be only
  // between classes that are the same.

  // TODO 2: Make this class implement Comparable. Implement all of the
  // methods that the interface demands. Compare along the x dimension.
  // Ensure that equality in the equals method is the same as in compareTo.

  // TODO 3: Create a main method that demonstrates EACH of the Comparable
  // conditions, including the exceptions.


  public boolean equals(Object other) {
    if (!(other instanceof Intermediate_06_Comparable)) {
      return false;
    }
    Intermediate_06_Comparable otherMyClass = (Intermediate_06_Comparable) other;
    return this.x == otherMyClass.x;
  }

  public int compareTo(Intermediate_06_Comparable other) {
    if (this.equals(other)) {
      return 0;
    }
    if (this.x < other.x) {
      return -1;
    }
    return 1;
  }

  public static void main(String[] args) {
    Intermediate_06_Comparable myClass1 = new Intermediate_06_Comparable(1);
    Intermediate_06_Comparable myClass2 = new Intermediate_06_Comparable(2);
    Intermediate_06_Comparable myClass3 = new Intermediate_06_Comparable(2);

    // Test compareTo
    System.out.println("myClass1.compareTo(myClass2) = " + myClass1.compareTo(myClass2)); // -1
    System.out.println("myClass2.compareTo(myClass1) = " + myClass2.compareTo(myClass1)); // 1
    System.out.println("myClass2.compareTo(myClass3) = " + myClass2.compareTo(myClass3)); // 0

    // Test equals
    System.out.println("myClass1.equals(myClass2) = " + myClass1.equals(myClass2)); // false
    System.out.println("myClass2.equals(myClass3) = " + myClass2.equals(myClass3)); // true

    // Test exceptions
    try {
      myClass1.compareTo(null);
    } catch (NullPointerException e) {
      System.out.println("Caught NullPointerException: " + e.getMessage());
    }

    try {
      myClass1.equals("");
    } catch (ClassCastException e) {
      System.out.println("Caught ClassCastException: " + e.getMessage());
    }
  }
}