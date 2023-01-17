package org.bcit.comp2522.lectures.sl03;

import java.util.Arrays;

public class Letter implements Comparable {
//  public static String order = "ZXEFTSRKPILGAMYBVUCQOWDNJH";
  public static String order = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

  String val;

  public Letter(String val) {
    this.val = val;
  }

  public Letter(Character val) {
    this.val = val.toString();
  }

  public int compareTo(Object o) {
    if (((Letter) o).val.compareTo(this.val)>0){
      return 1;
    }else if(((Letter) o).val.compareTo(this.val)<0){
      return -1;
    }else {
      return 0;
    }
  }
}