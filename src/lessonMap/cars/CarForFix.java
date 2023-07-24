package lessonMap.cars;

import java.util.Objects;

public class CarForFix extends Car{

    private int daysForFix;

    public CarForFix(Brand brand, int year, Engine engine, int secondsTo100, int daysForFix) {
        super(brand, year, engine, secondsTo100);
        this.daysForFix = daysForFix;
    }

    public int getDaysForFix() {
        return daysForFix;
    }

    public void setDaysForFix(int daysForFix) {
        this.daysForFix = daysForFix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarForFix)) return false;
        if (!super.equals(o)) return false;
        CarForFix carForFix = (CarForFix) o;
        return getDaysForFix() == carForFix.getDaysForFix();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDaysForFix());
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() + super.toString() + ", daysForFix=" + daysForFix;
    }
}
