package lesson6.animals.animal;

public class Horse extends  Animal{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void eat() {
        System.out.println("Лошадка ест сено");
    }

    @Override
    void sleep() {
        System.out.println("Лошадка спит в конюшне");
    }

}
