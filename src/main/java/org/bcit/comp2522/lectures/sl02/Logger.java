package org.bcit.comp2522.lectures.sl02;

import java.util.Date;

public class Logger {
  public String log(String s) {
    Date date = new Date();
    String datestring = date.toString();
    /* TODO: change the next line to add the date to String s */
    String out = datestring + " : Hello, world!";
    System.out.println(out);
    return out;
  }
}