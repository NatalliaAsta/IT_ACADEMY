package lesson6.ships.deck;

import lesson6.ships.containerShaped.ContainerShaped;
import lesson6.ships.removable.AddAndRemovable;

public class Deck<T extends ContainerShaped> implements AddAndRemovable<T> {

    public static final int BIG = 2;
    public static final int SMALL = 4;

    private boolean isBig;
    private T[] containers;

    public Deck(boolean isBig) {
        this.isBig = isBig;
    }

    public int getDeckSize() {
        return isBig ? BIG : SMALL;
    }


    @Override
    public void add(T obj, int num, int capacity) {
        if (num == 0) {
            containers = (T[]) new ContainerShaped[capacity];
        }
        containers[num] = (T) obj;
    }

    @Override
    public void remove(T obj, int num) {
        containers[num] = null;
    }
}

