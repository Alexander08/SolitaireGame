package main.com.oo2.chapter7.solitaire.util;

import java.util.Comparator;

import main.com.oo2.chapter7.solitaire.cardgame.Card;

public class SortingBySuits implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {

        if(Integer.compare(o1.getSuit(), o2.getSuit()) == 0){
            
            return Integer.compare(o1.getValue(), o2.getValue());
        }
        return Integer.compare(o1.getSuit(), o2.getSuit());
    }
}
