package lessonMap.cars;

import java.util.Objects;

public abstract class Car {

    private Brand brand;

    private int year;

    private Engine engine;

    private int secondsTo100;

    public Car(Brand brand, int year, Engine engine, int secondsTo100) {
        this.brand = brand;
        this.year = year;
        this.engine = engine;
        this.secondsTo100 = secondsTo100;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getSecondsTo100() {
        return secondsTo100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o.getClass() == this.getClass())) return false;
        Car car = (Car) o;
        return getYear() == car.getYear()
                && getSecondsTo100() == car.getSecondsTo100()
                && getBrand() == car.getBrand()
                && getEngine() == car.getEngine();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getYear(), getEngine(), getSecondsTo100());
    }

    @Override
    public String toString() {
        return  brand +
                ", year=" + year +
                ", engine=" + engine +
                ", secondsTo100=" + secondsTo100 +
                '}';
    }
}
