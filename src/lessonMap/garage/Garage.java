package lessonMap.garage;

import lessonMap.cars.Brand;
import lessonMap.cars.Car;

import java.util.HashMap;
import java.util.Map;

public class Garage {

    private Map<Car, Integer> cars = new HashMap();

    private int amountEqualCars(Car car){
        return cars.get(car).intValue();
    }

    public void park(Car car){
        System.out.println("В гараже припарковался автомобиль " + car);
        if (cars.containsKey(car)){
            int existAmount = amountEqualCars(car);
            cars.put(car, ++existAmount);
        } else {
            cars.put(car, 1);
        }
    }

    public void leave(Car car){
        System.out.println("Граж покинул автомобиль " + car);
        if (cars.containsKey(car)) {
            int existAmount = amountEqualCars(car);
            cars.put(car, --existAmount);
        }
        if (amountEqualCars(car) == 0) {
            cars.remove(car);
        }
    }



    public void print(){
        System.out.println("В гараже сейчас находятся следующие автомобили: ");
        for(Map.Entry<Car, Integer> entry : cars.entrySet()) {
            Car car = entry.getKey();
            Integer amount = entry.getValue();
            System.out.println(car + " в количестве " + amount + "шт.");
        }
    }

    public int getKindAmount(Class<? extends Car> kind, Brand brand){
        int ret = 0;
        for(Map.Entry<Car, Integer> entry : cars.entrySet()) {
            Car car = entry.getKey();
            if (car.getClass() == kind & car.getBrand() == brand) {
                ret = ret + entry.getValue();
            }
        }
        return ret;
    }
}
