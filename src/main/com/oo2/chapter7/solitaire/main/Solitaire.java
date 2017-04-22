package main.com.oo2.chapter7.solitaire.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.com.oo2.chapter7.solitaire.cardgame.Card;
import main.com.oo2.chapter7.solitaire.table.CardPile;
import main.com.oo2.chapter7.solitaire.table.DeckPile;
import main.com.oo2.chapter7.solitaire.table.DiscardPile;
import main.com.oo2.chapter7.solitaire.table.SuitPile;
import main.com.oo2.chapter7.solitaire.table.TablePile;

public class Solitaire extends JPanel implements MouseListener {

    private static final long serialVersionUID = 1L;

    public static DeckPile    deckPile;
    public static DiscardPile discardPile;
    public static TablePile   tableau[];
    public static SuitPile    suitPile[];
    public static CardPile    allPiles[];


    public Solitaire() {

        setBackground(Color.green);
        addMouseListener(this);

        allPiles = new CardPile[13];
        suitPile = new SuitPile[4];
        tableau = new TablePile[7];

        int deckPos = 600;
        int suitPos = 15;

        allPiles[0] = deckPile = new DeckPile(deckPos, 5);
        allPiles[1] = discardPile = new DiscardPile(deckPos - Card.WIDTH - 10, 5);

        for (int i = 0; i < 4; i++) {

            allPiles[2 + i] = suitPile[i] = new SuitPile(suitPos + (Card.WIDTH + 10) * i, 5);
        }
        for (int i = 0; i < 7; i++) {

            allPiles[6 + i] = tableau[i] =
                    new TablePile(suitPos + (Card.WIDTH + 10) * i, Card.HEIGHT + 20, i + 1);
        }
        repaint();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (int i = 0; i < 13; i++) {
            allPiles[i].draw(g);
        }
        g.drawString(
                "To Move a block of cards, you need to keep SHIFT pressed + Click on the block",
                170, 500);

        int cntPile = 0;
        for (int i = 0; i < 4; i++) {
            cntPile += suitPile[i].getPileSize();
        }
        if (cntPile == 52) {
            String message =
                    "You Win! Close the game and reopen for a new game!\n I know, i know... next version will have a start new game button";
            JOptionPane.showMessageDialog(this, message, "Congratulation!!! ",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.setTitle("Solitaire");

        Solitaire s = new Solitaire();

        frame.add(s);
        frame.validate();
        s.repaint();
    }

    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        if (!e.isShiftDown()) {

            for (int i = 0; i < 13; i++) {

                if (allPiles[i].includes(x, y)) {

                    allPiles[i].select();
                    repaint();
                    return;
                }
            }
        } else {
            for (int i = 0; i < 7; i++) {

                if (tableau[i].includes(x, y)) {

                    tableau[i].getCardSublist();

                    if (!tableau[i].getSubPile().isEmpty()) {

                        tableau[i].move();
                    }
                    repaint();
                    return;
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
}

