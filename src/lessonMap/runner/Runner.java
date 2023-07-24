package lessonMap.runner;

import lessonMap.cars.Brand;
import lessonMap.cars.Car;
import lessonMap.cars.CarForRent;
import lessonMap.cars.CarForSale;
import lessonMap.cars.Engine;
import lessonMap.garage.Garage;

public class Runner {
    public static void run() {
        Garage garage = new Garage();
        Car forSale1 = new CarForSale(Brand.AUDI, 2022, Engine.GASOLINE, 5, 40000);
        garage.park(forSale1);
        Car forSale2 = new CarForSale(Brand.GEELY, 2023, Engine.HYBRID, 7, 50000);
        garage.park(forSale2);
        Car forSale3 = new CarForSale(Brand.GEELY, 2023, Engine.HYBRID, 7, 50000);
        garage.park(forSale3);
        Car forRent1 = new CarForRent(Brand.GEELY, 2023, Engine.HYBRID, 7, 5);
        garage.park(forRent1);
        garage.print();
        garage.leave(forRent1);
        garage.print();
        garage.leave(forSale1);
        garage.print();

        System.out.println(garage.getKindAmount(forSale1.getClass(), Brand.GEELY));
        System.out.println(garage.getKindAmount(forSale3.getClass(), Brand.AUDI));
    }
}
