package lesson6.animals.animal;

public class Cat extends Animal{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    void eat() {
        System.out.println("Кот ест сметану");
    }

    @Override
    void sleep() {
        System.out.println("Кот спит целый день");
    }

}
