package main.com.oo2.chapter7.solitaire.table;

import java.util.Collections;

import main.com.oo2.chapter7.solitaire.cardgame.Card;
import main.com.oo2.chapter7.solitaire.cardgame.Deck;
import main.com.oo2.chapter7.solitaire.main.Solitaire;

public class DeckPile extends CardPile {

    public DeckPile(int deckPos, int i) {

        super(deckPos, i);

        this.pile = new Deck().getDeck();
        this.flipAll();
        shuffle();
    }

    @Override
    public boolean canTake(Card aCard) {

        return false;
    }

    @Override
    public void select() {

        if (!this.empty()) {

            Card c = this.pop();
            c.flip();

            Solitaire.discardPile.addCard(c);
        }
    }

    public void shuffle() {

        Collections.shuffle(this.pile);
    }

    public void flipAll() {

        for (Card c : this.pile) {

            c.flip();
        }
    }
}
