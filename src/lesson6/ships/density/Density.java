package lesson6.ships.density;

public enum Density {

    D1000(1000),
    D2000(2000)

    ;
    private int value;

    public int getValue() {
        return value;
    }

    Density(){}

    Density(int value) {
        this.value = value;
    }


}
