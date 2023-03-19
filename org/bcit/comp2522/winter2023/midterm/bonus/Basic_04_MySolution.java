package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.ArrayList;

// This is an implementation of the Basic Question 04 that tests the ability to create and use interfaces.
// The code defines an interface called Basic_04_Graphic that promises a single "draw" method.
// It also defines two concrete classes Basic_04_RasterGraphic
// and Basic_04_VectorGraphic that implement the Basic_04_Graphic interface
// and override the "draw" method.


public class Basic_04_MySolution {
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

    public Basic_04_MySolution() {
        this.graphics = new ArrayList<>();
    }

//    public void Basic_04_DrawingManager() {
//        this.graphics = new ArrayList<Basic_04_Graphic>();
//    }

    public void draw() {
        for (Basic_04_Graphic graphic : graphics) {
            graphic.draw();
        }
    }

    public static void main(String[] args) {
        Basic_04_DrawingManager drawingManager = new Basic_04_DrawingManager();
        Basic_04_RasterGraphic rasterGraphic = new Basic_04_RasterGraphic();
        Basic_04_VectorGraphic vectorGraphic = new Basic_04_VectorGraphic();
        drawingManager.graphics.add(rasterGraphic);
        drawingManager.graphics.add(vectorGraphic);
        drawingManager.draw();
    }
}

