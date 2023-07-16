package lesson6.ships.ship;

import lesson6.ships.deck.Deck;
import lesson6.ships.removable.AddAndRemovable;

public class TwoDeckShip extends Ship implements AddAndRemovable {


    public TwoDeckShip(String name) {
        super(name);
        this.deck = Ship.TWO_DECK;
        this.decks = new Deck[Ship.TWO_DECK];
    }

    @Override
    public void add(Object obj, int num, int capacity) {

    }

    @Override
    public void remove(Object obj, int num) {
        this.decks[num] = null;
    }

}
