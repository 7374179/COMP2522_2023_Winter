package org.bcit.comp2522.winter2023.midterm.bonus;

public class Basic_03_MySolution {
//    The purpose of this class is to provide a basic blueprint for creating objects that represent pets.
//    It can be used as a starting point to create more specific types of pets, such as cats, dogs, or birds,
//    by extending the class and adding additional methods and attributes.
//    The class provides a simple and flexible way to model pets in Java programming.
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


