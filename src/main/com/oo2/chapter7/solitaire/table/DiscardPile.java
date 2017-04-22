package main.com.oo2.chapter7.solitaire.table;

import java.awt.Graphics;
import java.util.ArrayList;

import main.com.oo2.chapter7.solitaire.cardgame.Card;
import main.com.oo2.chapter7.solitaire.main.Solitaire;

public class DiscardPile extends CardPile {

    public DiscardPile() {
        this(0, 0);
    }

    public DiscardPile(int xCoord, int yCoord) {
        super(xCoord, yCoord);
    }

    @Override
    public boolean canTake(Card aCard) {

        return false;
    }

    @Override
    public void select() {

        if (!this.empty()) {
            
            for (int i = 0; i < Solitaire.allPiles.length; i++) {

                if (Solitaire.allPiles[i].canTake(this.topCard())) {

                    Card c = this.pop();
                    Solitaire.allPiles[i].addCard(c);
                    return;
                }
            }
            if (Solitaire.deckPile.empty()) {

                Solitaire.deckPile.pile = this.pile;
                Solitaire.deckPile.flipAll();
                this.pile = new ArrayList<Card>();
                return;
            }
        }
    }


    @Override
    public void addCard(Card c) {

        super.addCard(c);
    }


    @Override
    public void draw(Graphics g) {

        if (empty()) {

            g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
        } else

            topCard().draw(g, x, y);
    }
}
