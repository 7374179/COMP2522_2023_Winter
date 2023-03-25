package src.main.java.org.bcit.midterm.mysolution;

public class Intermediate_06_MySolution {
//  This code implements the Comparable interface to compare instances of the
//  Intermediate_06_MySolution_Comparable class based on their name and age.
//  The class also overrides the equals method to compare two objects for equality.
//  The main method tests the compareTo and equals methods and throws expected exceptions.
//  Overall, the code demonstrates proficiency in implementing Comparable and equals methods.
  public static class Intermediate_06_MySolution_Comparable implements Comparable<Intermediate_06_MySolution_Comparable> {
    private String name;
    private int age;

    public Intermediate_06_MySolution_Comparable(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public boolean equals(Object other) {
      if (!(other instanceof Intermediate_06_MySolution_Comparable)) {
        return false;
      }
      Intermediate_06_MySolution_Comparable otherMyClass = (Intermediate_06_MySolution_Comparable) other;
      return this.name.equals(otherMyClass.name) && this.age == otherMyClass.age;
    }

    public int compareTo(Intermediate_06_MySolution_Comparable other) {
      if (this.equals(other)) {
        return 0;
      }
      int nameCompare = this.name.compareTo(other.name);
      if (nameCompare != 0) {
        return nameCompare;
      }
      return Integer.compare(this.age, other.age);
    }

    public static void main(String[] args) {
      Intermediate_06_MySolution_Comparable myClass1 = new Intermediate_06_MySolution_Comparable("Alice", 30);
      Intermediate_06_MySolution_Comparable myClass2 = new Intermediate_06_MySolution_Comparable("Bob", 25);
      Intermediate_06_MySolution_Comparable myClass3 = new Intermediate_06_MySolution_Comparable("Bob", 30);

      // Test compareTo
      System.out.println("myClass1.compareTo(myClass2) = " + myClass1.compareTo(myClass2)); // 1
      System.out.println("myClass2.compareTo(myClass1) = " + myClass2.compareTo(myClass1)); // -1
      System.out.println("myClass2.compareTo(myClass3) = " + myClass2.compareTo(myClass3)); // -5

      // Test equals
      System.out.println("myClass1.equals(myClass2) = " + myClass1.equals(myClass2)); // false
      System.out.println("myClass2.equals(myClass3) = " + myClass2.equals(myClass3)); // false

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
}