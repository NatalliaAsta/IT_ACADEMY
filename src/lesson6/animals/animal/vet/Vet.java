package lesson6.animals.animal.vet;

import lesson6.animals.animal.Animal;

public class Vet {
    public static void treatAnimal(Animal animal){
        System.out.println(animal.getFood());
        System.out.println(animal.getLocation());
    }
}
