package lesson6.ships.removable;

public interface AddAndRemovable<R> {
    void add(R obj, int num, int capacity);
    void remove(R obj, int num);
}
