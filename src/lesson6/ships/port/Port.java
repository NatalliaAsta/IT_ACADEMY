package lesson6.ships.port;

import lesson6.ships.removable.AddAndRemovable;
import lesson6.ships.ship.Ship;

public class Port implements AddAndRemovable {

    private Ship[] ships;

    public Port(Ship[] ships) {
        this.ships = ships;
    }

    @Override
    public void add(Object obj, int num, int capacity) {
        ships[num] = (Ship) obj;
    }

    @Override
    public void remove(Object obj, int num) {
        ships[num] = null;
    }
}
