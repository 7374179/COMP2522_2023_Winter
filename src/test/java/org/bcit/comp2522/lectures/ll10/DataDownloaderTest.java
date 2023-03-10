package org.bcit.comp2522.lectures.ll10;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DataDownloaderTest {

  @Test
  void saveImage() {
    try {
      DataDownloader.saveImage("https://reqres.in/img/faces/1-image.jpg", "image.jpg");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    File file = new File("image.jpg");
    assertTrue(file.exists());
  }
}