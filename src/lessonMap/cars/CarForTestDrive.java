package lessonMap.cars;

import java.util.Objects;

public class CarForTestDrive extends Car{

    private String color;

    public CarForTestDrive(Brand brand, int year, Engine engine, int secondsTo100, String color) {
        super(brand, year, engine, secondsTo100);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarForTestDrive)) return false;
        if (!super.equals(o)) return false;
        CarForTestDrive that = (CarForTestDrive) o;
        return getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + super.toString() + ", color=" + color ;
    }
}
