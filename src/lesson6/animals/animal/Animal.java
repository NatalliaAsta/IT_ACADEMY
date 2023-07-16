package lesson6.animals.animal;

public abstract class Animal {
    protected String food = "Мясо";
    protected String location = "Лес";

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    abstract void eat();
    abstract void sleep();
    public void makeNoise(){
        System.out.println("Животное шумит");
    };

}
