package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.ArrayList;
import java.util.Collections;

public class Advanced_06_Comparable implements Comparable {
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
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || obj.getClass() != this.getClass())
      return false;

    return (this.x == ((Advanced_06_Comparable) obj).x && this.y == ((Advanced_06_Comparable) obj).y && this.z == ((Advanced_06_Comparable) obj).z);

  }

  // TODO 2: Make this class implement Comparable. Implement all of the
  // methods that the interface demands. Compare with regards to absolute
  // distance to the origin, i.e., <0,0,0>. You can use the Euclidean metric,
  // i.e., a^2 + b^2 + c^2 = d^2. Ensure that equality in the equals
  // method is the same as in compareTo.

  @Override
  public int compareTo(Object o) throws NullPointerException, ClassCastException {
    if (o == null) {
      throw new NullPointerException();
    }
    if (!(o instanceof Advanced_06_Comparable)) {
      throw new ClassCastException();
    }
    float tmp1 = this.x * this.x + this.y * this.y + this.z * this.z;
    float tmp2 = ((Advanced_06_Comparable) o).x * ((Advanced_06_Comparable) o).x
        + ((Advanced_06_Comparable) o).y * ((Advanced_06_Comparable) o).y
        + ((Advanced_06_Comparable) o).z * ((Advanced_06_Comparable) o).z;

    if (tmp1 >tmp2){
      return 1;
    }else if(tmp1<tmp2){
      return -1;
    }else
      return 0;
  }

  // TODO 3: Create a main method that demonstrates EACH of the Comparable
  // conditions, including the exceptions.
  public static void main(String[] args){
    Advanced_06_Comparable one = new Advanced_06_Comparable(1,2, 3);
    Advanced_06_Comparable two = new Advanced_06_Comparable(2,3, 4);
    ArrayList<Advanced_06_Comparable> list = new ArrayList<Advanced_06_Comparable>();
    list.add(two);
    list.add(one);
    Collections.sort(list);
    for(int i=0;i<2;i++){
      System.out.println(list.get(i).x);
    }
  }
}
