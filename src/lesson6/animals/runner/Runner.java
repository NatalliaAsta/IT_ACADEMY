package lesson6.animals.runner;

import lesson6.animals.animal.Animal;
import lesson6.animals.animal.Cat;
import lesson6.animals.animal.Dog;
import lesson6.animals.animal.Horse;
import lesson6.animals.animal.vet.Vet;

public class Runner {
    public static void run() {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Horse();

        for(Animal animal :animals) {
            Vet.treatAnimal(animal);
        }

    }
}
