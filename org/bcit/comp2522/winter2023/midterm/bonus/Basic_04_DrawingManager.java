package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.ArrayList;

public class Basic_04_DrawingManager implements Basic_04_Graphic {
  // Basic Question 04 (5 points, 3 TODOs)
  // Idea: tests your ability to create and use interfaces

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Basic_04_myClass. Name them something useful,
  // other than "myClass", that is just an example.

  // TODO 1: Create an interface called Basic_04_Graphic which promises
  // a single "draw" method.

  // TODO 2: Make the classes necessary to make the methods below work.
  // All concrete classes, including this one, should implement your interface.

      static class Basic_04_RasterGraphic implements Basic_04_Graphic {
        public void draw() {
            System.out.println("Drawing raster graphic");
        }
    }

    static class Basic_04_VectorGraphic implements Basic_04_Graphic {
        public void draw() {
            System.out.println("Drawing vector graphic");
        }
    }

  ArrayList<Basic_04_Graphic> graphics;

  public Basic_04_DrawingManager() {
    this.graphics = new ArrayList<Basic_04_Graphic>();
  }

  public void add(Basic_04_VectorGraphic raster) {
    graphics.add(raster);
  }
  public void add(Basic_04_RasterGraphic vector) {
    graphics.add(vector);
  }

  public void draw() {
    for (Basic_04_Graphic graphic : graphics) {
      graphic.draw();
    }
  }

  public static void main(String[] args) {
    Basic_04_DrawingManager drawingManager = new Basic_04_DrawingManager();
    Basic_04_RasterGraphic rasterGraphic = new Basic_04_RasterGraphic();
    Basic_04_VectorGraphic vectorGraphic = new Basic_04_VectorGraphic();
    drawingManager.add(rasterGraphic);
    drawingManager.add(vectorGraphic);
    drawingManager.draw();
  }

}
