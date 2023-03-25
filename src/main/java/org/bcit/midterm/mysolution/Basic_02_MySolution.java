package src.main.java.org.bcit.midterm.mysolution;

public class Basic_02_MySolution {
//    This code defines a Vehicle class that is composed of an Engine, Transmission, and FuelTank.
//    The Vehicle class has functions to start, accelerate, and stop the vehicle,
//    which in turn invoke the corresponding functions of the composed classes.
//    The Engine class has functions to start, increase RPM, and stop the engine.
//    The Transmission class has a function to change the gear based on the RPM of the engine.
//    The FuelTank class has a function to use fuel when the vehicle accelerates.
    public class Vehicle {
        private Engine engine;
        private Transmission transmission;
        private FuelTank fuelTank;

        public Vehicle() {
            this.engine = new Engine();
            this.transmission = new Transmission();
            this.fuelTank = new FuelTank(50);
        }

        public void start() {
            engine.start();
        }

        public void accelerate() {
            engine.increaseRpm();
            transmission.changeGear(engine.getRpm());
            fuelTank.useFuel();
        }

        public void stop() {
            engine.stop();
        }
    }

    class Engine {
        private int rpm;

        public Engine() {
            this.rpm = 0;
        }

        public void start() {
            System.out.println("Engine started.");
        }

        public void increaseRpm() {
            rpm += 1000;
        }

        public int getRpm() {
            return rpm;
        }

        public void stop() {
            rpm = 0;
            System.out.println("Engine stopped.");
        }
    }

    class Transmission {
        private int gear;

        public Transmission() {
            this.gear = 1;
        }

        public void changeGear(int rpm) {
            if (rpm < 1000) {
                gear = 1;
            } else if (rpm < 2000) {
                gear = 2;
            } else if (rpm < 3000) {
                gear = 3;
            } else {
                gear = 4;
            }
            System.out.println("Gear changed to " + gear);
        }
    }

    class FuelTank {
        private int fuelLevel;

        public FuelTank(int initialFuelLevel) {
            this.fuelLevel = initialFuelLevel;
        }

        public void useFuel() {
            fuelLevel -= 2;
            System.out.println("Fuel level: " + fuelLevel);
        }
    }
    public static void main(String[] args) {
        Basic_02_MySolution.Vehicle car = new Basic_02_MySolution().new Vehicle();
        car.start();
        for (int i = 0; i < 10; i++) {
            car.accelerate();
        }
        car.stop();
    }
}

