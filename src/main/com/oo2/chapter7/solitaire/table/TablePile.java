package main.com.oo2.chapter7.solitaire.table;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import main.com.oo2.chapter7.solitaire.cardgame.Card;
import main.com.oo2.chapter7.solitaire.main.Solitaire;

public class TablePile extends CardPile {

    private int ty;
    List<Card>  subPile;

    public TablePile() {

        super(0, 0);
    }

    public TablePile(int xCoord, int yCoord, int pos) {

        super(xCoord, yCoord);

        this.subPile = new ArrayList<Card>();

        for (int i = 0; i < pos; i++) {
            Card c = Solitaire.deckPile.pop();
            if (i == pos - 1) {
                c.flip();
            }
            this.addCard(c);
        }
    }

    @Override
    public boolean canTake(Card aCard) {

        if (this.empty()) {

            return true;

        } else if (aCard == null) { // card empty - empty pile click

            return false;

        } else if ((this.topCard().getColor() != aCard.getColor())
                && ((this.topCard().getValue() - 1) == aCard.getValue())) {

            return true;
        }
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
        }
    }

    @Override
    public void draw(Graphics g) {

        if (empty()) {

            g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
        } else {

            for (int i = 0; i < this.pile.size(); i++) {

                Card c = this.pile.get(i);
                if (i == this.pile.size() - 1 && !c.isFaceCard()) {
                    c.flip();
                }
                c.draw(g, x, y + (y / 5) * i);
            }
        }
    }

    @Override
    public boolean includes(int tx, int ty) {

        this.ty = ty;

        return x <= tx && tx <= x + Card.WIDTH && y <= ty
                && ty <= y + (y / 5) * this.pile.size() + Card.HEIGHT;
    }

    public void getCardSublist() {

        int cardNr = 0;

        if (!this.empty()) {

            cardNr = (ty - y) / (y / 5);

            if ((ty - y) / y == 2) {
                cardNr += 5;
            }
            if (cardNr > this.pile.size()) {
                return;
            }
            subPile = this.pile.subList(cardNr, this.pile.size());
        }
    }
    
    public void move() {

        if (!subPile.isEmpty()) {

            for (int i = 0; i < Solitaire.tableau.length; i++) {

                if (Solitaire.tableau[i].canTake(subPile.get(0)) && isOrderedAndFacedUp(subPile)
                        && !Solitaire.tableau[i].pile.contains(subPile.get(0))) {

                    int lenght = subPile.size();

                    for (int j = 0; j < lenght; j++) {

                        Card c = subPile.get(j);
                        Solitaire.tableau[i].addCard(c);
                    }

                    subPile.clear();
                    subPile = new ArrayList<Card>();
                    return;
                }
            }
            subPile = new ArrayList<Card>();
        }
    }

    public List<Card> getSubPile() {
        return subPile;
    }

    public void setSubPile(List<Card> subPile) {
        this.subPile = subPile;
    }

    public boolean isOrderedAndFacedUp(List<Card> l) {

        for (int i = 0; i < l.size() - 1; i++) {

            if (!l.get(i).isFaceCard()) {
                return false;
            }
            if ((l.get(i).getValue() - l.get(i + 1).getValue()) != 1) {
                return false;
            }
        }
        return true;
    }
}
