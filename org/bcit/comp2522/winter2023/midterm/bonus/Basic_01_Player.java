package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.Random;

public class Basic_01_Player {
    float x;
    float y;
    int count;
    int id;
    String label;

    Basic_01_Player(int id) {
        this.id = id;
    }

    Basic_01_Player(String label) {
        Random rand = new Random();
        this.id = rand.nextInt(50);
        this.label = label;
        this.x = 0;
        this.y = 0;
        this.count = 0;
    }

    public void move(float x, float y) {
        this.x = x;
        this.y = y;
        count++;
    }
}
