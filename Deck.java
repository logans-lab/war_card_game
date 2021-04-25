package Model;

import java.util.Arrays;
import java.util.Random;

public class Deck extends Hand {

    private static Card[] deck;
    private static final int CARDS_IN_DECK = 52;

    public Deck() {
        deck = new Card[CARDS_IN_DECK];
    }

    public static Card[] getDeck() {
        return deck;
    }

    //sets 52 cards with unique rank and suit values
    public void populateDeck() {
        int counter = 0;
        for (int i = 0; i < Rank.values().length; i++) {
            for (int j = 0; j < Suit.values().length; j++) {
                deck[counter] = new Card(Rank.getRank(i), Suit.getSuit(j));
                counter++;
            }
        }
    }

    //Fisher Yates Shuffle algorithm
    public void shuffleDeck(Card[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i);
            Card temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    //deal cards from deck to hands
    public void deal() {
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            if (i % 2 == 0) {
                setPlayer1Deck(getDeck()[i]);
            } else {
                setPlayer2Deck(getDeck()[i]);
            }
        }
    }

    public void printDeck() {
        System.out.println("Full deck: ");
        System.out.println(Arrays.toString(getDeck()));
    }
}
