package lesson6.animals.animal;

public class Dog extends Animal{

    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    void eat() {
        System.out.println("Собака ест много мяса");
    }

    @Override
    void sleep() {
        System.out.println("Собака спит на коврике");
    }


}
