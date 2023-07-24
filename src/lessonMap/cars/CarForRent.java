package lessonMap.cars;

import java.util.Objects;

public class CarForRent extends Car{

    private double pricePerHour;

    public CarForRent(Brand brand, int year, Engine engine, int secondsTo100, double pricePerHour) {
        super(brand, year, engine, secondsTo100);
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarForRent)) return false;
        if (!super.equals(o)) return false;
        CarForRent that = (CarForRent) o;
        return Double.compare(that.pricePerHour, pricePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pricePerHour);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + super.toString() + ", pricePerHour=" + pricePerHour;
    }
}
