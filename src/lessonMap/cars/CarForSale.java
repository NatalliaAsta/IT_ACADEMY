package lessonMap.cars;

import lessonMap.cars.Brand;
import lessonMap.cars.Car;
import lessonMap.cars.Engine;

import java.util.Objects;

public class CarForSale extends Car {

    private double price;

    public CarForSale(Brand brand, int year, Engine engine, int secondsTo100, double price) {
        super(brand, year, engine, secondsTo100);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarForSale)) return false;
        if (!super.equals(o)) return false;
        CarForSale that = (CarForSale) o;
        return Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + super.toString() + ", price=" + price;
    }
}
