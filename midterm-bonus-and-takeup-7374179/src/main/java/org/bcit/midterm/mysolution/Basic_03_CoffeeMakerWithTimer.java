package src.main.java.org.bcit.midterm.mysolution;

public class Basic_03_CoffeeMakerWithTimer extends Basic_03_CoffeeMaker {
    float waterLevel;
    float coffeeLevel;
    int timer;


    public Basic_03_CoffeeMakerWithTimer(){
        this.waterLevel=1000;
    }
    public void startTimer(int i) {
        timer = i;
    }
    @Override
    public void makeCoffee() {
        try {
            Thread.sleep((long) timer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (this.waterLevel > 0f) {
            System.out.format("Coffee is at %d millileters...\n", this.coffeeLevel);
            this.coffeeLevel += 1f;
            this.waterLevel -= 1f;
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Coffee is done!!");
    }
}
