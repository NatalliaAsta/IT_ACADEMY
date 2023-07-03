package lesson4.cats;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Cat {

    public static final String DEFAULT_NAME = "Murzik";
    public static final int DEFAULT_AGE = 15;
    public static final int MAX_AGE = 29;

    private int age = DEFAULT_AGE;
    private String name = DEFAULT_NAME;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Конструктор, принимающий в качестве параметров имя и возраст:
    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // Т.к. у нас есть конструктор, принимающий в качестве параметров имя и возраст,
    // конструктор по умолчанию нужно определить явно:
    public Cat() {
    }

    public static String generateName(Random r) {
        String retName = "";
        for (int i=1; i<=6; i++) {
            //Имя должно начинаться с большой буквы
            if (i==1) {
                retName = String.valueOf((char)(r.nextInt(26) + 'A'));
            } else {
                retName = retName + (String.valueOf((char)(r.nextInt(26) + 'A'))).toLowerCase(Locale.ROOT);
            }
        }
        return retName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return  "age=" + age +
                ", name=" + name;
    }
}
