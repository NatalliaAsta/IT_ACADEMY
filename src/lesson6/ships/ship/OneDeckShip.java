package lesson6.ships.ship;

import lesson6.ships.deck.Deck;
import lesson6.ships.removable.AddAndRemovable;

public class OneDeckShip extends Ship implements AddAndRemovable {

    public OneDeckShip(String name) {
        super(name);
        this.deck = Ship.ONE_DECK;
        this.decks = new Deck[Ship.ONE_DECK];
    }

    @Override
    public void add(Object obj, int num, int capacity) {
        decks[num] = (Deck) obj;
    }

    @Override
    public void remove(Object obj, int num) {
        decks[num] = null;
    }
}

