package Model;

import java.util.ArrayList;

public class Hand {

    private static ArrayList<Card> player1Deck = new ArrayList<>();
    private static ArrayList<Card> player2Deck = new ArrayList<>();

    public Hand() {
    }

    public ArrayList<Card> getPlayer1Deck() {
        return player1Deck;
    }

    public void setPlayer1Deck(Card card) { player1Deck.add(card); }

    public ArrayList<Card> getPlayer2Deck() {
        return player2Deck;
    }

    public void setPlayer2Deck(Card card) {
        player2Deck.add(card);
    }

    public void giveCardsToPlayer1(ArrayList<Card> oldArrayList, int position) {
        for (int i = 0; i < position + 1; i++) {
            setPlayer1Deck(oldArrayList.get(0));
            oldArrayList.remove(0);
        }
    }

    public void giveCardsToPlayer2(ArrayList<Card> oldArrayList, int position) {
        for (int i = 0; i < position + 1; i++) {
            setPlayer2Deck(oldArrayList.get(0));
            oldArrayList.remove(0);
        }
    }

    //name of card to display
    public Card flipCard(ArrayList<Card> cardArrayList, int position) {
        return cardArrayList.get(position);
    }

    //rank value of card to compare
    public int playCard(ArrayList<Card> cardArrayList, int position) {
        return cardArrayList.get(position).getRank();
    }

    public void printPlayer1Hand() {
        System.out.println("Player 1 hand: ");
        System.out.println(getPlayer1Deck());
    }

    public void printPlayer2Hand() {
        System.out.println("Player 2 hand: ");
        System.out.println(getPlayer2Deck());
    }

    public void clearHand(ArrayList<Card> cardArrayList) {
        cardArrayList.clear();
    }
}
