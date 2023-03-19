package org.bcit.comp2522.winter2023.midterm.bonus;

public class Basic_03_MySolution_TrainablePet extends Basic_03_MySolution {

    private String trick;

    public Basic_03_MySolution_TrainablePet(String name, String breed, int age) {
        super(name, breed, age);
        this.trick = "sit";
    }

    public void doTrick() {
        System.out.format("The pet does a %s trick!\n", this.trick);
    }

    public void setTrick(String trick) {
        this.trick = trick;
    }

    public static void main(String[] args) {
        Basic_03_MySolution pet = new Basic_03_MySolution_TrainablePet("Max", "Golden Retriever", 3);
        pet.makeSound(); // should print "The pet makes a sound."
        Basic_03_MySolution_TrainablePet trainablePet = (Basic_03_MySolution_TrainablePet) pet;
        trainablePet.doTrick(); // should print "The pet does a trick!"
    }
}
