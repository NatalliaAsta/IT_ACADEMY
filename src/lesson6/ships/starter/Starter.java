package lesson6.ships.starter;

import lesson6.ships.container.ContainerSize;
import lesson6.ships.container.ConeContainer;
import lesson6.ships.container.ContainerBase;
import lesson6.ships.container.CubeContainer;
import lesson6.ships.container.CylinderContainer;
import lesson6.ships.deck.Deck;
import lesson6.ships.density.Density;
import lesson6.ships.port.Port;
import lesson6.ships.ship.OneDeckShip;
import lesson6.ships.ship.Ship;
import lesson6.ships.ship.TwoDeckShip;

import java.util.Random;

public class Starter {

    /*
    Метод для генерации имени корабля
     */
    static String generateStringVal(int lng) {
        Random random = new Random();
        String retVal = "";
        for (int i = 1; i <= lng; i++) {
            retVal = retVal + (char) (random.nextInt(26) + 'A');
        }
        return retVal;
    }

    public static void start() {
        long totalMass = 0;

        /* Количество кораблей, которое прибудет в порт */
        int shipAmount = (int) (Math.random() * 100);
        if (shipAmount < 10) {
            shipAmount = shipAmount + 10;
        }

        Ship[] ships = new Ship[shipAmount];
        Port port = new Port(ships);
        System.out.println("В порт прибудет " + shipAmount + " кораблей");

        for (int k = 0; k < shipAmount; k++) {
            Ship ship;
            long shipMass = 0;

            if (k % 2 == 0) {           /* Четные корабли будут однопалубными, остальные двухпалубными */

                ship = new OneDeckShip(generateStringVal(5));
                port.add(ship, k, shipAmount);
                Deck<ContainerBase> deck = new Deck<>(true);
                ship.add(deck, 0, 1);
                for (int i = 0; i < deck.getDeckSize(); i++) {
                    ContainerBase cone = new ConeContainer(ContainerSize.BIG, Density.D1000);
                    shipMass = shipMass + (long) cone.getMass();
                    deck.add(cone, i, deck.getDeckSize());
                }

            } else {
                ship = new TwoDeckShip(generateStringVal(9));
                port.add(ship, k, shipAmount);
                /* На одной палубе двухпалубного корабля поместим кубические контейнеры, на второй - цилиндрические */
                Deck<ContainerBase> deck = new Deck<>(false);
                ship.add(deck, 0, 2);
                for (int i = 0; i < deck.getDeckSize(); i++) {
                    ContainerBase cube = new CubeContainer(ContainerSize.SMALL, Density.D2000);
                    shipMass = shipMass + (long) cube.getMass();
                    deck.add(cube, i, deck.getDeckSize());
                }
                Deck<ContainerBase> cylinder = new Deck<>(false);
                ship.add(deck, 1, 2);
                for (int i = 0; i < deck.getDeckSize(); i++) {
                    ContainerBase cyl = new CylinderContainer(ContainerSize.SMALL, Density.D2000);
                    shipMass = shipMass + (long) cyl.getMass();
                    cylinder.add(cyl, i, deck.getDeckSize());
                }
            }
            System.out.println("В порт прибыл корабль № " + (k + 1) + " "
                    + ship.getName() + "  "
                    + " c массой груза " + shipMass );
            totalMass = totalMass + shipMass;
        }
        System.out.println("Общая масса груза, прибывшего в порт, составила " + totalMass);
    }
}