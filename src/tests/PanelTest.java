package tests;

import java.awt.Graphics;

import javax.swing.JPanel;

import main.com.oo2.chapter7.solitaire.cardgame.Card;
import main.com.oo2.chapter7.solitaire.cardgame.Deck;

public class PanelTest extends JPanel {

    Card c;
    int  coordX;
    int  coordY;
    Deck d;
    
    PanelTest() {

        super();
        c = new Card(1, 13);
        d = new Deck();
    }

    public void printADeck(Graphics g) {

        
        coordX = 10;
        coordY = 10;
        int all = d.size();
        for (int i = 1; i <= all; i++) {

            d.getDeck().get(i - 1).draw(g, coordX, coordY);
            coordX += Card.WIDTH + 5;
            
            if (i % 13 == 0) {
                
                coordY += Card.HEIGHT + 5;
                coordX = 10;
            }
        }
    }

    public void panelTest() {

        repaint();
        c.flip();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        printADeck(g);;
    }
}
