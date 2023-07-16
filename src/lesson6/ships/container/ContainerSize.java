package lesson6.ships.container;

public enum ContainerSize {
    BIG(20),
    SMALL(10)

    ;

    private int value;

    ContainerSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
