package main.com.oo2.chapter7.solitaire.table;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import main.com.oo2.chapter7.solitaire.cardgame.Card;

/**
 * to implement includes method u can use interface mouse adapter if mouse entered - just set true
 * the include if not, let it false. GG method!!!
 * 
 */


public abstract class CardPile {

    protected List<Card> pile;
    protected int        x;
    protected int        y;

    public CardPile(int x, int y) {

        this.pile = new LinkedList<Card>();

        this.x = x;
        this.y = y;
    }

    public boolean empty() {

        return pile.isEmpty();
    }

    public Card topCard() {

        if (!empty())

            return this.pile.get(pile.size() - 1);
        else
            return null;
    }

    public Card pop() {

        if (!empty())

            return this.pile.remove(pile.size() - 1);
        else
            return null;
    }

    public boolean includes(int tx, int ty) {

        return x <= tx && tx <= x + Card.WIDTH && y <= ty && ty <= y + Card.HEIGHT;
    }

    public void addCard(Card aCard) {

        pile.add(aCard);
    }

    public void draw(Graphics g) {

        if (empty()) {

            g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
        } else

            topCard().draw(g, x, y);
    }

    public abstract boolean canTake(Card aCard);

    public abstract void select();
}

