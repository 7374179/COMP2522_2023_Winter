package org.bcit.comp2522.lectures.sl03;

public class Letter {
  public static String order = "ZXEFTSRKPILGAMYBVUCQOWDNJH";
  String val;
  public Letter(String val) {
    this.val = val;
  }
  public Letter(Character val) {
    this.val = val.toString();
  }

}