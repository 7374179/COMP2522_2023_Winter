package src.main.java.org.bcit.midterm.mysolution;

public class Intermediate_04_MySolution {
    public class Intermediate_04_AnimalHierarchy {
        // a system of classes in code that models the relationships between
        // different types of Animals, specifically:
        // - Lion, Tiger, Leopard
        // - Dolphin, KillerWhale
        // - Parrot, Penguin
        //
        // created superclasses to model these relations (at least 4).
        // Also created interfaces to model abilities (at least 3).

        //Interface for Swimmers
        public interface Swimmer {
            void swim();
        }

        //Interface for Flyers
        public interface Flyer {
            void fly();
        }

        //Interface for Walkers
        public interface Walker {
            void walk();
        }

        //Superclass for Animals
        public class Animal {}

        //Superclass for Mammals
        public class Mammal extends Animal {}

        //Superclass for Birds
        public class Bird extends Animal {}

        //Superclass for Marine Animals
        public class MarineAnimal extends Animal {}

        //Class for Lion
        public class Lion extends Mammal {}

        //Class for Tiger
        public class Tiger extends Mammal {}

        //Class for Leopard
        public class Leopard extends Mammal {}

        //Class for Dolphin
        public class Dolphin extends MarineAnimal implements Swimmer {
            @Override
            public void swim() {

            }
        }

        //Class for KillerWhale
        public class KillerWhale extends MarineAnimal implements Swimmer {
            @Override
            public void swim() {

            }
        }

        //Class for Parrot
        public class Parrot extends Bird implements Flyer {
            @Override
            public void fly() {

            }
        }

        //Class for Penguin
        public class Penguin extends Bird implements Walker, Swimmer {
            @Override
            public void swim() {

            }

            @Override
            public void walk() {

            }
        }
    }
}
