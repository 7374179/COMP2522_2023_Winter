package org.bcit.comp2522.winter2023.midterm.bonus;

public class Basic_03_MySolution {
    // Basic Question 03 (5 points, 2 TODOs)
    // Idea: tests your ability to create super/sub classes

    // TODO 0: Create a copy of this file in the answers package.
    // Put your answers in new classes that are labeled with the
    // question label, e.g., Basic_03_myClass. Name them something useful,
    // other than "myClass", that is just an example.

    String name;
    String breed;
    int age;

    public Basic_03_MySolution(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("The pet makes a sound.");
    }
}

// TODO 1: Create a subclass that EXTENDS this class by adding
// a new core functionality: training the pet to do a trick.
// You MUST NOT recreate any functionality that this class already
// implements. You MUST use this class. You can call this class
// Basic_05_TrainablePet.

