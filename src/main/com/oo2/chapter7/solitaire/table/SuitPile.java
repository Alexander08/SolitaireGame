package main.com.oo2.chapter7.solitaire.table;

import main.com.oo2.chapter7.solitaire.cardgame.Card;
import main.com.oo2.chapter7.solitaire.cardgame.CardNames;

public class SuitPile extends CardPile {

    public SuitPile() {

        this(0, 0);
    }

    public SuitPile(int xCoord, int yCoord) {

        super(xCoord, yCoord);
    }

    @Override
    public boolean canTake(Card aCard) {

        if (aCard == null) { // card empty - empty pile click

            return false;
        }
        if (this.empty()) { // list empty

            if (aCard.getValue() == CardNames.ACE) {

                return true;
            }
            return false;
        }
        if ((this.topCard().getSuit() == aCard.getSuit())
                && ((this.topCard().getValue() + 1) == (aCard.getValue()))) {

            return true;
        }
        return false;
    }

    @Override
    public void select() {}

    public int getPileSize() {

        return this.pile.size();
    }
}
