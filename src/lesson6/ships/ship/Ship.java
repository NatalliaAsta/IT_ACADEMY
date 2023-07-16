package lesson6.ships.ship;

import lesson6.ships.deck.Deck;
import lesson6.ships.removable.AddAndRemovable;

public abstract class Ship implements AddAndRemovable {

    public static final int TWO_DECK = 2;
    public static final int ONE_DECK = 1;

    protected String name;
    protected int deck;
    protected Deck[] decks;

    public Ship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
