package main.com.oo2.chapter7.solitaire.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.com.oo2.chapter7.solitaire.util.SortingBySuits;
import main.com.oo2.chapter7.solitaire.util.SortingByValue;

public class Deck {

    private List<Card> myDeck;

    /**
     * Constructor. Create a deck of cards .
     * 
     * @precondition : None
     * @postcondition : A deck of 52 , shuffled cards is created .
     **/
    public Deck() {

        this.myDeck = new ArrayList<Card>();

        for (int i = CardNames.ACE, j = 0; j <= CardNames.SPADES; i++) {

            Card c = new Card(j, i);
            
            if (i == CardNames.KING) {

                j++;
                i = 0;
            }
            this.myDeck.add(c);
        }
    }

    /**
     * Shuffle all cards in the deck into a random order.
     * 
     * @precondition : None
     * @postcondition : The existing deck of cards with the cards in random order .
     **/
    public void shuffle() {

        Collections.shuffle(this.myDeck);
    }

    /**
     * Returns the size of the deck
     * 
     * @return the number of cards that are still left in the deck .
     * @precondition : None
     * @postcondition : The deck is unchanged .
     **/
    public int size() {

        return this.myDeck.size();
    }

    /**
     * Determine if this deck is empty
     * 
     * @return true if this deck has no cards left in the deck .
     * @precondition : None
     * @postcondition : The deck is unchanged .
     */
    public boolean isEmpty() {

        return this.myDeck.isEmpty();
    }

    /**
     * Deal one card from this deck
     * 
     * @return a Card from the deck .
     * @precondition : The deck is not empty
     * @postcondition : The deck has one less card .
     */
    public Card dealCard() {

        // Collections.shuffle(this.myDeck);
        return this.myDeck.remove(this.myDeck.size() - 1);
    }

    /**
     * Sorts the cards in the hand in suit order and in value order with in suits. Note that aces
     * have the lowest value , 1.
     * 
     * @precondition : none
     * @postcondition : Cards of the same suit are grouped together , and with in a suit the cards
     *                are sorted by value .
     */
    public void sortBySuit() {

        Collections.sort(this.myDeck, new SortingBySuits());
    }

    /**
     * Sorts the cards in the hand so that cards are sorted in to order of increasing value. Cards
     * with the same value are sorted by suit.
     * 
     * @precondition : none
     * @postcondition: Cards are sorted in order of increasing value.
     */
    public void sortByValue() {

        Collections.sort(this.myDeck, new SortingByValue());
    }

    @Override
    public String toString() {

        return this.myDeck.toString();
    }

    public List<Card> getDeck() {
        return this.myDeck;
    }
}
