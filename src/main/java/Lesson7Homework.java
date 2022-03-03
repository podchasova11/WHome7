/**
 * Java 1. Homework 7
 *
 * @autor Podchasova
 * @version 1.03.2022
 */

class Lesson7Homework {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Persik", 8), new Cat("Bonya", 11), new Cat("Jersi", 5),
        };
        Plate plate = new Plate(60, 20);
        System.out.println(plate);

        //feeding cats first time
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        //adding food in the plate
        System.out.println(plate);
        plate.add(40);
        System.out.println(plate);

        //feeding cats second time
        for (Cat cat : cats) {
            cat.setFullness(false); //make the cat hungry
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);

    }
}

    class Cat {
        private String name;
        private int appetite; //ability to eat for 1 time
        private boolean fullness; //satiety status

        Cat(String name, int appetite) {
            this.name = name;
            this.appetite = appetite;
            fullness = false;
        }

        void setFullness(boolean status) {
            fullness = status;
        }
        void eat(Plate plate) {
            if (!fullness) {
                fullness = plate.decreaseFood(appetite);
            }
        }

        @Override
        public String toString() {
            return "{name=" + name + ", appetite=" +
                    appetite + ", fullness=" + fullness + "}";
        }
    }

    class Plate {
        private int volume;
        private int food;

        Plate(int volume,int food) {
            this.volume = volume;
            this.food = food;
        }

        boolean decreaseFood(int portion) {
            if (food < portion) {
                return false;
            }
            food -= portion;
            return true;
        }

        void add(int food) {
            if (this.food + food <= volume) {
                this.food += food;
            }
        }

        @Override
        public String toString() {
            return "plate: " + food;
        }
    }
