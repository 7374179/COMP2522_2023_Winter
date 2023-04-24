package org.bcit.comp2522.lectures.ll06;

import java.io.FileReader;
import java.io.FileWriter;

public class ReadFromFile {
  public static void main(String args[]) {

    // Creates an array of character
    int length = 100;
    char[] array = new char[length];

    try {
      // Creates a reader using the FileReader
      FileReader input = new FileReader("input.txt");

      // Reads characters
      input.read(array);

      for (int i = 0; i < length; i++) {
        if (array[i] == 0) {
          array[i] = 32;
        }
      }

      System.out.println("Data in the file: ");
      System.out.println(array);

      // Closes the reader
      input.close();
    }

    catch(Exception e) {
      e.getStackTrace();
    }
  }
}
