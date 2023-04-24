package org.bcit.comp2522.exam.questions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Q2_SaveMenuItem {
  public void save() {
    FileWriter fw = null;
    try {
     fw = new FileWriter("save.txt", true);
     BufferedWriter bw = new BufferedWriter(fw);
     bw.write("save menu item");
     bw.newLine();
     bw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}