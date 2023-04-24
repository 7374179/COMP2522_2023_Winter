package src.main.java.org.bcit.midterm.mysolution;

public class Intermediate_04_Hierarchies {
    // Intermediate Question 04 (10 points, 2 TODOs)
    // Idea: tests your ability to model real-world phenomena using classes.

    // README FIRST
    // I will ONLY be reading from this package:
    //   org.bcit.comp2522.winter2023.midterm.answers
    //
    // TODO 0: Create a copy of this file in the answers package.
    // Put your answers in new classes that are labeled with the
    // question label, e.g., Intermediate_04_myClass. Name them something
    // useful, other than "myClass", that is just an example.

    // TODO 1: Create a system of classes in code that models the relationships between
    // different types of Animals, specifically:
    // - BlueWhale, Dog, Bear
    // - Trout, Shark
    // - Tree, VenusFlyTrap
    //
    // Create superclasses to model these relations (at least 4).
    // Also create interfaces to model abilities (at least 3).
    // Marks given for clarity, readability, and correctness.

    //Interface for Swimmers
    public interface Swimmer {
        void swim();
    }

    //Interface for Runners
    public interface Runner {
        void run();
    }

    //Interface for Climbers
    public interface Climber {
        void climb();
    }

    //Superclass for Animals
    public class Animal {}

    //Superclass for Mammals
    public class Mammal extends Animal {}

    //Superclass for Fishes
    public class Fish extends Animal {}

    //Superclass for Plants
    public class Plant {}

    //Class for BlueWhale
    public class BlueWhale extends Mammal {}

    //Class for Dog
    public class Dog extends Mammal {}

    //Class for Bear
    public class Bear extends Mammal {}

    //Class for Trout
    public class Trout extends Fish {}

    //Class for Shark
    public class Shark extends Fish {}

    //Class for Tree
    public class Tree extends Plant {}

    //Class for VenusFlyTrap
    public class VenusFlyTrap extends Plant {}
}
