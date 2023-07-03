package lesson4.main;

import lesson4.cats.Cat;

import java.util.Random;

public class Main {

    public static final int CATS_QUANTITY = 10;

    public static void main(String[] args) {

        Random random = new Random();

        // Создаем 10 котиков и выводим дефолтные имя и возраст:
        int i = 1;
        while (i <= CATS_QUANTITY) {
            Cat cat = new Cat();
            System.out.println(cat.toString());
            i++;
        }
        System.out.println();

        // Здесь будем использовать геттер и сеттер:
        for (int j = 1; j <= CATS_QUANTITY; j++) {
            Cat cat = new Cat();
            cat.setAge(random.nextInt(Cat.MAX_AGE));
            cat.setName(Cat.generateName(random));
            System.out.println("age=" + cat.getAge() + ", name=" + cat.getName());
        }
        System.out.println();

        // Теперь создаем котиков с помощью конструктора:
        i = 1;
        do {
            Cat cat = new Cat(random.nextInt(Cat.MAX_AGE), Cat.generateName(random));
            System.out.println(cat.toString());
            i++;
        } while (i <= CATS_QUANTITY);
        System.out.println();

        // Создаем массив котиков и выводим их данные
        Cat cats[];
        cats = new Cat[CATS_QUANTITY/2];
        for (Cat c : cats) {
            c = new Cat(random.nextInt(Cat.MAX_AGE), Cat.generateName(random));
            System.out.println(c.toString());
        }

    }
}
