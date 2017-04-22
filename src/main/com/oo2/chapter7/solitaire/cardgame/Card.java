package main.com.oo2.chapter7.solitaire.cardgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Card extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final int WIDTH;
    public static final int HEIGHT;

    private final int       suit;
    private final int       value;

    private Boolean         faceCard;

    private BufferedImage   image;

    private final int       color;


    static {
        WIDTH = 79;
        HEIGHT = 115;
    }

    public Card(int theSuit, int theValue) {

        if (theSuit != CardNames.SPADES && theSuit != CardNames.HEARTS
                && theSuit != CardNames.DIAMONDS && theSuit != CardNames.CLUBS) {

            throw new IllegalArgumentException(" Illegal playing card suit ");
        }
        if (theValue < 1 || theValue > 13) {

            throw new IllegalArgumentException(" Illegal playing card value ");
        }
        this.value = theValue;
        this.suit = theSuit;

        this.faceCard = true;

        if (this.suit == CardNames.HEARTS || this.suit == CardNames.DIAMONDS) {
           
            this.color = CardNames.RED;
        } else {
            this.color = CardNames.BLACK;
        }


        try {
          
            this.image = ImageIO.read(Card.class.getResource("resources/cards.png"));
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public int getSuit() {

        return this.suit;
    }


    public int getValue() {

        return this.value;
    }

    public String getSuitAsString() {

        switch (this.suit) {

            case CardNames.SPADES: {

                return "Spades";
            }
            case CardNames.HEARTS: {

                return "Hearts";
            }
            case CardNames.DIAMONDS: {

                return "Diamonds";
            }
            case CardNames.CLUBS: {

                return "Clubs";
            }
            default: {

                return "Null";
            }
        }
    }

    public String getValueAsString() {

        switch (this.value) {
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            default:
                return "King";
        }
    }


    public int getColor() {
        return color;
    }

    public Boolean isFaceCard() {
        return faceCard;
    }

    public void setFaceCard(Boolean faceCard) {
        this.faceCard = faceCard;
    }

    public String toString() {

        return getValueAsString() + " of " + getSuitAsString();
    }

    public void flip() {

        if (this.faceCard) {

            this.faceCard = false;
        } else {

            this.faceCard = true;
        }
    }

    public void draw(Graphics g, int x, int y) {

        super.paintComponent(g);

        int cx;
        int cy;

        if (!this.faceCard) {

            cy = 4 * Card.HEIGHT;
            cx = 2 * Card.WIDTH;
        } else {

            cx = (getValue() - 1) * Card.WIDTH;

            switch (getSuit()) {
                case CardNames.CLUBS: {
                    cy = 0;
                    break;
                }
                case CardNames.DIAMONDS: {
                    cy = Card.HEIGHT;
                    break;
                }
                case CardNames.HEARTS: {
                    cy = 2 * Card.HEIGHT;
                    break;
                }
                default: {
                    cy = 3 * Card.HEIGHT;
                    break;
                }
            }
        }
        g.drawImage(image, x, y, x + Card.WIDTH, y + Card.HEIGHT, cx, cy, cx + Card.WIDTH,
                cy + Card.HEIGHT, this);
    }
}
